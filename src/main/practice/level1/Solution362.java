package main.practice.level1;

import java.io.*;
import java.util.*;

public class Solution362 {

    public static void main(String[] agrs) throws IOException {
        System.setIn(new FileInputStream("src/main/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= T; i ++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bw.write(String.format("Case #%s: %s \n", i, A+B));
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
