package main.practice.level3;

import java.io.*;
import java.util.StringTokenizer;

public class Solution389 {

    public static void main(String[] agrs) throws IOException {
        System.setIn(new FileInputStream("src/main/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] in = new int[N + 1];
        int[] sum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i ++) {
            in[i] = Integer.parseInt(st.nextToken());
            sum[i] = (i == 1 ? in[i] : sum[i-1] + in[i]);
        }

        for(int i = 1; i <= K; i ++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            double s = sum[B] - (A == 1 ? 0 : sum[A-1]);
            double c = B - A + 1;
            double avg = s / c;

            bw.write(String.format("%.2f\n", avg));
        }


        bw.flush();
        bw.close();
        br.close();

    }
}
