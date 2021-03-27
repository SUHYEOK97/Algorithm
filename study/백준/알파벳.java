import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {-1, 1, 0, 0}; 
	static int[] dx = {0, 0, -1, 1};
	static int Y,X,ans;
	static char[][] c;
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		visited = new boolean[Y][X];
		c = new char[Y][X];
		
		for(int i=0; i<Y; i++) c[i] = br.readLine().toCharArray();
		visited[0][0] = true;
		sb.append(c[0][0]);
		dfs(0, 0, 1);
		System.out.println(ans);
	}
	private static void dfs(int y, int x, int move) {
		ans = Math.max(ans, move);
		for(int i=0; i<4; i++) {
			int cy = y + dy[i];
			int cx = x + dx[i];
			if(cy < 0 || cx < 0 || cy == Y || cx == X) continue;
			if(visited[cy][cx] || sb.indexOf(c[cy][cx]+"") != -1) continue;
			visited[cy][cx] = true;
			sb.append(c[cy][cx]);
			dfs(cy, cx, move + 1);
			sb.deleteCharAt(sb.length()-1);
			visited[cy][cx] = false;
		}
		
	}
	
}
