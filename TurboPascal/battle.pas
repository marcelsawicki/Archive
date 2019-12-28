Program rpg;
uses
	crt;
const 
	ile_zdarzen=14;
type 
    r_zdarzenia = ( wrog, nieznajomy, przedmiot, nic );
	r_nieznajomego = ( zlodziej, dobry_d, zly_d, czarodziej );
	r_przedmiotu = ( miecz, zbroja, eliksir, mieso, zloto, trucizna );

zdarzenie = record
				opis: string;
				prawdo: integer;
				case rodzaj: r_zdarzenia of
								wrog: ( sila: integer );
								przedmiot: ( rzecz: r_przedmiotu );
								nieznajomy: ( kto: r_nieznajomego );
				end;
bohater = record
                wytrzymalosc: integer;
                sila: integer;
                bagaz: set of r_przedmiotu;
                zloto: integer;
          end;
const 
	hero: bohater = ( wytrzymalosc: 4; sila: 4; bagaz: []; zloto: 0);
	swiat: array[1..ile_zdarzen] of zdarzenie = (
	(opis:'nic'; prawdo:40; rodzaj:wrog; sila:1),
	(opis:'oblesny gnom'; prawdo:10; rodzaj:wrog; sila:2),
	(opis:'wielki smok'; prawdo:5; rodzaj:wrog; sila:7),
    (opis:'straszny troll'; prawdo:10; rodzaj:wrog; sila:3),
    (opis:'zlodzieja'; prawdo:1; rodzaj:nieznajomy; sila:1),
    (opis:'czarodzieja'; prawdo:6; rodzaj:nieznajomy; sila:1),
    (opis:'dobrego duszka'; prawdo:5; rodzaj:nieznajomy; sila:1),
    (opis:'zlego ducha'; prawdo:5; rodzaj:nieznajomy; sila:1),
    (opis:'miecz'; prawdo:2; rodzaj:przedmiot; sila:1),
    (opis:'zbroje'; prawdo:2; rodzaj:przedmiot; sila:1),
    (opis:'magiczny eliksir'; prawdo:4; rodzaj:przedmiot; sila:1),
    (opis:'sztuke miesa'; prawdo:4; rodzaj:przedmiot; sila:1),
    (opis:'zloto'; prawdo:5; rodzaj:przedmiot; sila:1),
    (opis:'trucizne'; prawdo:3; rodzaj:przedmiot; sila:1)
	);

nazwa_p: array [miecz..trucizna] of string = ('miecz', 'zbroja', 'eliksir', 'mieso', 'zloto', 'trucizna');
var
	ile: integer;
	klawisz: char;

Procedure opisz_bohatera;
var	przed: r_przedmiotu;
begin
	clrscr;
	writeln('Wtrzymalosc: ', hero.wytrzymalosc, ', Sila: ', hero.sila, ', Zloto: ', hero.zloto);
	write('Bagaz: ');
	for przed:=miecz to trucizna do
		if przed in hero.bagaz then
			write(nazwa_p[przed],' ');
	writeln;
	writeln('*******************************');
end;

procedure spotkaj_wroga( kto: zdarzenie );
var
	sila: integer;
	pieniadz: integer;
	ekwipunek: integer;
	decyz: char;
	walka: boolean;
begin
	ekwipunek:=0;
	sila:=random(6)+kto.sila;
	writeln('Zza krzkow wyskoczyl ', kto.opis, ' o sile ', sila);
	writeln('W]alczysz, U]ciekasz, N]egocjujesz?');
	decyz:=upcase(readkey);
	walka:=true;
	
    if decyz='U' then
		begin
			if hero.sila>random(6) then
				begin
					writeln('Udalo ci sie ujsc z zyciem.');
					walka:=false;
				end
			else
				writeln('Zostales zlapany.');
		end;

	if decyz='N' then
				begin
					write('Ile zlota proponujesz za uwolnienie?');
					readln(pieniadz);
					if(pieniadz > (sila+random(5))*5)and(pieniadz<hero.zloto) then
						begin
							writeln('Twoja propozycja zostala przyjeta.');
							walka:=false;
							hero.zloto:=hero.zloto-pieniadz;
						end
					else writeln('Propozycja zostala odrzucona. Czeka cie walka.');
				end;
				
		if walka then
			begin
				writeln('Atakujesz...');
				if miecz in hero.bagaz then
					ekwipunek:=ekwipunek+2;
				if sila >= hero.sila+ekwipunek+random(6) then
					begin
					writeln('Przegrywasz');
					if (zbroja in hero.bagaz) and (random(6)>3) then
						writeln('Jednak chroni Cie zbroja.')
					else
						begin
							hero.wytrzymalosc:=hero.wytrzymalosc-1;
							hero.zloto:=hero.zloto div 3;
						end
					end
			else
				begin
					writeln('Wygrywasz');
					hero.zloto:=hero.zloto+sila+5;
				end
			end;
end;

procedure spotkaj_nieznajomego(ktos: zdarzenie);
begin
	writeln('Spotkales ', ktos.opis);
	case ktos.kto of
		zlodziej: begin
					hero.zloto:=0;
					hero.bagaz:=[];
				end;
		dobry_d: hero.sila:=hero.sila+1;
		zly_d: if hero.sila>0 then hero.sila:=hero.sila-1;
		czarodziej: hero.wytrzymalosc:=hero.wytrzymalosc+1;
	end;
end;

procedure znajdz_przedmiot(co: zdarzenie);
var	
	los: integer;
begin
	writeln('Znalazles ', co.opis);
	los:=random(20)+20;
	
	case co.rzecz of
		miecz: hero.bagaz:= hero.bagaz+[miecz];
		zbroja: hero.bagaz:= hero.bagaz+[zbroja];
		eliksir: hero.wytrzymalosc:=hero.wytrzymalosc+1;
		mieso: hero.sila:=hero.sila+1;
		zloto: hero.zloto:=hero.zloto+1;
		trucizna: 
			begin
				hero.wytrzymalosc:= hero.wytrzymalosc div 2;
				hero.sila:= hero.sila div 2;
			end;
	end;
end;

begin
	randomize;
	opisz_bohatera;
	while hero.wytrzymalosc>0 do
		begin
            ile:=1;
            repeat
                if random(100) < swiat[ile].prawdo then
                begin
                    case swiat[ile].rodzaj of
                        wrog: spotkaj_wroga(swiat[ile]);
                        nieznajomy: spotkaj_nieznajomego(swiat[ile]);
                        przedmiot: znajdz_przedmiot(swiat[ile]);
                    end;
                    writeln('I]dziesz dalej. K]onczysz gre');
                    klawisz:=readkey;
                    if upcase(klawisz)='K' then
                        hero.wytrzymalosc:=0
                       else
                       opisz_bohatera;
                    end;
                    ile:=ile+1;
              until (ile>ile_zdarzen) or (hero.wytrzymalosc<1);
		end;
	writeln('Koniec gry');
	if hero.zloto>1000 then
		writeln('Wygrales');
	klawisz:=readkey;
end.