import heapq

n = int(input())
nums = []
for _ in range(n):
    nums.append(int(input()))

result = 0

heapq.heapify(nums)

while len(nums) > 1:
    a = heapq.heappop(nums)
    b = heapq.heappop(nums)

    sum_value = a + b
    result += sum_value

    heapq.heappush(nums, sum_value)

print(result)