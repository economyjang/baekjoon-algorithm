from collections import deque

def solution(priorities, location):
    answer = 0

    queue = deque([(i, p) for i, p in enumerate(priorities)])
    result = []

    while len(queue) > 0:
        max_priority = max(queue, key=lambda x: x[1])[1]
        ele = queue.popleft()

        if(ele[1] >= max_priority):
            result.append(ele[0])
        else:
            queue.append(ele)

    answer = result.index(location) + 1
    return answer