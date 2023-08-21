package main.practice.level3;

import java.io.*;
import java.util.StringTokenizer;

public class Solution581 {
    public static int N, M, K;
    public static int[] weights, n_weights;

    public static int total_weight = 0;
    public static int min_weight = Integer.MAX_VALUE;

    public static void main(String[] agrs) throws IOException {
        System.setIn(new FileInputStream("src/main/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 레일의 개수
        M = Integer.parseInt(st.nextToken());   // 택배 바구니 무게
        K = Integer.parseInt(st.nextToken());   // 일의 시행 횟수

        weights = new int[N];
        n_weights = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i ++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        n_weights = weights.clone();
        perm(n_weights, 0);

        System.out.println(min_weight);


        bw.flush();
        bw.close();
        br.close();

    }

    public static void perm(int[] arr, int index) {
        if(index == N) return;

        simulation(n_weights[0], 1, 1);
        min_weight = Math.min(min_weight, total_weight);
        total_weight = 0;

        for(int i = index; i < N; i ++) {
            swap(arr, index, i);
            perm(arr, index + 1);
            swap(arr, index, i);
        }
    }

    public static void swap(int[] arr, int index, int i) {
        int temp = arr[index];
        arr[index] = arr[i];
        arr[i] = temp;
    }

    // weights[0], 1, 1
    public static void simulation(int sum, int index, int try_count) {
        if(try_count > K) return;

        int nextIndex = (index + 1 == N ? 0 : index + 1);
        if(sum + n_weights[index] <= M) {
            simulation(sum + n_weights[index], nextIndex, try_count);
        } else {
            total_weight += sum;
            simulation(n_weights[index], nextIndex, try_count+1);
        }
    }

}
