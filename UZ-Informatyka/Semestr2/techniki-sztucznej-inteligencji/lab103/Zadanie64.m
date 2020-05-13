% Wykorzystujac polecenie dfsearch sprawdŸ poprawnoœæ dzia³ania algorytmu
% zaimplementowanego w zadaniu 1

A=[0 1 1 1 0 0 0 0; 0 0 0 0 1 1 0 0; 0 0 0 0 0 0 1 1; 0 0 0 0 0 0 0 0; 0 0 0 0 0 0 0 0; 0 0 0 0 0 0 0 0; 0 0 0 0 0 0 0 0; 0 0 0 0 0 0 0 0;]

G = digraph(A);
plot(G);
b = bfsearch(G,1,'allevents');
b