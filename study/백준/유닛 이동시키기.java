import java.io.*;
import java.util.*;

public class Main {
	static int Y, X, A, B, K;
	static int sY, sX, eY, eX, ans = 9876;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int[][] map;
	static boolean[][] visited;
	
	static Queue<Rect> q = new LinkedList<>();
	static class Rect{
		int y, x, move;

		public Rect(int y, int x, int move) {
			this.y = y;
			this.x = x;
			this.move = move;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[Y][X];
		visited = new boolean[Y][X];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			map[a][b] = -1;
		}
		st = new StringTokenizer(br.readLine());
		sY = Integer.parseInt(st.nextToken()) - 1;
		sX = Integer.parseInt(st.nextToken()) - 1;
		q.offer(new Rect(sY, sX, 0));
		visited[sY][sX] = true;
		st = new StringTokenizer(br.readLine());
		eY = Integer.parseInt(st.nextToken()) - 1;
		eX = Integer.parseInt(st.nextToken()) - 1;
		
		map[eY][eX] = 1;
		bfs();
		System.out.println(ans == 9876 ? -1 : ans);
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			Rect rect = q.poll();
			
			for(int i=0; i<4; i++) {
				int cy = rect.y + dy[i];
				int cx = rect.x + dx[i];
				if(cy < 0 || cx < 0 || cy == Y || cx == X) continue;
				if(visited[cy][cx]) continue;
				if(!checking(cy, cx)) continue;
				visited[cy][cx] = true;
				
				if(map[cy][cx] == 1) {
					ans = rect.move+1;
					return;
				}
				q.offer(new Rect(cy, cx, rect.move + 1));
			}
			
		}
	}
	
	private static boolean checking(int cy, int cx) {
		for(int i=0; i<A; i++) {
			for(int j=0; j<B; j++) {
				if(cy + i >= Y || cx + j >= X) return false;
				if(map[cy+i][cx+j] == -1) return false;
			}
		}
		return true;
	}

}
