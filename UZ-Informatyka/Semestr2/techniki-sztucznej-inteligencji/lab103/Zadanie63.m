% Wykorzystujac polecenie dfsearch sprawd� poprawno�� dzia�ania algorytmu
% zaimplementowanego w zadaniu 1

A=[0 1 1 1 0 0 0 0; 0 0 0 0 1 1 0 0; 0 0 0 0 0 0 1 1; 0 0 0 0 0 0 0 0; 0 0 0 0 0 0 0 0; 0 0 0 0 0 0 0 0; 0 0 0 0 0 0 0 0; 0 0 0 0 0 0 0 0;]

G = digraph(A);
plot(G);
d = dfsearch(G,1,'allevents');
d