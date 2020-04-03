.model tiny
.data
        napis db 'programowac kazdy moze $'
.code
start:
        mov ax, seg napis
        mov ds, ax
        mov dx, offset napis
        mov ah, 9
        int 21h
        mov ah, 4ch
        int 21h
end start
end
