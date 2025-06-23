import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aLength = Integer.parseInt(st.nextToken());
        int bLength = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[aLength];
        for(int i = 0; i < aLength; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] B = new int[bLength];
        for(int i = 0; i < bLength; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(A, B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb);
    }

    public static int[] solution(int[] A, int[] B) {
        int totalLength = A.length + B.length;
        int[] result = new int[totalLength];

        int idx = 0;
        int left = 0, right = 0;
        while(left < A.length && right < B.length) {
            if(A[left] == B[right]) {
                result[idx++] = A[left++];
            } else if(A[left] < B[right]) {
                result[idx++] = A[left++];
            } else {
                result[idx++] = B[right++];
            }
        }

        while(left < A.length) {
            result[idx++] = A[left++];
        }

        while(right < B.length) {
            result[idx++] = B[right++];
        }

        return result;
    }
}