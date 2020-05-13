%zadanie86

A = [1 1 3; 1 3 2; 3 2 1];
B = [0 0 1; 1 0 0; 0 1 0];
C  =[3 2 2; 1 -1 1; 2 3 1];

fprintf("wynik dzialania A(:,1) \n");
disp(A(:,1));

fprintf("wynik dzialania A(2,:) \n");
disp(A(2,:));

fprintf("wynik dzialania A(:,2:3) \n");
disp(A(:,2:3));

fprintf("wynik dzialania A(2:3,2:3) \n");
disp(A(2:3,2:3));

fprintf("wynik dzialania A(:,1:2:3) \n");
disp(A(:,1:2:3));

fprintf("wynik dzialania A(2:3) \n");
disp(A(2:3));

fprintf("wynik dzialania A(:) \n");
disp(A(:));

fprintf("wynik dzialania A(:,:) \n");
disp(A(:,:));

fprintf("wynik dzialania ones(2,2) \n");
disp(ones(2,2));

fprintf("wynik dzialania zeros(2,2) \n");
disp(zeros(2,2));

fprintf("wynik dzialania eye(2) \n");
disp(eye(2));

fprintf("wynik dzialania A*[ones(1,2);eye(2)] \n");
disp(A*[ones(1,2);eye(2)]);

fprintf("wynik dzialania diag(A) \n");
disp(diag(A));

fprintf("wynik dzialania diag(A,1) \n");
disp(diag(A,1));

fprintf("wynik dzialania diag(A,-1) \n");
disp(diag(A,-1));

fprintf("wynik dzialania diag(A,2) \n");
disp(diag(A,2));