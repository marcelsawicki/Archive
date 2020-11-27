.model
.stack

dane segment

dane ends

kod segment
assume cs:kod, ds:dane
start:
        mov ax, seg dane
        mov ds, ax

        mov ah, 4ch
        int 21h
kod ends
end start

