.model small
.code
start:
	mov ax,13h
	int 10h
	mov bx,0A000h
	mov es,bx
	mov di,0
py:
	mov al,0
px:
	stosb
	inc al
	cmp al,255
	jne px
	add di,65
	cmp di,63320
	jb py
czekaj_ESC:
	in al,60h
	cmp al,1
	jne czekaj_ESC
	mov ax,3
	int 10h
	mov ah,4ch
	int 21h
end start
end