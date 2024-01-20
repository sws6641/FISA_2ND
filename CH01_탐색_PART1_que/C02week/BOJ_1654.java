package CH01_탐색_PART1_que.C02week;

import java.util.*;
import java.io.*;

public class BOJ_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];

        long max = 0;

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        max++; // 이분 탐색을 위해 최대값에 1을 더해줌(탐색 시 범위문제)

        long start = 0; // 탐색을 시작 길이
        long mid = 0; // 중간 길이
        long end = max;

        while (start < end) {
            mid = (start + end) / 2;

            long count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }

            if (count < n) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start - 1);

    }
}
