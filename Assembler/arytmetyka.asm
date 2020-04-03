.model small
.stack 24h
.data 
	liczba dd 180080d  ;wypisuje te liczbe
	dzielnik dd 10d
	licznik dw 0
	napis db 'oto liczba: $'
.code
start:
	.486
	mov ax,seg liczba
	mov ds,ax
	;odlozenie na stos cyfr liczby
	mov eax,liczba ;przenies liczbe do eax
	
petla:
	mov edx,0
	div dzielnik
	
	push dx  		;reszta na stos (reszta z przedzialu 0..9)
	inc licznik 	;zliczanie cyfr liczby
	cmp ax,0
	jne petla		;czy zakonczyc? jesli wynik = 0, to tak
	
	;wypisane liczby
	mov ah,9
	mov dx,offset napis
	int 21h
	mov cx,licznik 	;ile cyfr do wpisania
	
wypisz:
	pop dx
	add dx, 48
	
	mov ah,2
	int 21h
	loop wypisz
	mov ah,4ch
	int 21h
end start
end