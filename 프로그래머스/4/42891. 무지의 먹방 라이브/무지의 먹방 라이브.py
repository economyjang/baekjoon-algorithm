import heapq

def solution(food_times, k):
    if sum(food_times) <= k:
        return -1
    
    heap = []
    for idx, food_time in enumerate(food_times):
        heapq.heappush(heap, (food_time, idx + 1))

    total_sum = 0
    previous_time = 0
    length = len(food_times)

    while heap:
        if total_sum + (heap[0][0] - previous_time) * length > k:
            break

        now = heapq.heappop(heap)[0]
        total_sum += (now - previous_time) * length
        previous_time = now
        length -= 1

    result = sorted(heap, key=lambda x : x[1])
    
    return result[(k - total_sum) % length][1]