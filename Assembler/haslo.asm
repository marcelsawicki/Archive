            
dane       SEGMENT

tekst      db "Podaj haslo: $"

tekst2     db "Haslo poprawne, zycze milego dnia$"

haslo      db "jakies haslo"                    ;poprawne haslo

kohas      db (?)

dane       ENDS



rozkazy    SEGMENT

assume     cs:rozkazy,ds:dane



poczatek:       mov ax,SEG dane

                mov ds,ax



                mov dx, OFFSET tekst

                mov ah,9

                INT 21h



                mov bx,0                ; zerowanie rejestrow

                mov di,0

                mov si,0

pob:            mov al,0

                mov cl,0

                mov ah,8                ; pobieranie znaku bez eha na ekranie

                int 21h         ; pobieramy az do momentu wcisniecia enter

                cmp al,13

                je wcis_ent

                cmp al,0                ; jesli jest klawisz rozszerzony

                jne dalej               ; pobierz jeszcze raz

                mov ah,8                ; to pobranie wykona sie automatycznie

                int 21h





dalej:  mov cl,al               ; backup al (wypisanie gwiazki zamaze al)

                mov dl,42               ; do dl dajemy kod ACSI *

                mov ah,2                ; i ja wyswietlamy

                INT 21h

                mov al,cl               ; odtworzenie al

                cmp al,haslo[di]        ; porownywanie poszczegolnych liter hasla

                jne blad

pow:            inc di          ; kolejny indeks liter stanowiacych haslo

                inc si          ; licznik ile wpisano znakow, bez tego program moglby

                                          ; przyjac haslo np.: jakies haslo

                jmp pob



wcis_ent:       cmp si,kohas-haslo      ;sprawdzenie dlugosci hasla

                jne zle

                cmp bx,0                ; i czy wszystkie znaki byly poprawne(bx == 0)

                                                    ; czy nie (bx != 0)

                jne zle



                mov dl,13               ; wpisanie entera

                mov ah,2

                INT 21h

                mov dl,10

                mov ah,2

                INT 21h



                mov dx,OFFSET tekst2

                mov ah,9

                INT 21h



koniec: mov al,0

                mov ah,4Ch

                INT 21h



blad:           inc bx          ; jezeli znak byl zly to zwiekszamy bx

                jmp pow



zle:            mov bx,0        ; procedurka restartujaca komputer, nie dziala w windows

                mov es,bx

                mov bx,0472

                mov word PTR es:[bx],1234h

                INT 19h



rozkazy    ENDS



stosik     SEGMENT stack

           db 128 dup(?)

stosik     ENDS



           END poczatek
