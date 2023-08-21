package main.practice.level3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution804 {

    public static void main(String[] agrs) throws IOException {
        System.setIn(new FileInputStream("src/main/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String message = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String key = st.nextToken();

        char[][] in = new char[5][5];
        boolean[] visited = new boolean[26];

        int index = 0;
        for(int i = 0; i < key.length(); i ++) {
            int char_index = key.charAt(i) - 'A';
            if(visited[char_index]) continue;

            int x = index / 5;
            int y = index % 5;
            in[x][y] = key.charAt(i);
            visited[char_index] = true;
            index++;
        }

        if(index < 25) {
            for(int i = 0; i < 26; i ++) {
                if(index == 25) break;
                if('J' - 'A' == i) continue;
                if(visited[i]) continue;
                int x = index / 5;
                int y = index % 5;
                in[x][y] = (char) (i + 'A');
                index++;
            }
        }

        List<char[]> encrypt = new ArrayList<>();
        // 두글자씩 나누고, 같은 숫자 연속인 경우 사이에 X 추가, 연속인 경우가 X면 사이에 Q 추가, 마지막 한글자는 X 추가
        for(int i = 0; i < message.length(); i ++) {
            char first = message.charAt(i);

            if(i == message.length() - 1) { // 마지막 한글자
                encrypt.add(new char[]{first, 'X'});
            } else {
                char second = message.charAt(i+1);
                if(first == second) {
                    encrypt.add(new char[]{first, (first == 'X' ? 'Q' : 'X')});
                } else {
                    encrypt.add(new char[]{first, second});
                    i ++; // 두칸뒤로
                }
            }
        }

        for(char[] word : encrypt) {
            char f = word[0], s = word[1];
            int fx = 0, fy = 0, sx = 0, sy = 0;
            for(int i = 0; i < 5; i ++) {
                for(int j = 0; j < 5; j ++) {
                    if(in[i][j] == f) {
                        fx = i;
                        fy = j;
                    }
                    if(in[i][j] == s) {
                        sx = i;
                        sy = j;
                    }
                }
            }

            int nfx = 0, nfy = 0, nsx = 0, nsy = 0;
            // 1.같은 행인 경우 (x) : 오른쪽 한칸이동 , y==4 -> 0으로
            if(fx == sx) {
                nfx = fx;
                nsx = sx;
                nfy = (fy < 4 ? fy + 1 : 0);
                nsy = (sy < 4 ? sy + 1 : 0);
            } else if (fy == sy) {
            // 2. 같은 열인 경우 (y) : 아래쪽 한칸이동, x==4 -> 0으로
                nfx = (fx < 4 ? fx + 1 : 0);
                nsx = (sx < 4 ? sx + 1 : 0);
                nfy = fy;
                nsy = sy;
            } else {
                nfx = fx;
                nfy = sy;
                nsx = sx;
                nsy = fy;
            }

            bw.write(String.format("%s%s", in[nfx][nfy], in[nsx][nsy]));
        }


        bw.flush();
        bw.close();
        br.close();

    }
}
