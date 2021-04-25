import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map, dp;
	static boolean[][] visited;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,1,-1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		map = new int[N][N];
		dp = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = 1;
			}
		}
		int ans = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				ans = Math.max(ans, dfs(i,j));
			}
		}
		for(int i=0; i<N; i++) System.out.println(Arrays.toString(dp[i]));
		System.out.println(ans);
	}
	private static int dfs(int y, int x) { // 가장 긴 부분을 찾고 저장.
		if(dp[y][x] != 1) return dp[y][x];
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny < 0 || nx < 0 || ny == N || nx == N) continue;
			if(map[ny][nx] >= map[y][x]) continue;
			dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
		}
		return dp[y][x];
	}
}
