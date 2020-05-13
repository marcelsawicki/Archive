% sprawdzic dzialanie biasu na przyk³adzie funkcji liniowej
% (y = ax + b) i skoku jednostkowego (hardlim(x+b)).
% Narysowac wykresy dla wszystkich b = {-1, -0.3, 0.4, 1}
% wykorzystujac dodatkowe parametry polecenia plot.

b = [ -1 -0.3 0.4 1];



hardlim(x+b)
fplot(@(x) 2*x+b)
