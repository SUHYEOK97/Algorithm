import java.io.*;
import java.util.*;

public class Main {
	static int Y,X,SIZE,ans=999999;
	static int[][] map, check;
	static boolean[][] visited;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static int[][] direction = {{1,0,0,0},{0,1,0,1},{1,1,0,0},{1,1,1,0},{1,1,1,1}};
	static ArrayList<Point> points = new ArrayList<>();
	static class Point{
		int y,x;
		int[] dir;
		public Point(int y, int x, int[] dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[Y][X];	visited = new boolean[Y][X];	check = new int[Y][X];
		for(int i=0; i<Y; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<X; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0 && map[i][j] < 6) {
					points.add(new Point(i, j, direction[map[i][j]-1]));
					check[i][j] = 1;
				}
				if(map[i][j] == 6) check[i][j] = 6;
			}
		}
		SIZE = points.size();
		dfs(0);
		System.out.println(ans);
	}
	private static void dfs(int idx) {
		if(idx == SIZE) {
			int cnt = 0;
			for(int i=0; i<Y; i++) for(int j=0; j<X; j++) if(check[i][j] == 0) cnt++;
			ans = Math.min(ans, cnt);
			return;
		}
		go(idx);
	}
	public static void go(int idx) {
		for(int i=0; i<4; i++) { // 90도 회전
			straight(idx, i, 0, points.get(idx).y, points.get(idx).x); 
		}
	}
	public static void straight(int idx, int d, int k, int ny, int nx) {
		if(k == 4) {
			dfs(idx + 1);
			return;
		}
		if(points.get(idx).dir[k] == 0) {
			straight(idx, (d+1)%4, k+1,ny, nx); 
			return;
		}
		if(ny < 0 || nx < 0 || ny == Y || nx == X || map[ny][nx] == 6) {
			straight(idx, (d+1)%4, k+1,points.get(idx).y, points.get(idx).x); 
			return;
		}
		check[ny][nx]++;
		straight(idx, d, k, ny+dy[d], nx+dx[d]);
		check[ny][nx]--;
	}
	
}
