package main.practice.level2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution408 {

    public static void main(String[] agrs) throws IOException {
        System.setIn(new FileInputStream("src/main/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] in = new int[8];
        int[] ascending = {1,2,3,4,5,6,7,8};
        int[] descending = {8,7,6,5,4,3,2,1};
        for(int i = 0; i < 8; i ++) {
            in[i] = Integer.parseInt(st.nextToken());
        }

        if(Arrays.equals(in, ascending)) {
            System.out.println("ascending");
        } else if(Arrays.equals(in, descending)) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }

    }


}
