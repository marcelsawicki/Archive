1 print chr$ (147): v=53248: poke v+33,0 
2 for x=12800 to 12927: poke x,0: next x
5 print chr$(147) 
10 v=53248: rem basisaddresse des VIC
11 poke v+21,4: rem sprite 2 aktiviren
12 poke 2042,13: rem daten fuer sprite 2 aus blk 13
20 for n=0 to 62: read q: poke 832+n,q: next
30 for x=0 to 255 
40 poke v+4,x: rem neue x-koordinate
50 poke v+5,100: rem neue y-koordinate
60 next x 
70 goto 30
200 data 0,127,0,1,255,192,3,255,224,3,231,224
210 data 7,217,240,7,223,240,7,217,240,3,231,224
220 data 3,255,224,3,255,224,2,255,160,1,127,64
230 data 1,62,64,0,156,128,0,156,128,0,73,0,0,73,0,0
240 data 62,0,0,62,0,0,62,0,0,28,0