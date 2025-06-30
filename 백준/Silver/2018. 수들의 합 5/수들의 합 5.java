import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        int result = solution(target);
        System.out.println(result);
    }

    /*
    어떠한 자연수 N은, 몇 개의 연속된 자연수의 합으로 나타낼 수 있다.
    당신은 어떤 자연수 N(1 ≤ N ≤ 10,000,000)에 대해서, 이 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다. 이때, 사용하는 자연수는 N이하여야 한다.
    예를 들어, 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5의 4가지가 있다. 반면에 10을 나타내는 방법은 10, 1+2+3+4의 2가지가 있다.
    N을 입력받아 가지수를 출력하는 프로그램을 작성하시오.

    입력된 자연수 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 출력하시오

    "연속된" 자연수의 합
     */

    public static int solution(int target) {
        int result = 0;

        int left = 1, right = left + 1, sum = 0;
        sum += left;

        while (left < right) {
            if (sum == target) {
                result++;
                sum -= left++;
                sum += right++;
            } else if (sum < target) {
                sum += right++;
            } else {
                sum -= left++;
            }
        }

        return result;
    }
}