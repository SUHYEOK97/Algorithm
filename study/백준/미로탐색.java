import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static boolean check[][];
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int n;
	static int m;
	static int ans = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		check = new boolean[n][m];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) arr[i][j] = Integer.parseInt(str.charAt(j)+"");
		}
		
		bfs();
		System.out.println(ans);
	}
	private static void bfs() {
		int y = 0;
		int x = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {y,x});
		check[y][x] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			ans++;
			printf(arr);
			for(int tc=0; tc<size; tc++) {
				int[] r = q.poll();
				for(int i=0; i<4; i++) {
					int curY = r[0] + dy[i];
					int curX = r[1] + dx[i];
					if(curY < 0 || curX < 0 || curY == n || curX == m) continue;
					if(curY == n-1 && curX == m-1) return;
					if(arr[curY][curX] == 1 && !check[curY][curX]) {
						check[curY][curX] = true;
						arr[curY][curX] = ans;
						q.offer(new int[] {curY, curX});
					}
				}
				
			}
		}
	}
	public static void printf(int[][] arr) {
		System.out.println("-----------");
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}System.out.println();
		}
	}
	public static void printf(boolean[][] arr) {
		System.out.println("-----------");
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}System.out.println();
		}
	}
}
