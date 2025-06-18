import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int minLength = N + 1;
        int left = 0, right = 0, sum = 0;
        
        while (right < N) {
            sum += arr[right++];

            while (sum >= S) {
                minLength = Math.min(minLength, right - left);
                sum -= arr[left++];
            }
        }
        
        if(minLength == N + 1) {
          System.out.print(0);
        } else {
          System.out.print(minLength);   
        }
    }
}