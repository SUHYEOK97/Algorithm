import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {0,1,0,-1};
	static int[] dx = {-1,0,1,0};
	static int[][] arr;
	static boolean[][][] visited;
	static int y;
	static int x;
	static int ans = 98765;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		arr = new int[y][x];
		visited = new boolean[y][x][2];
		for(int i=0; i<y; i++) {
			String str = br.readLine();
			for(int j=0; j<x; j++) arr[i][j] = Integer.parseInt(str.charAt(j)+"");
		}
		bfs();
		if(y==1 && x==1) System.out.println(1);
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
				if(arr[curY][curX] == 1 && point[2] == 1) continue;
				if(curY == y-1 && curX == x-1) {
					ans = point[3] + 1;
					return;
				}
				
				visited[curY][curX][point[2]] = true;
				if(arr[curY][curX] == 1 && point[2] == 0) {
					q.offer(new int[] {curY, curX, 1, point[3]+1});
				}
				if(arr[curY][curX] == 0) {
					q.offer(new int[] {curY, curX, point[2], point[3]+1});
				}
			}
			
		}
	}
}
