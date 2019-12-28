# This program prints Hello, world!

print('Hello, world!')

fruits = ["apple", "banana", "cherry"]

# For loop
for x in fruits:
	print(x)
  
def sayHello(): 
	print("Hello from a function")

sayHello()

def Funk1_2(x):
	print("Wartosc funkcji (1.2)")
	print("dla x =", x, end=" ")
	print("rowna sie =", end=" ")
	if x > 0:
		print(1)
	elif x == 0:
		print(0)
	else:
		print(-1)

Funk1_2(1)
Funk1_2(0)
Funk1_2(-15)