import java.io.*;
import java.util.*;

public class Main {
	static int Y, X, ans;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static char[][] map;
	static boolean[][] visited;
	static Queue<int[]> start = new LinkedList<>();
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new char[Y][X];
		for(int i=0; i<Y; i++) {
			String str = br.readLine();
			for(int j=0; j<X; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'L') start.add(new int[] {i, j});
			}
		}
		while(!start.isEmpty()) {
			int[] o = start.poll();
			q.offer(new int[] {o[0], o[1]});
			visited = new boolean[Y][X];
			visited[o[0]][o[1]] = true;
			bfs();
		}
		System.out.println(ans);
	}
	private static void bfs() {
		int level = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int t=0; t<qSize; t++) {
				int[] o = q.poll();
				
				for(int i=0; i<4; i++) {
					int ny = o[0] + dy[i];
					int nx = o[1] + dx[i];
					if(ny < 0 || nx < 0 || ny == Y || nx == X) continue;
					if(visited[ny][nx]) continue;
					if(map[ny][nx] == 'W') continue;
					visited[ny][nx] = true;
					q.offer(new int[] {ny, nx});
				}
			}
			level++;
		}
		ans = Math.max(ans, level-1);
	}
}
