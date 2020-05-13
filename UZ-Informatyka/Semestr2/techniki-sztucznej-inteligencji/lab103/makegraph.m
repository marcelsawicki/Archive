function [ A,H ] = makegraph( map )
s = size(map);
gsize = prod(s);
g = zeros(gsize);
map(map==0)=Inf;
for i=1:gsize-s(1)-1
    if(mod(i,s(1))==0) 
        continue;
    end;
    window = [map(i:i+1);map(i+s(1):i+s(1)+1)];
    g(i,i+1) = sum(window(1,:));
    g(i,i+s(1)) = sum(window(:,1));
    g(i,i+s(1)+1) = sum(diag(window));
end;
A = g;
H = zeros(size(A));
for i=1:gsize
    for j=1:gsize
        ri = mod(i,s(1));
        rj = mod(j,s(1));
        di = floor(i/s(1));
        dj = floor(j/s(1));
        H(i,j) = sqrt((rj-ri)^2+(dj-di)^2);
    end;
end;
end

