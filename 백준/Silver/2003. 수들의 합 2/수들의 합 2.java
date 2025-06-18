import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arrLength = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[arrLength];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrLength; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 0;
        
        int left = 0, right = 0, sum = 0;
        while(right < arrLength) {
            sum += arr[right];
            right++;
            
            while(sum > target) {
                sum -= arr[left];
                left++;
            }
            
            if(sum == target) {
                answer++;
            }
        }
        
        System.out.print(answer);
    }
}