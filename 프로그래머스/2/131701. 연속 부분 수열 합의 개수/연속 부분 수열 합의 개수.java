import java.util.*;

class Solution {
    public int solution(int[] arr) {
       Set<Integer> sumSet = new HashSet<>();

        // 윈도우 사이즈
        for(int windowSize = 1; windowSize <= arr.length; windowSize++) {
            // 윈도우 시작
            for(int windowStart = 0; windowStart < arr.length; windowStart++) {
                // sum
                int sum = 0;
                for(int windowIdx = windowStart; windowIdx < windowSize + windowStart; windowIdx++) {
                    sum += arr[windowIdx % arr.length];
                }

                sumSet.add(sum);
            }
        }

        return sumSet.size(); 
    }
}