import java.io.*;
import java.util.*;

public class Main {
	static int Y, X, ans=1;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int[][] map, dp;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[Y][X];
		dp = new int[Y][X];
		visited = new boolean[Y][X];
		for(int i=0; i<Y; i++) {
			String str = br.readLine();
			for(int j=0; j<X; j++) {
				if(str.charAt(j) == 'H') map[i][j] = 0;
				else map[i][j] = str.charAt(j) - 48;
			}
		}
		dp[0][0] = 1;
		dfs(0, 0, 1);
		for(int i=0; i<Y; i++) ans = Math.max(Arrays.stream(dp[i]).max().getAsInt(), ans);
		System.out.println(ans);
	}
	private static void dfs(int y, int x, int move) {
		visited[y][x] = true;
		for(int i=0; i<4; i++) {
			int cy = y + dy[i]*map[y][x];
			int cx = x + dx[i]*map[y][x];
			if(cy < 0 || cx < 0 || cy >= Y || cx >= X) continue;
			if(map[cy][cx] == 0) continue;
			if(dp[cy][cx] > move + 1) continue;
			if(visited[cy][cx]) {
				System.out.println(-1);
				System.exit(0);
			}
			dp[y][x] = Math.max(dp[cy][cx], move+1);
			dfs(cy, cx, move+1);
		}
		visited[y][x] = false;
	}
}
