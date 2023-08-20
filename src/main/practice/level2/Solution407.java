package main.practice.level2;

import java.io.*;
import java.util.StringTokenizer;

public class Solution407 {

    public static void main(String[] agrs) throws IOException {
        System.setIn(new FileInputStream("src/main/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long total = K;
        for(int i = 1; i <= N; i++) {
            total *= (P);
            total %= 1000000007;
        }

        System.out.println(total);

//        bw.flush();
        bw.close();
        br.close();

    }
}
