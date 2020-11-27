.model small
.data
        napis1 db 6,?,?,?,?,?,?,'$'
        napis2 db 'wprowadziles nastepujacy lancuch:$'
.code
start:
        mov ax,seg napis1
        mov ds,ax

        lea dx,napis1
        mov ah,0Ah
        int 21h

        lea dx,napis2
        mov ah,9
        int 21h

        lea dx,napis1
        add dx,2
        int 21h

        mov ah,4ch
        int 21h
end start
end
