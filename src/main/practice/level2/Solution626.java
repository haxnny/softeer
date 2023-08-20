package main.practice.level2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution626 {

    public static void main(String[] agrs) throws IOException {
        System.setIn(new FileInputStream("src/main/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 회의실 수
        int M = Integer.parseInt(st.nextToken());

        List<String> names = new ArrayList<>();
        boolean[][] time = new boolean[N][9];   // 회의실 인덱스 / 시간

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            names.add(st.nextToken());
        }
        Collections.sort(names);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int index = names.indexOf(st.nextToken());
            int s = Integer.parseInt(st.nextToken()) - 9;
            int t = Integer.parseInt(st.nextToken()) - 9;

            for(int j = s; j < t; j ++) {
                time[index][j] = true;
            }
        }

        for(int i = 0; i < N; i ++) {
            bw.write(String.format("Room %s: \n", names.get(i)));

            int count = 0;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < 9; j ++) {
                if(time[i][j]) continue;
                count++;

                int next = check(j+1, time[i]);

                sb.append((j == 0 ? "09" : j+9));
                sb.append(String.format("-%s\n", next));
                j = (next - 9);
            }

            bw.write(count == 0 ? "Not available\n" : String.format("%s available:\n", count));
            bw.write(sb.toString());
            if(i != N-1) bw.write("-----\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static int check(int start, boolean[] time) {
        if(start < 9 && !time[start]) return check(start+1, time);
        return start + 9;
    }

}
