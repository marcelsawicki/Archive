# File: System10na2.py

def System10na2(n):
  if n ==0:
    lista=[0]
  else:
    lista=[]
    while n > 0:
      lista=[n % 2] + lista
      n=n // 2
  for r in lista:
    print(r, end=" ")

System10na2(4444444)