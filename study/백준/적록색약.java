import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	static char[][] arr;
	static int n, a, b;
	static boolean[][] check1;
	static boolean[][] check2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		check1 = new boolean[n][n];
		check2 = new boolean[n][n];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!check1[i][j]) {
					check1[i][j] = true;
					dfs(i,j,arr[i][j], 1);
					a++;
					if(arr[i][j] == 'B') b++;
				}
				
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == 'B') continue;
				if(!check2[i][j]) {
					b++;
					check2[i][j] = true;
					dfs(i, j, arr[i][j], 2);
				}
			}
		}
		System.out.println(a + " " + b);
	}
	private static void dfs(int y, int x, char color, int turn) {
		
		for(int i=0; i<4; i++) {
			int cY = y + dy[i];
			int cX = x + dx[i];
			if(cY < 0 || cX < 0 || cY == n || cX == n) continue;
			if(turn == 1) {
				if(check1[cY][cX] == true) continue;
				if(arr[cY][cX] == color) {
					check1[cY][cX] = true;
					dfs(cY, cX, color, 1);
				}
			}
			if(turn == 2) {
				if(arr[cY][cX] == 'B') continue;
				if(check2[cY][cX] == true) continue;
				check2[cY][cX] = true;
				dfs(cY, cX, color, 2);
			}
		}
	}
}
