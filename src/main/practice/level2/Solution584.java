package main.practice.level2;

import java.io.*;
import java.util.StringTokenizer;

public class Solution584 {

    public static int N, M, MAX = 0;
    public static int[] distances, speeds;

    public static void main(String[] agrs) throws IOException {
        System.setIn(new FileInputStream("src/main/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distances = new int[N];
        speeds = new int[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            distances[i] = Integer.parseInt(st.nextToken());
            speeds[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int distance = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            for(int m = 0; m < N; m ++) {
                if(distances[m] == 0) continue;
                compareDist(m, distance, speed);
                break;
            }
        }

        bw.write(MAX + "\n");

        bw.flush();
        bw.close();
        br.close();

    }

    public static void compareDist(int m, int distance, int speed) {
        if(distances[m] > distance) {
            distances[m] -= distance;
        } else if(distances[m] < distance) {
            if(m+1 < N) {
                compareDist(m+1, distance - distances[m], speed);
            }
            distances[m] = 0;
        } else {
            distances[m] = 0;

        }
        MAX = Math.max(MAX, speed - speeds[m]);
    }


}
