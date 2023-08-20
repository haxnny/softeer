package main.retry;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution409 {

    public static int N;
    public static int[][] in;
    public static boolean[][] visited;
    public static int[][] adj = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] agrs) throws IOException {
        System.setIn(new FileInputStream("src/main/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        in = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            String data = String.valueOf(st.nextToken());

            for(int j = 0; j < N; j ++) {
                in[i][j] = data.charAt(j) - '0';
            }
        }

        List<Integer> count = new ArrayList<>();
        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j ++) {
                if(in[i][j] == 0) continue;
                if(visited[i][j]) continue;

                count.add(move(i, j, 1));
            }
        }

        Collections.sort(count);
        bw.write(count.size() + "\n");
        for(int c : count) {
            bw.write(c + "\n");
        }


        bw.flush();
        bw.close();
        br.close();

    }

    public static int move(int x, int y, int count) {
        if(visited[x][y]) return 0;
        visited[x][y] = true;

        if(in[x][y] == 0) return 0;

        for(int[] m : adj) {
            int nextX = x + m[0], nextY = y + m[1];
            if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                count += move(nextX, nextY, count);
            }
        }

        return count;
    }

}
