board_size = int(input())

# 보드 크기 설정
board = [[0] * (board_size + 1) for _ in range(board_size + 1)]

# 사과 위치 설정
# 사과는 1로 표시
apple_count = int(input())
for i in range(apple_count):
    a, b = map(int, input().split())
    board[a][b] = 1

direction_info_count = int(input())
direction_info_dict = {}
for i in range(direction_info_count):
    direction = list(input().split())
    if not direction_info_dict.get(int(direction[0])):
        direction_info_dict[int(direction[0])] = direction[1]

# 방향 변환 설정 (90도) - 동 남 서 북
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def turn(direction, c):
    if c == 'L': # 왼쪽
        direction = (direction - 1) % 4
    else: # 오른쪽
        direction = (direction + 1) % 4
    return direction

def simulate():
    # 1초마다 뱀 머리 위치로 이동
    # 벽에 닿는지 & 꼬리에 닿는지 확인
    # 사과가 있는지 확인
    # 사과가 있으면 꼬리를 늘림
    
    x, y = 1, 1
    board[x][y] = 2 # 뱀 위치를 2로 표시
    direction = 0
    time = 0
    q = [(x, y)] # 뱀이 차지하고 있는 위치 정보(꼬리가 앞쪽)
    while True:
        nx = x + dx[direction]
        ny = y + dy[direction]

        # 맵이 범위 안에 있고, 뱀의 몸통이 없는 위치   
        if 1 <= nx and nx <= board_size and 1 <= ny and ny <= board_size and board[nx][ny] != 2:
            if board[nx][ny] == 0:
                board[nx][ny] = 2
                q.append((nx, ny))
                px, py = q.pop(0)
                board[px][py] = 0
            
            if board[nx][ny] == 1:
                board[nx][ny] = 2
                q.append((nx, ny))
        # 맵의 범위 밖에 있거나, 뱀의 몸통과 부딪혓다면
        else:
            time += 1
            break

        # 뱀을 다른 위치로 이동
        x, y = nx, ny
        time += 1

        # 회전할 시간일 경우 회전 시킴
        if direction_info_dict.get(time):
            direction = turn(direction,  direction_info_dict.get(time))
        
    return time

print(simulate())