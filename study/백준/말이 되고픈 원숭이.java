import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {0,1,0,-1};
	static int[] dx = {-1,0,1,0};
	static int[] fy = {-1,-2,1,2,-1,-2,1,2};
	static int[] fx = {-2,-1,2,1,2,1,-2,-1};
	static int[][] arr;
	static boolean[][][] visited;
	static int y,x,k;
	static int ans = 98765;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		arr = new int[y][x];
		visited = new boolean[y][x][k+1];
		for(int i=0; i<y; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<x; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		bfs();
		if(y==1 && x==1) {
			if(arr[0][0] == 0) System.out.println(0);
			else if(arr[0][0] == 1) System.out.println(-1);
		}
		else System.out.println(ans == 98765 ? -1 : ans);
	}
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 0, 1});
		while(!q.isEmpty()) {
			int[] point = q.poll();
			
			for(int i=0; i<4; i++) {
				int curY = point[0]+dy[i];
				int curX = point[1]+dx[i];
				if(curY == y || curX == x || curY < 0 || curX < 0) continue;
				if(visited[curY][curX][point[2]]) continue;
				if(arr[curY][curX] == 1) continue;
				
				if(curY == y-1 && curX == x-1) {
					ans = Math.min(ans, point[3]);
					return;
				}
				visited[curY][curX][point[2]] = true;
				if(arr[curY][curX] == 0) {
					q.offer(new int[] {curY, curX, point[2], point[3] + 1});
				}
			}
			
			
			if(k > 0) {
				for(int i=0; i<8; i++) {
					int curY = point[0]+fy[i];
					int curX = point[1]+fx[i];
					if(curY >= y || curX >= x || curY < 0 || curX < 0) continue;
					
					if(point[2] == k) continue;
					if(visited[curY][curX][point[2]+1]) continue;
					if(arr[curY][curX] == 1) continue;
					
					if(curY == y-1 && curX == x-1) {
						ans = Math.min(ans, point[3]);
						return;
					}
					visited[curY][curX][point[2] + 1] = true;
					if(arr[curY][curX] == 0) {
						q.offer(new int[] {curY, curX, point[2] + 1, point[3] + 1});
					}
				}
			}
			
		}
	}
	
}
