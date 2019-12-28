Program Algorytmy1;

uses crt;

var
        b: integer;
        k: integer;
        j: integer;
        a: array [1..5] of integer;

begin

    k:=0;
    a[1]:=10;
    a[2]:=9;
    a[3]:=8;
    a[4]:=7;
    a[5]:=6;
    b:=4;

    repeat
        k:=k+1;
        writeln('wartosc w tablicy: ',a[k]);
        j:=b mod 2;
        a[k]:=j;
        writeln('nowa wartosc w tablicy',a[k]);
        writeln('moje j:',j);
        writeln('moje b:',b);
        b:=b div 2;
        writeln('moje b po podzieleniu:', b);
        readkey();
    until b=0;
    readkey();
end.
