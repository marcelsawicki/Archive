;code by jasper/stc
JUMPS
.386
ASSUME	cs:CODE,ss:STACKS
 
CODE	SEGMENT USE16
ile_pix	equ 50*60		;ilosc punktow
dist	dw 340			;odleglosc od obserwatora
d_x	dw 160 			;korekcja X
d_y	dw 100			;korekcja Y
xc	dw 0			;zmienne
yc	dw 0			;pomocnicze
poz	dw 0			;ktora elipsa
liccol	dw 0			;licznik koloru
color	dw 16			;kolor
 
Begin:
	mov	ax,0013h
	int	10h		;ustaw tryb 13h 320x200x256c
	call	Koloobs
	mov	dx,seg tunelpal	;\
	mov	ds,dx		; >ustaw
	lea	si,tunelpal	; >palete
	call	Paleta		;/
MAIN: 
        call    Przesun		;kopiuj dane do tablicy pomocniczej
        call    Pers		;oblicz perspektywe
        call    Rysuj		;rysuj punkty
        call    Zmien		;zmien strone
	call	Czysc		;czysc bufor
	call	Rusz		;przesun elipsy
	call	Dopeli		;dopisz elipse
	add	poz,4		;\
	cmp	poz,4*1000	; \
	jb	okpoz		;  >zmiena pozycji
	mov	poz,0		; /
Okpoz:				;/
	call	Rotuj		;rotuj tablice obs
        mov     ah,01h 
        int     16h 
        jz      MAIN		;czekaj na klawisz
Koniec:
        mov     ax,0003h
        int     10h		;ustaw tryb tekstowy
        mov     ax,4c00h
        int     21h		;wyjscie do DOSu

Zmien	PROC			;kopiuj zawartosc bufora na ekran  
	mov	dx,seg bufor
	mov	ds,dx		;czytaj z bufora
	mov	si,0
	mov	dx,0a000h
	mov	es,dx		;zapisuj na ekran
	mov	di,0
	mov	eax,0
	mov	cx,64000/4	;64000 bajty
	cld
	rep	movsd		;kopiuj
	ret
Zmien	ENDP
Czysc	PROC			;czysc bufor
	mov	dx,seg bufor	;\
	mov	es,dx		; >adres bufora
	mov	di,0		;/
	xor	eax,eax		;czysc kolorem zerowym
	mov	cx,64000/4	;bufor ma dlugosc 64000 bajtow
	rep	stosd		;czysc
	ret
Czysc	ENDP
Rysuj	PROC			;rysuj punkty
	push	color
	mov	liccol,0
	mov	dx,seg bufor
	mov	es,dx		;rysuj w buforze
	mov	dx,seg wsp2d	;\
	mov	ds,dx		; >tablica w wspolrzednymi punktow
	lea	si,wsp2d	;/
	mov	cx,ile_pix	;rysuj ile_pix punktow
Ryspunkt:
	mov	bp,ds:[si]	;wspolrzedna X
	mov	ax,ds:[si][2]	;wspolrzedna Y
	cmp	bp,0		;\
	jl	bezp		; \
	cmp	bp,319		;  \
	jg	bezp		;   >sprawdz czy punkt
	cmp	ax,0		;   >miesci sie na ekranie
	jl	bezp		;  /
	cmp	ax,199		; /
	jg	bezp		;/
	xchg	ah,al		;\
	add	bp,ax		; >oblicz
	shr	ax,2		; >320*y+x
	add	bp,ax		;/
	mov	ax,color	;kolor punktu
	mov	es:[bp],al	;postaw punkt
Bezp:
	add	si,4
	inc	liccol
	cmp	liccol,60	;czy bylo juz 60 punktow?
	jne	niecol		;nie
	mov	liccol,0	;tak
	inc	color		;nastepny kolor
Niecol:
	loop	ryspunkt	;nastepny punkt
	pop	color
	inc	color		;nastepny kolor
	cmp	color,16+50
	jb	okcolor
	mov	color,16
Okcolor:
	ret
Rysuj	ENDP
Rusz	PROC			;przesun elipsy
	mov	dx,seg elipsa	;\
	mov	ds,dx		; \
	mov	es,dx		;  >adres tablicy elipsa
	lea	si,elipsa	; /
	lea	di,elipsa	;/
	add	si,6*60		;zacznij od drugiej elipsy
	mov	cx,6*60*49	;przesun 49 elips
	rep	movsb		;przesuwaj
	ret
Rusz	ENDP
Dopeli	PROC			;dopisz nowa elipse
	mov	dx,seg elipsa	;\
	mov	ds,dx		; >wspolrzedne elips
	lea	si,elipsa	;/
	mov	cx,ile_pix
