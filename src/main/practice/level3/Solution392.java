package main.practice.level3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution392 {

    public static void main(String[] agrs) throws IOException {
        System.setIn(new FileInputStream("src/main/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<Lecture> lectures = new ArrayList<>();

        for(int i = 1; i <= N; i ++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(s, f));
        }

        Collections.sort(lectures);

        int count = 0;
        int prev_finish_time = 0;
        for(Lecture l : lectures) {
            if(prev_finish_time <= l.start_time) {
                count++;
                prev_finish_time = l.finish_time;
            }
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();

    }

    public static class Lecture implements Comparable<Lecture> {
        int start_time;
        int finish_time;
        public Lecture(int s, int f) {
            this.start_time = s;
            this.finish_time = f;
        }

        @Override
        public int compareTo(Lecture o) {
            if(this.finish_time == o.finish_time) {
                return this.start_time - o.start_time;
            } else {
                return this.finish_time - o.finish_time;
            }
        }
    }
}
