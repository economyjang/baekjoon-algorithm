from itertools import combinations

n, m = map(int, input().split())
chicken = [] # 좌표 
house = [] # 좌표

for x in range(n):
    data = list(map(int, input().split()))

    for y in range(n):
        if data[y] == 1:
            house.append((x + 1, y + 1))
        elif data[y] == 2:
            chicken.append((x + 1, y + 1))

candidates = list(combinations(chicken, m))

def get_sum(candidate):
    result = 0

    for house_x, house_y in house:
        temp = 1e9
        for chicken_x, chicken_y in candidate:
            temp = min(temp, abs(house_x - chicken_x) + abs(house_y - chicken_y))

        result += temp

    return result


result = 1e9
for candidate in candidates:
    result = min(result, get_sum(candidate))

print(result)