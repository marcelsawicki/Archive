% Zaimplementuj algorytm przeszukiwania grafu w g³¹b
A=[0 1 1 1 0 0 0 0; 0 0 0 0 1 1 0 0; 0 0 0 0 0 0 1 1; 0 0 0 0 0 0 0 0; 0 0 0 0 0 0 0 0; 0 0 0 0 0 0 0 0; 0 0 0 0 0 0 0 0; 0 0 0 0 0 0 0 0;]
A

G = digraph(A);
plot(G);

%przeszukiwanienw g³¹b DFS, ang. Depth-Firs Search

% wypisac wszystkie wierzcholki z macierzy sasiedztwa

% a) oznaczyc wszystkie wierzcholki jako nieodwiedzone

% b) odwiedŸ wierzcho³ek v

% c) utworzyc kolejke FILO s¹siadów wierzcho³ka v

% d) zdejmij wierzcho³ek u z kolejki

% e) powtarzach kroki b) i d) dla wierzcho³ka u dopóki kolejka nie jest pusta

% wypisanie wierzcholkow oraz sasiadow

[numRows,numCols] = size(A)
numRows
fprintf("Graf ma wierzcho³ków: "+numRows)

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

