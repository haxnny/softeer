package main.practice.level2;

import java.io.*;
import java.util.StringTokenizer;

public class Solution624 {

    public static void main(String[] agrs) throws IOException {
        System.setIn(new FileInputStream("src/main/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int[] gray_zero = {6, 2, 5, 5, 4, 5, 6, 4, 7, 6};
        int[][] changes = {
             /** 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 */
                {0, 4, 3, 3, 4, 3, 2, 2, 1, 2},
                {4, 0, 5, 3, 2, 5, 6, 2, 5, 4},
                {3, 5, 0, 2, 5, 4, 3, 5, 2, 3},
                {3, 3, 2, 0, 3, 2, 3, 3, 2, 1},
                {4, 2, 5, 3, 0, 3, 4, 2, 3, 2},
                {3, 5, 4, 2, 3, 0, 1, 3, 2, 1},
                {2, 6, 3, 3, 4, 1, 0, 4, 1, 2},
                {2, 2, 5, 3, 2, 3, 4, 0, 3, 2},
                {1, 5, 2, 2, 3, 2, 1, 3, 0, 1},
                {2, 4, 3, 1, 2, 1, 2, 2, 1, 0},
        };

        for(int i = 0; i < T; i ++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            int aZeroLen = 5 - A.length(), bZeroLen = 5 - B.length();

            int count = 0;
            for(int k = 0; k < 5; k ++) {
                int x = (k < aZeroLen ? -1 : Integer.parseInt(String.valueOf(A.charAt(k - aZeroLen))));
                int y = (k < bZeroLen ? -1 : Integer.parseInt(String.valueOf(B.charAt(k - bZeroLen))));

                if(x != -1 && y != -1) {
                    count += changes[x][y];
                } else {
                    if(x == -1 && y == -1) continue;

                    if(x == -1) {
                        count += gray_zero[y];
                    } else {
                        count += gray_zero[x];
                    }
                }
            }

            bw.write(count + "\n");
        }


        bw.flush();
        bw.close();
        br.close();

    }

}
