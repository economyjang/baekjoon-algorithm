from collections import deque

n, k = map(int, input().split())

data = []
for _ in range(n):
    data.append(list(map(int, input().split())))

target_s, target_x, target_y = map(int, input().split())

virus = []
for x in range(n):
    for y in range(n):
        if data[x][y] != 0:
            virus.append((data[x][y], 0, x, y))

virus.sort()

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def bfs():
    queue = deque(virus)

    while queue:
        virus_num, time, x, y = queue.popleft()

        if target_s == time:
            break

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n:
                if data[nx][ny] == 0:
                    data[nx][ny] = virus_num
                    queue.append((virus_num, time + 1, nx, ny))

bfs()

if data[target_x - 1][target_y - 1] == 0:
    print(0)
else:
    print(data[target_x - 1][target_y - 1])


