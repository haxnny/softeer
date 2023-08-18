package main;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] agrs) throws IOException {
        System.setIn(new FileInputStream("src/main/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Gold> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            // W 무게 가방에 M의 무게를 담아
            pq.add(new Gold(M, P));
        }

        int curr = 0, price = 0;
        while(curr < W) {
            Gold g = pq.poll();

            int posibleWeight = W - curr;
            if(posibleWeight < g.m) {
                price += posibleWeight * g.p;
                curr += posibleWeight;
            } else {
                price += g.m * g.p;
                curr += g.m;
            }
        }

        System.out.println(price);


        bw.flush();
        bw.close();
        br.close();

    }

    public static class Gold implements Comparable<Gold> {
        int m;
        int p;

        public Gold (int m, int p) {
            this.m = m;
            this.p = p;
        }

        @Override
        public int compareTo(Gold o) {
            return o.p - this.p; // 내림차순
        }

    }


}
