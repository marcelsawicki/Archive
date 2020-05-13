echo off
SET name=Basket_352x288_30

SET input=%name%.yuv

SET frames=4

SET QPlist=05

echo on

FOR %%A IN (%QPlist%) DO TAppEncoder -c encoder_randomaccess_main.cfg -c config.cfg -i %input% -f %frames% -b %name%_QP_%%A.bin -q %%A -o %name%_QP_%%A.yuv > Wynik_%name%_QP_%%A.txt


echo %input% DONE

pause