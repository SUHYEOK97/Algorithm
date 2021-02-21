import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int[][] arr;
	static Queue<int[]> q = new LinkedList<>();
	static int ans = 0,y,x;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		arr = new int[y][x];
		for(int i=0; i<y; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<x; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) q.offer(new int[] {i,j});
			}
		}
		bfs();
		System.out.println(answer());
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			ans++;
			for(int tc=0; tc<size; tc++) {
				int[] r = q.poll();
				for(int i=0; i<4; i++) {
					int curY = r[0] + dy[i];
					int curX = r[1] + dx[i];
					if(curY < 0 || curX < 0 || curY == y || curX == x) continue;
					if(arr[curY][curX] == 0) {
						arr[curY][curX] = ans;
						q.offer(new int[] {curY,curX});
					}
				}
			}
		}
	}
	public static int answer() {
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				if(arr[i][j] == 0) return -1;
			}
		}
		return ans - 1;
	}
}
