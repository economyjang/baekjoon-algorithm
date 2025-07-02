def solution(numbers):
    answer = ''
    
    str_arr = list(map(str, numbers))
    str_arr.sort(key=lambda x : x*3, reverse=True)
    answer = ''.join(str_arr)
    
    return '0' if answer[0] == '0' else answer
