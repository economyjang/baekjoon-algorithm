class Solution {
    public int solution(String t, String p) {
        int result = 0;

        long pNum = Long.parseLong(p);
        int windowSize = p.length();
        int originSize = t.length();

        int left = 0, right = windowSize - 1;
        while(right < originSize) {
            String subNumStr = t.substring(left, right + 1);
            Long subNum = Long.parseLong(subNumStr);
            if(subNum <= pNum) result++;

            left++;
            right++;
        }

        return result;
    }
}