import java.util.Scanner;

public class MainTwo {

	static int Min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] inputArr = new int[N][N];
		boolean[] visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				inputArr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		dfs(0, N, visit, 0, inputArr);
		System.out.println(Min);
	}

	public static void dfs(int depth, int N, boolean[] visit, int start, int[][] inputArr) {
		if (depth > 0) {
			int sumA = 0;
			int sumB = 0;
			int result = 0;

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (visit[i] && visit[j]) {
						sumA += inputArr[i][j] + inputArr[j][i];
					} else if (!visit[i] && !visit[j]) {
						sumB += inputArr[i][j] + inputArr[j][i];
					}
				}
				result = Math.abs(sumA - sumB);

			}

			if (Min == 0) {
				System.out.println(Min);
				System.exit(0);
			}

			Min = Math.min(result, Min);
			
		
		}
		
		if (depth == N) {
			return;
		}

		for (int i = start; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				dfs(depth + 1, N, visit, i + 1, inputArr);
				visit[i] = false;
			}
		}
	}
	
}
