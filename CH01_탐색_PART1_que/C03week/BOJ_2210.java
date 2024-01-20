package CH01_탐색_PART1_que.C03week;

import java.util.*;
import java.io.*;

public class BOJ_2210 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static int[] answer = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, 0);
            }
        }


        System.out.println(set.size());

    }

    private static void dfs(int x, int y, int cnt, int idx) {
        if (idx == 6) {
            for (int a : answer){
                sb.append(a);
            }
            set.add(sb.toString());
            sb.delete(0, sb.length());
            return;
        }

        answer[idx] = arr[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                continue;
            }
            dfs(nx, ny, cnt + 1, idx + 1);

        }

    }
}
