from itertools import combinations

map_size, chicken_count = map(int, input().split())
chicken, house = [], []

for r in range(map_size):
    data = list(map(int, input().split()))

    for c in range(map_size):
        if data[c] == 1:
            house.append((r, c))
        elif data[c] == 2:
            chicken.append((r, c))

candidates = list(combinations(chicken, chicken_count))

def get_sum(candidate):
    result = 0

    for hx, hy in house:
        temp = 1e9

        for cx, cy in candidate:
            temp = min(temp, abs(hx- cx) + abs(hy- cy))
        
        result += temp

    return result

result = 1e9
for candidate in candidates:
    result = min(result, get_sum(candidate))

print(result)

