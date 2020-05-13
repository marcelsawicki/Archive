% zadanie 87
A = [1 2; 4 5; 7 8];

B = [2 0 0; 0 2 0; 0 0 2];

C = [ 2 1 0];

D = [3 2 1; 0 5 6; 8 -1 2];


funcA = ~ismatrix(A) || (size(A, 1) ~= size(A, 2));

if(funcA)
    disp(trace(A));
end
disp(trace(B));
%disp(trace(C));
disp(trace(D));