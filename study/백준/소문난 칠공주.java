import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,1,-1};
	static char[][] map;
	static boolean[][] visited, check;
	static int ans;
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		check = new boolean[5][5];
		for(int i=0; i<5; i++) {
			String str = br.readLine();
			for(int j=0; j<5; j++) map[i][j] = str.charAt(j);
		}
		dfs(0, 0);
		System.out.println(ans);
	}
	private static void dfs(int idx, int cnt) {
		if(cnt == 7) {
			bfs();
			return;
		}
		for(int i=idx; i<25; i++) {
			int y = i / 5;
			int x = i % 5;
			if(check[y][x]) continue;
			check[y][x] = true;
			dfs(i + 1, cnt + 1);
			check[y][x] = false;
		}
		
	}
	private static void bfs() {
		q.clear();
		visited = new boolean[5][5];
		out : for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) if(check[i][j]) {
				q.offer(new int[] {i, j});
				visited[i][j] = true;
				break out;
			}
		}
		int cnt = 1;
		int cntY = 0;
		while(!q.isEmpty()) {
			int[] o = q.poll();
			if(cntY >= 4) return;
			for(int i=0; i<4; i++) {
				int ny = dy[i] + o[0];
				int nx = dx[i] + o[1];
				if(ny < 0 || nx < 0 || ny == 5 || nx == 5) continue;
				if(!check[ny][nx]) continue;
				if(visited[ny][nx]) continue;
				visited[ny][nx] = true;
				q.offer(new int[] {ny, nx});
				cnt++;
			}
		}
		if(cnt == 7) {
			int count = 0;
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					if(visited[i][j] && map[i][j] == 'S') count++;
				}
			}
			if(count > 3) ans++;
		}
	}
}
