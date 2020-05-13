%test

A = [1 2; 4 5; 7 8];

B = [2 0 0; 0 2 0; 0 0 2];

C = [ 2 1 0];

D = [3 2 1; 0 5 6; 8 -1 2];

fprintf('------------------------------------------- \n')
Rozw1 = C*(B+D);
Rozw2 = C*B+C*D;
if(isequal(Rozw1, Rozw2))
    fprintf('tak \n')
end