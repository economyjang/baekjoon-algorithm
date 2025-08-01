data = list(map(int, input().split()))

sum = 0

for num in data:
    sum += (num ** 2)

result = sum % 10

print(result)