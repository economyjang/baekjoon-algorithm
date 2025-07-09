# (x + 1, y), (x + 1, y + 1)
n = int(input())
data = []

for _ in range(n):
    data.append(list(map(int, input().split())))

for x in range(1, n):
    for y in range(len(data[x])):
        left_up = 0
        up = 0

        if 0 <= x - 1 < n and 0 <= y < len(data[x - 1]):
            up = data[x - 1][y]

        if 0 <= x - 1 < n and 0 <= y - 1 < len(data[x - 1]):
            left_up = data[x - 1][y - 1]

        data[x][y] = data[x][y] + max(up, left_up)

print(max(data[n - 1]))