import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());

        st = new  StringTokenizer(br.readLine());
        int[] arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long result = solution(arr, length);
        System.out.println(result);
    }

    /*
    길이가 N인 수열이 주어질 때, 수열에서 연속한 1개 이상의 수를 뽑았을 때 같은 수가 여러 번 등장하지 않는 경우의 수를 구하는 프로그램을 작성하여라.

    첫 번째 줄에는 수열의 길이 N이 주어진다. (1 ≤ N ≤ 100,000)
    두 번째 줄에는 수열을 나타내는 N개의 정수가 주어진다. 수열에 나타나는 수는 모두 1 이상 100,000 이하이다.

    조건을 만족하는 경우의 수를 출력한다.
     */

    public static long solution(int[] nums, int length) {
        long result = 0;

        Set<Integer> set = new HashSet<>();
        int start = 0, end = 0;
        while(start < length){
            while(end < length && !set.contains(nums[end])){
                set.add(nums[end]);
                end++;
            }

            result += end - start;

            set.remove(nums[start]);
            start++;
        }

        return result;
    }
}