Er:
	mov	ax,ds:[si][4]
	sub	ax,6		;zmniejsz wspolrzedna Z o 6
	mov	ds:[si][4],ax
	add	si,6
	loop	er

	mov	dx,seg kolo
	mov	ds,dx
	lea	si,kolo
	add	si,poz
	lodsw			;odczytaj korekcje X
	mov	xc,ax
	lodsw			;odczytaj korekcje Y
	mov	yc,ax
	mov	dx,seg eli	;tablica z
	mov	ds,dx		;jedna elipsa
	mov	dx,seg elipsa	;tablica
	mov	es,dx		;wszystkich elips
	lea	si,eli
	lea	di,elipsa
	add	di,6*60*49	;dopisz elipse na konicu
	mov	cx,60
Eloip:
	lodsw
	add	ax,xc		;wprowadz korekte X
	stosw
	lodsw
	add	ax,yc		;wprowadz korekte Y
	stosw
	movsw
	loop	eloip
	mov	dx,seg obs	;\
	mov	es,dx		; >tablica kolejnych korekt XY
	lea	di,obs		;/
	mov	ax,xc
	stosw
	mov	ax,yc
	stosw
	ret
Dopeli	ENDP
Pers	PROC			;oblicz perspektywe
	mov	cx,ile_pix	;obliczenia dla ile_pix punktow
	mov	dx,seg wsp3d
	mov	ds,dx		;czytaj z tablicy wsp3d
	lea	si,wsp3d
	mov	dx,seg wsp2d
	mov	es,dx		;zapisuj do tablicy wsp2d
	lea	di,wsp2d
	lea	bp,obs
;Perspektywa
Obroc:
	mov	bx,ds:[si][4]	;wczytaj wspolrzedna Z
	add	bx,dist		;dodaj odleglosc od obserwatora
;wspolrzedna X
	mov	ax,ds:[si]	;wczytaj wspolrzedna X
	sub	ax,ds:[bp]
	movsx	dx,ah
	shl	ax,8		;pomnoz przez 256
	idiv	bx		;podziel przez Z+Dist
	add	ax,d_x		;korekcja X
	stosw
;wspolrzedna Y
	mov	ax,ds:[si][2]	;wczytaj wspolrzedna Y
	sub	ax,ds:[bp][2]
	movsx	dx,ah
	shl	ax,8		;pomnoz przez 256
	idiv	bx		;podziel przez Z+Dist
	add	ax,d_y		;korekcja Y
	stosw
        add     si,6
	loop	obroc		;powtarzaj ile_pix razy
	ret
Pers	ENDP
Przesun	PROC			;skopiuj dane do tablicy pomocniczej
        mov     dx,seg elipsa
        mov     ds,dx		;z tablicy elipsa
        lea     si,elipsa
        mov     dx,seg wsp3d
        mov     es,dx		;do tablicy wsp3d
        lea     di,wsp3d
        mov     cx,ile_pix 
        mov     bx,cx 
        add     cx,bx 
        add     cx,bx 
        cld 
        rep     movsw		;kopiuj
        ret 
Przesun	ENDP
Rotuj	PROC			;rotuj tablice korekcji XY
	mov	dx,seg obs	;\
	mov	ds,dx		; \
	mov	es,dx		;  >adres tablicy
	lea	si,obs		; /
	lea	di,obs		;/
	mov	cx,49		;przesun 49 wartosci
	cld
	lodsd			;odczytaj pierwsza wartosc
	rep	movsd
	stosd			;zapisz pierwsza wartosc
	ret
Rotuj	ENDP
Koloobs	PROC			;wypelnij tablice korekcji XY
	mov	dx,seg kolo
	mov	ds,dx
	lea	si,kolo
	mov	dx,seg obs	;\
	mov	es,dx		; >tablica korekcji XY
	lea	di,obs		;/
	cld
	lodsd			;wczytaj pierwsza wartosc korekcji
	mov	cx,50		;wypelnij 50 miejsc
	rep	stosd		;wypelniaj
	ret
Koloobs	ENDP
Paleta	PROC			;ustawianie palety DS:SI-rzadana paleta
	mov	cx,256*3	;ustaw 256 kolorow
	mov	dx,3c8h
	mov	al,0		;zacznij od zerowego
	out	dx,al
	inc	dx
	cld
	rep	outsb		;wysylaj dane do portu
	ret
Paleta	ENDP

wsp3d	dw ile_pix dup(0,0,0)	;tablica na wspolrzedne 3d
wsp2d	dw ile_pix dup(0,0)	;tablica na wspolrzedne 2d
obs	dw 50 dup(0,0)		;tablica korekcji XY
CODE	ENDS 
 
DATA	SEGMENT USE16
elipsa	dw ile_pix dup(0,0,0)	;tablica wszystkich elips
Eli:
include elipsa.inc		;dolacz wspolrzedne elipsy
Kolo:
include trasa.inc		;dolacz trase tunelu
Tunelpal:
include tunel.pal		;dolacz palete
DATA	ENDS 

BUF	SEGMENT USE16
Bufor	dw 32000 dup(0)		;zdefiniuj bufor
BUF	ENDS

STACKS	SEGMENT USE16 STACK 'STACK'
db 512	dup(0)			;i stos
STACKS	ENDS
 
END	Begin