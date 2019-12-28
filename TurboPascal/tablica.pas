Program Tablica;
uses crt;
// powyzszy przyklad z wykorzystaniem tablicy
var
    tab: array[1..6] of integer;
    i: byte;
    wynik: integer;
begin
clrscr;
    for i:=1 to 6 do
    begin
        writeln(i,': Podaj liczbe: ');
        readln(tab[i]);
        wynik:=wynik+tab[i];
    end;
    for i:=1 to 6 do
        writeln(i, ' - ', tab[i]);
    writeln('Suma liczb to ', wynik);
    readln;
end.
