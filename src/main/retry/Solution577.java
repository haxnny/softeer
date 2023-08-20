package main.retry;

import java.io.*;
import java.util.StringTokenizer;

public class Solution577 {

    public static int H, W, total_count;
    public static boolean[][] in, visited;

    public static void main(String[] agrs) throws IOException {
        System.setIn(new FileInputStream("src/main/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        in = new boolean[H+1][W+1];
        visited = new boolean[H+1][W+1];

        for(int i = 1; i <= H; i ++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            for(int j = 1; j <= W; j ++) {
                in[i][j] = (str.charAt(j) == '#' ? true : false);
                if(in[i][j]) total_count++;
            }
        }

        for(int i = 0; i < H; i ++) {
            for(int j = 0; j < W; j ++) {
                if(in[i][j] && isStartPosition(i, j)) { // 시작지점

                    for(int d = 0; d < 4; d ++) {
                        if(!isVisitedDir(i, j, d)) continue;

                    }
                }
            }
        }


        bw.flush();
        bw.close();
        br.close();

    }

    public static int[][] move = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public static boolean isStartPosition(int x, int y) {
        int count = 0;

        for(int[] m : move) {
            int nx = x + m[0];
            int ny = y + m[1];
            if(nx > 0 && nx < H+1 && ny > 0 && ny < W+1 && in[nx][ny]) {
                count++;
            }
        }

        return count == 1;
    }

    public static boolean isVisitedDir(int x, int y, int dir) {
        int[] m = move[dir];
        int nx = x + m[0];
        int ny = y + m[1];
        int nx2 = x + m[0]*2;
        int ny2 = y + m[1]*2;
        return (nx2 > 0 && nx2 < H+1 && ny2 > 0 && ny2 < W+1 && in[nx2][ny2] && in[nx][ny]);
    }
}
