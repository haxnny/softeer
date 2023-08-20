package main.practice.level2;

import java.io.*;
import java.util.StringTokenizer;

public class Solution413 {

    public static void main(String[] agrs) throws IOException {
        System.setIn(new FileInputStream("src/main/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // 0 :
        // 1 : (3*1) + (1*2) -> ((2^n)+1)*(2^(n-1)) + (2^(n-1))*((2^(n-1))+1)
        // 2 : (5*2) + (2*3) -> ((2^n)+1)*(2^(n-1)) + (2^(n-1))*((2^(n-1))+1)
        // 3 : (9*4) + (4*5) -> ((2^n)+1)*(2^(n-1))
        // 4 : (17*8)+ (8*9) -> ((2^n)+1)*(2^(n-1))

        int point = 4;
        for(int i = 1; i <= N; i ++) {
            int add = (int) ((Math.pow(2, i)+1) * (Math.pow(2, i-1)) + (Math.pow(2, i-1)) * (Math.pow(2, i-1) + 1));
            point += add;
        }


        System.out.println(point);

        bw.flush();
        bw.close();
        br.close();

    }

}
