package CH01_탐색_PART1_que.C03week;

import java.util.*;
import java.io.*;

public class BOJ_2178 {

    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] cha = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = cha[j] - '0';
            }
        }

        bfs(0,0);



        for(int[] a : arr){
            for(int b : a){
                System.out.print(b);
            }
            System.out.println();
        }

    }

    private static void bfs(int x, int y) {
        Queue<Integer> que = new LinkedList<>();

        que.offer(arr[x][y]);
        visit[x][y] = true;

        while (!que.isEmpty()){

            int a = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                    continue;
                }
                if(arr[nx][ny] != 0 && !visit[nx][ny]){
                    arr[nx][ny] = a + 1;
                    que.offer(arr[nx][ny]);
                    visit[nx][ny] = true;
                }
            }
        }

    }
}
