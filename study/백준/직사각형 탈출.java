import java.io.*;
import java.util.*;

public class Main {
	static int Y,X,H,W,sY,sX,eY,eX,ans=9876;
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
		map = new int[Y][X];
		visited = new boolean[Y][X];
		for(int i=0; i<Y; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<X; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		sY = Integer.parseInt(st.nextToken()) - 1;
		sX = Integer.parseInt(st.nextToken()) - 1;
		eY = Integer.parseInt(st.nextToken()) - 1;
		eX = Integer.parseInt(st.nextToken()) - 1;
		q.offer(new Rect(sY, sX, 0));
		map[eY][eX] = 2;
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
				
				if(map[cy][cx] == 2) {
					ans = rect.move+1;
					return;
				}
				q.offer(new Rect(cy, cx, rect.move + 1));
			}
		}
	}
	private static boolean checking(int cy, int cx) {
		if(cy + H > Y || cx + W > X) return false;
		for(int i=cy; i<cy+H; i++) {
			for(int j=cx; j<cx+W; j++) {
				if(map[i][j] == 1) return false;
			}
		}
		return true;
	}
}
