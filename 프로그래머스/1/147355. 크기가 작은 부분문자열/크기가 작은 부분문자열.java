class Solution {
    public int solution(String t, String p) {
        int count = 0;
        long pNum = Long.parseLong(p);
        int left = 0, right = p.length() - 1;

        while (right < t.length()) {
            String subString = t.substring(left, right + 1);
            long tNum = Long.parseLong(subString);

            if (tNum <= pNum) count++;

            left++;
            right++;
        }

        return count;
    }
}