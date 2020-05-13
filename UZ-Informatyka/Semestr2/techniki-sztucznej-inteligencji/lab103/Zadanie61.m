% Zaimplementuj algorytm przeszukiwania grafu w g��b
A=[0 1 1 1 0 0 0 0; 0 0 0 0 1 1 0 0; 0 0 0 0 0 0 1 1; 0 0 0 0 0 0 0 0; 0 0 0 0 0 0 0 0; 0 0 0 0 0 0 0 0; 0 0 0 0 0 0 0 0; 0 0 0 0 0 0 0 0;]
A

G = digraph(A);
plot(G);

%przeszukiwanienw g��b DFS, ang. Depth-Firs Search

% wypisac wszystkie wierzcholki z macierzy sasiedztwa

% a) oznaczyc wszystkie wierzcholki jako nieodwiedzone

% b) odwied� wierzcho�ek v

% c) utworzyc kolejke FILO s�siad�w wierzcho�ka v

% d) zdejmij wierzcho�ek u z kolejki

% e) powtarzach kroki b) i d) dla wierzcho�ka u dop�ki kolejka nie jest pusta

% wypisanie wierzcholkow oraz sasiadow

[numRows,numCols] = size(A)
numRows
fprintf("Graf ma wierzcho�k�w: "+numRows)

for c = 1:numRows
    fprintf("\nOdwiedzilem wierzcholek: " +c);
    fprintf("\nSasiedzi wierzcholka: ");
    for k = 1:numCols
        fprintf(c+": "+k+"\n\n");
        fprintf("\n---------------------------------");
        fprintf(' %d \n',A(c,k));
        fprintf("\n---------------------------------");
    end
    
end

