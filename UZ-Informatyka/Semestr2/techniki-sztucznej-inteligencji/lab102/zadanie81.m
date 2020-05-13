%test

A = [1 2; 4 5; 7 8];

B = [2 0 0; 0 2 0; 0 0 2];

C = [ 2 1 0];

D = [3 2 1; 0 5 6; 8 -1 2];

size(D)
size(B)

fprintf('------------------------------------------- \n')
V1 = B + D; 
disp(V1);
V2 = 3*A;
disp(V2);
V3= -2*C;
disp(V3);

fprintf('Rozmiar B \n')
disp(size(B));
fprintf('Rozmiar A \n')
disp(size(A));
fprintf('Wynik mnozenia B * A \n')
V4 = B * A;
disp(V4);

fprintf('Wynik mnozenia D * B \n')

sizeD = size(D);
sizeB = size(B);

if(sizeD(:,2)==sizeD(:,1))
    fprintf('mozna mnozyc \n')
    V5 = D * B;
    disp(V5);
else
    fprintf('nie mozna mnozyc macierzy D i B \n')
end

fprintf('wynik 2A + B - C \n')
if(size(A)==size(B)==size(C))    
    V6 = 2*A + B - C;
    disp(V6)
else
    fprintf(' nie moge wykonac dzialanai 2A+B-C \n')
end

% liczba wierszy do liczby kolumn macierzy


sizeC= size(C);
sizeD= size(D);
if(sizeC(:,1)==sizeD(:,2))
    if(sizeD(:,1)==sizeC(:,2))
        V7 = C*D - D*C;
        disp('wynik C*D - DC ');
        disp(V7);
    else
        fprintf('(2) nie moge wykonac dzialanai CD - DC \n');
    end
else
    fprintf('(1) nie moge wykonac dzialanai CD - DC \n')
end

fprintf('wynik dzialania 2B-D \n')
V8 = 2*B-D;
disp(V8);


fprintf('wynik dzialania DD \n')
V9 = D*D;
disp(V9);

fprintf('wynik dzialania BB + DD \n')
V10 = B*B + D*D;
disp(V10);

fprintf('wynik dzialania 4A \n')
V11 = 4*A;
disp(V11);

fprintf('wynik dzialania AB \n')
sizeA= size(A);
sizeB= size(B);
if(sizeA(:,2)==sizeB(:,1))
    V12 = A*B;
    disp(V12);
else
    fprintf('nie moge wykonac dzialania AB \n')
end

fprintf('wynik dzialania B*B \n')
V13 = B*B;
disp(V13)

fprintf('wynik dzialania A*A \n')
%V14 = A*A;
%disp(V14)

fprintf('wynik dzialania C/C \n')
V15 = C/C;
disp(V15);
