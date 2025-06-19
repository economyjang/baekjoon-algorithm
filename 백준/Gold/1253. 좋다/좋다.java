import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int totalCount = 0;

        for(int i = 0; i < length; i++){
            int target = arr[i];
            int left = 0;
            int right = length - 1;

            while(left < right) {
                if(left == i) {
                    left++;
                    continue;
                }
                if(right == i) {
                    right--;
                    continue;
                }

                int sum = arr[left] + arr[right];
                if(sum == target) {
                    totalCount++;
                    break;
                } else if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(totalCount);
    }
}