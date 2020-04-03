.model small
.data
x dw 154
y dw 100
kolor db 7
.code
start:
.486
	mov ax,seg x
	mov ds,ax
	mov ax,13h
	int 10h
	mov ax,0A000h
	mov es,ax
	mov ax,y
	mov di,ax
	shl di,8
	shl ax,6
	add di,ax
	add di,x
	mov al,kolor
	mov byte ptr es:[di],al

petla:
	in al,60h
	cmp al, 1
	jne petla
	mov ax,3
	int 10h
	mov ah,4ch
	int 21h
end start
end
