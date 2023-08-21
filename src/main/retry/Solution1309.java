package main.retry;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solution1309 {

    public static void main(String[] agrs) throws IOException {
        System.setIn(new FileInputStream("src/main/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] in = new int[3][N];
        for(int i = 0; i < 3; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j ++) {
                in[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] sum = new int[N];
        for(int i = 0; i < 3; i ++) {
            List<Integer> score = Arrays.stream(in[i]).boxed().collect(Collectors.toList());
            Collections.sort(score, Collections.reverseOrder());

            for(int j = 0; j < N; j ++) {
//                in[i][j]; // j 참가자가 i 대회에서 얻은 점수
                sum[j] += in[i][j];
                int grade = score.indexOf(in[i][j]) + 1;
                bw.write(String.format("%s ", grade));
            }
            bw.write("\n");
        }

        List<Integer> score = Arrays.stream(sum).boxed().collect(Collectors.toList());
        Collections.sort(score, Collections.reverseOrder());
        for(int j = 0; j < N; j ++) {
            int grade = score.indexOf(sum[j]) + 1;
            bw.write(String.format("%s ", grade));
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
