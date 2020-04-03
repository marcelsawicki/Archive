; Marcel Sawicki 2019-05-03
; JMP - skok bezwarunkowy
.model small
.data
	napis1 db ' To jest pierwszy napis $'
	napis2 db ' To jest drugi napis $'
.code
start:
	mov ax, seg napis1
	mov ds, ax
	mov ah, 9
	mov dx, offset napis1
	int 21h
	jmp przeskocz
	mov ah,9
	mov dx, offset napis2
	int 21h
przeskocz:
	mov ah, 4ch
	int 21h
end start
end