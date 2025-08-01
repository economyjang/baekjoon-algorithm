n = int(input())

for i in range(n):
    start_count = i + 1
    for _ in range(start_count):
        print('*', end="")
    print('')