import sys

lines = sys.stdin.read().splitlines()
n = int(lines[0])
words = lines[1:]

words = list(set(words))
words.sort(key=lambda x: (len(x), x))

print('\n'.join(words))