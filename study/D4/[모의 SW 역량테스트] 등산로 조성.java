import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
	
	static int n;
	static int k;
	static int ans;
	static int max;
	static int[][] arr;
	static int[][] clone;
	static boolean[][] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			clone = new int[n][n];
			
			ans = 0;	max = 0;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, arr[i][j]);
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) if(arr[i][j] == max) {
					mkClone();
					check[i][j] = true;
					dfs(i, j, 1, false);
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
		
	}
	
	private static void dfs(int y, int x, int move, boolean m) {
		ans = Math.max(move, ans);
		for(int i=0; i<4; i++) {
			int curY = y + dy[i];
			int curX = x + dx[i];
			if(curY < 0 || curX < 0 || curY == n || curX == n) continue;
			if(clone[curY][curX] < 0) continue;
			if(check[curY][curX]) continue;
			check[curY][curX] = true;
			if(m) {
				if(clone[curY][curX] < clone[y][x]) {
					dfs(curY, curX, move+1, true);
				}
			}
			else {
				for(int cnt=0; cnt<=k; cnt++) {
					if(clone[curY][curX]-cnt < clone[y][x]) {
						clone[curY][curX] -= cnt;
						if(cnt==0) dfs(curY, curX, move+1, false);
						else dfs(curY, curX, move+1, true);
						clone[curY][curX] += cnt;
						check[curY][curX] = false;
						break;
					}
				}
			}
			check[curY][curX] = false;
		}
	}
	public static void mkClone() {
		check = new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				clone[i][j] = arr[i][j];
			}
		}
	}
}
