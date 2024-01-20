package CH01_탐색_PART1_que.C03week;

import java.util.*;
import java.io.*;

public class BOJ_1260 {

    static ArrayList<Integer>[] list;
    static int n, m, v;
    static boolean[] visit;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        answer = new int[n];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        for (int i = 1; i < n + 1; i++) {
            Collections.sort(list[i]);
        }

        dfs(v);
        sb.append("\n");

        visit = new boolean[n + 1];
        bfs(v);

        System.out.println(sb);

    }

    private static void dfs(int start) {
        visit[start] = true;
        sb.append(start).append(" ");

        for (int a : list[start]) {
            if (!visit[a]) {
                dfs(a);
            }
        }

    }

    private static void bfs(int start) {
        que.offer(start);
        visit[start] = true;

        while(!que.isEmpty()){
            int a = que.poll();
            sb.append(a).append(" ");

            for(int x : list[a]){
                if (!visit[x]){
                    que.offer(x);
                    visit[x] = true;
                }
            }
        }


    }
}
