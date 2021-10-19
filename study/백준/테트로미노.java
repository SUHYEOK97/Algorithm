import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int Y,X,ANSWER;
	static int[] dy = {1, -1 ,0, 0}; // 하 상 좌 우
	static int[] dx = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[Y][X];
		check = new boolean[Y][X];
		
		for(int i=0; i<Y; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<X; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<Y; i++) {
			for(int j=0; j<X; j++) {
				check[i][j] = true;
				dfs(i, j, map[i][j], 1);
				find(i,j);
				check[i][j] = false;
			}
		}
		System.out.println(ANSWER);
	}
	
	private static void find(int y, int x) {
		int[] num = new int[4];
		if(y != 0) num[0] = map[y-1][x];
		if(y != Y-1) num[1] = map[y+1][x];
		if(x != 0) num[2] = map[y][x-1];
		if(x != X-1) num[3] = map[y][x+1];
		int sum = map[y][x];
		for(int i=0; i<4; i++) sum += num[i];
		sum -= Arrays.stream(num).min().getAsInt();
		ANSWER = Math.max(ANSWER, sum);
	}

	private static void dfs(int y, int x, int sum, int n) {
		if(n == 4) {
			ANSWER = Math.max(ANSWER, sum);
			return;
		}
		for(int i=0; i<4; i++) {
			int nY = y + dy[i];
			int nX = x + dx[i];
			if(nY < 0 || nX < 0 || nY == Y || nX == X || check[nY][nX]) continue;
			check[nY][nX] = true;
			dfs(nY, nX, sum + map[nY][nX], n + 1);
			check[nY][nX] = false;
		}
	}
	
}
