;addition of two 8 bit hexadecimal numbers.
assume cs: code, ds: data

data segment
num1 db 4ah
num2 db 0aah
sum db ?
data ends

code segment
start:
	mov ax, data
	mov ds, ax
	mov ax, 0000h
	mov bx, 0000h
	mov al, num1
	mov bl, num2
	add al,bl
	mov sum,al
	mov ah, 4ch
	int 21h
	code ends
	end start