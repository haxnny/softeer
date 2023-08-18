package main.practice.level1;

import java.io.*;
import java.util.StringTokenizer;

public class Solution990 {

    public static void main(String[] agrs) throws IOException {
        System.setIn(new FileInputStream("src/main/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = 0;
        for(int i = 0; i < 5; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = String.valueOf(st.nextToken());
            String e = String.valueOf(st.nextToken());

            int s_hour = Integer.parseInt(s.split(":")[0]);
            int s_min = Integer.parseInt(s.split(":")[1]);
            int e_hour = Integer.parseInt(e.split(":")[0]);
            int e_min = Integer.parseInt(e.split(":")[1]);

            total += ((e_hour - s_hour) * 60 + (e_min - s_min));
        }
        System.out.println(total);


    }

}
