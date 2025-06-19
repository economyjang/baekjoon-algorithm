import java.io.*;
import java.util.*;

public class Main {
    static int[] current = new int[4];
    static int[] required = new int[4];

    static int dnsStrLength = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int strLength = Integer.parseInt(st.nextToken());
        int subStrLength = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        char[] charArr = st.nextToken().toCharArray();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < dnsStrLength; i++) {
            required[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < subStrLength; i++) {
            add(charArr[i]);
        }

        int totalCount = 0;
        if(isValid()) totalCount++;

        for(int i = subStrLength; i < strLength; i++) {
            add(charArr[i]);
            remove(charArr[i - subStrLength]);
            if(isValid()) totalCount++;
        }

        System.out.println(totalCount);
    }

    static void add(char c) {
        switch(c) {
            case 'A': current[0]++; break;
            case 'C': current[1]++; break;
            case 'G': current[2]++; break;
            case 'T': current[3]++; break;
        }
    }

    static void remove(char c) {
        switch(c) {
            case 'A': current[0]--; break;
            case 'C': current[1]--; break;
            case 'G': current[2]--; break;
            case 'T': current[3]--; break;
        }
    }

    static boolean isValid() {
        for(int i = 0; i < dnsStrLength; i++) {
            if(current[i] < required[i]) return false;
        }

        return true;
    }
}