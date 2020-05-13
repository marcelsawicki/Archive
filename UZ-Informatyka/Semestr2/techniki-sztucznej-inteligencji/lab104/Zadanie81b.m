% funkcja unipolarna skoku jednostkowego


fplot(@(y) skokowa(y), [-1 1])


function [y]=skokowa(x)
    y=0;
    if x==0 || x<0
        y=0;
        return;
    elseif x>0
        y=1;
        return;
    end
end