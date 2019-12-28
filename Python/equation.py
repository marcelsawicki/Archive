import math

def Rowkwad(a,b,c):
	print("Rozwiazanie rownania kwadratowego")
	if a == 0:
		print("To nie jest rownianie kwadratowe")
	else:
		delta=b*b-4*a*c
	if delta<0:
		print("Rownanie nie ma pierwiastkow rzeczywistych")
	else:
		print("Pierwiastki rownania kwadratowego:")
		delta=math.sqrt(delta)
		if b<0:
			x2=(-b+delta)/(2*a)
			print("x1 = ", c/(a*x2), "x2 = ", x2)
		else:
			x1=(-b-delta)/(2*a)
			print("x1 = ", x1, "x2 = ", c/(a*x1))
			
Rowkwad(1,5,2)
Rowkwad(3,2,1)