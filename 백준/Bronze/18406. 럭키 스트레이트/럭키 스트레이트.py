s = list(str(input()))

mid = int(len(s) / 2)
front_sum = sum(list(map(int, s[:mid])))
back_sum = sum(list(map(int, s[mid:])))

if front_sum == back_sum:
    print("LUCKY")
else:
    print("READY")