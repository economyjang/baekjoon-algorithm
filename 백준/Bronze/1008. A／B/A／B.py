from decimal import Decimal, getcontext

getcontext().prec = 32
A, B = map(Decimal, input().split())

print(A / B)