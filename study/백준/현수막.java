import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {0,0,-1,1,1,-1,1,-1};
	static int[] dx = {-1,1,0,0,1,-1,-1,1};
	static int y;
	static int x;
	static int[][] arr;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		arr = new int[y][x];
		for(int i=0; i<y; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<x; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				if(arr[i][j] == 1) {
					ans++;
					bfs(i,j);
				}
			}
		}
		System.out.println(ans);
	}
	private static void bfs(int curY, int curX) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {curY, curX});
		arr[curY][curX] = 0;
		while(!q.isEmpty()) {
			int point[] = q.poll();
			for(int i=0; i<8; i++) {
				int cY = point[0] + dy[i];
				int cX = point[1] + dx[i];
				if(cY == y || cX == x || cY < 0 || cX < 0) continue;
				if(arr[cY][cX] == 0) continue;
				arr[cY][cX] = 0;
				q.offer(new int[] {cY,cX});
				
			}
		}
	}
}
