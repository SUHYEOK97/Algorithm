import java.util.Scanner;

public class Solution {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int ans;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ans = 1;
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				arr[i][j] = sc.nextInt();

		for (int day = 1; day <= 100; day++) {
			int[][] check = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					check[i][j] = arr[i][j];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (check[i][j] <= day) {
						check[i][j] = -1;
					}
				}
			}
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (check[i][j] != -1) {
						cheese(check, i, j);
						cnt++;
					}
				}
			}
			ans = cnt > ans ? cnt : ans;
		}
		System.out.println(ans);
	}

	public static void cheese(int[][] check, int y, int x) {
		check[y][x] = -1;
		for (int i = 0; i < 4; i++) {
			int curX = x + dx[i];
			int curY = y + dy[i];
			if (curX == n || curY < 0 || curX < 0 || curY == n)
				continue;
			if (check[curY][curX] != -1) {
				cheese(check, curY, curX);
			}
		}
	}
}
