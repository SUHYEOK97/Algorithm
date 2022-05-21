import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static int[] res;
	static int n, out = 999999, l = 2;
	static Queue<Record> q = new LinkedList<>();
	
	static class Record {
		int y,x,d;

		public Record(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1) {
					bfs_label(i, j);
					l++;
				}
			}
		}
		res = new int[l];
		
		for(int step = 2; step < l; step++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == step) bfs_find(i, j, step);
				}
			}
		}
		
		System.out.println(out);
	}
	
	public static void bfs_label(int y, int x) {
		boolean[][] check = new boolean[n][n]; 
		q.add(new Record(y, x, 0));
		check[y][x] = true;
		map[y][x] = l;
		while(!q.isEmpty()) {
			Record r = q.poll();
			for(int i=0; i<4; i++) {
				int cY = dy[i] + r.y;
				int cX = dx[i] + r.x;
				
				if(cY < 0 | cX < 0 | cY == n | cX == n) continue;
				if(check[cY][cX]) continue;
				if(map[cY][cX] == 1) {
					map[cY][cX] = l;
					check[cY][cX] = true;
					q.add(new Record(cY, cX, 0));
				}
			}
		}
	}
	
	public static void bfs_find(int y, int x, int step) {
		// step 째의 섬에서 다른 섬의 위치까지 거리를 구한 뒤 배열에 저장한다
		boolean[][] check = new boolean[n][n]; 
		q.add(new Record(y, x, 0));
		check[y][x] = true;
		
		while(!q.isEmpty()) {
			Record r = q.poll();
			for(int i=0; i<4; i++) {
				int cY = dy[i] + r.y;
				int cX = dx[i] + r.x;
				
				if(cY < 0 | cX < 0 | cY == n | cX == n) continue;
				if(check[cY][cX]) continue;
				if(map[cY][cX] == 0) {
					check[cY][cX] = true;
					q.add(new Record(cY, cX, r.d + 1));
				}
				if((map[cY][cX] != step) & (map[cY][cX] != 0)) out = Math.min(r.d, out);
			}
		}
	}

}
