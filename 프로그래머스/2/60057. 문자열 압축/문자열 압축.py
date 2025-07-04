def solution(s):
    answer = len(s)

    for step in range(1, len(s) // 2 + 1):
        compressed = ""
        step_str = s[0:step]
        repeat_count = 1

        for i in range(step, len(s), step):
            if step_str == s[i:i+step]:
                repeat_count += 1
            else:
                compressed += str(repeat_count) + step_str if repeat_count >= 2 else step_str
                step_str = s[i:i+step]
                repeat_count = 1

        compressed += str(repeat_count) + step_str if repeat_count >= 2 else step_str
        answer = min(answer, len(compressed))
    return answer
