import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();

        // 윈도우 사이즈 결정
        for(int windowSize = 1; windowSize <= nums.length; windowSize++) {
            // 윈도우 시작 위치
            for(int windowStart = 0; windowStart < nums.length; windowStart++) {
                // 윈도우 총합
                int sum = 0;
                for(int windowIndex = 0; windowIndex < windowSize; windowIndex++) {
                    int index = (windowStart + windowIndex) % nums.length;
                    sum += nums[index];
                }

                set.add(sum);
            }
        }

        return set.size();
    }
}