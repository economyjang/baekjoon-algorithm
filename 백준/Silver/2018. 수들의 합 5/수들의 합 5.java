import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int result = solution(target);
        System.out.println(result);
    }

    public static int solution(int target) {
        int count = 0;
        int left = 1, right = 1, sum = 1;

        while (left <= target) {
            if (sum == target) {
                count++;
                sum -= left++;
            } else if (sum < target) {
                sum += ++right;
            } else {
                sum -= left++;
            }
        }

        return count;
    }
}