% zadanie 85
x = [1,2,3,4];
y = [4,3,2,1];

fprintf("wynik dzialania z  =x.*y \n");
z  =x.*y;
disp(z);

fprintf("wynik dzialania z  =x.\\y \n");
z  =x.\y;
disp(z);

fprintf("wynik dzialania z  =x.^y \n");
z  =x.^y;
disp(z);

fprintf("wynik dzialania z  =x.^2 \n");
z  =x.^2;
disp(z);

fprintf("wynik dzialania z  =2.^[x,y] \n");
z  =2.^[x,y];
disp(z);