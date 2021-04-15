import java.io.*;
import java.util.*;

public class Solution {
	// y x 순
	static int Y,X,L,tY,tX;
	static int[][] map;
	static int[][] check;
	
	// 상 하 좌 우
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] shape = {{1,1,1,1},{1,1,0,0},{0,0,1,1},{1,0,0,1},{0,1,0,1},{0,1,1,0},{1,0,1,0}};
    static Queue<int[]> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Y = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			tY = Integer.parseInt(st.nextToken());
			tX = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[Y][X];
			check = new int[Y][X];
			q.offer(new int[] {tY,tX,1});
			check[tY][tX] = 1;
			for(int i=0; i<Y; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<X; j++) {
					map[i][j] = Integer.parseInt(st.nextToken())-1;
				}
			}
			sb.append("#").append(tc).append(" ").append(bfs()).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static int bfs() {
		int ans = 1;
		while(!q.isEmpty()) {
			int[] o = q.poll();
			int move = o[2];
			for(int i=0; i<4; i++) {
				int cy = dy[i] + o[0];
				int cx = dx[i] + o[1];
				if(cy < 0 || cx < 0 || cy == Y || cx == X) continue;
				if(checking(cy, cx, i)) continue;
				if(shape[map[o[0]][o[1]]][i] == 0) continue;
				if(move == L) continue;
				ans++;
				check[cy][cx] = move+1;
			    q.offer(new int[] {cy, cx, move + 1});
			}
			
		}
		return ans;
	}
	private static boolean checking(int cy, int cx, int dir) {
		int next = map[cy][cx];
		if(next == -1) return true;
		if(dir == 0) if(shape[next][1] == 0) return true;
		if(dir == 1) if(shape[next][0] == 0) return true;
		if(dir == 2) if(shape[next][3] == 0) return true;
		if(dir == 3) if(shape[next][2] == 0) return true;
		if(check[cy][cx] != 0) return true;
		return false;
	}
    
}
