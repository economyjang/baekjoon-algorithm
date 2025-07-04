s = input()

count0 = 0
count1 = 0

if s[0] == '0':
    count0 += 1
elif s[0] == '1':
    count1 += 1

for i in range(1, len(s)):
    if s[i] != s[i - 1]:
        if s[i] == '0':
            count0 += 1
        elif s[i] == '1':
            count1 += 1

print(min(count0, count1))