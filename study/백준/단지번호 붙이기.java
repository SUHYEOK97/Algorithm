import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {-1,1,0,0,-1,-1,1,1};
	static int[] dx = {0,0,-1,1,-1,1,-1,1};
	static int n;
	static int[][] arr;
	static int[] check = new int[1000];
	static int chkIdx = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) arr[i][j] = Integer.parseInt(str.charAt(j)+"");
		}
		System.out.println(count());
		for(int i=0; i<chkIdx; i++) {
			System.out.println(check[i]);
		}
	}
	public static void find(int cY, int cX, int chkIdx) {
		arr[cY][cX] = 0;
		check[chkIdx]++;
		for(int i=0; i<4; i++) {
			int curY = cY+dy[i];
			int curX = cX+dx[i];
			if(curY < 0 || curX < 0 || curY == n || curX == n) continue; 
			if(arr[curY][curX] == 1) find(curY, curX, chkIdx);
		}
	}
	public static int count() {
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]==1) {
					cnt++;
					find(i, j, chkIdx++);
				}
			}
		}
		Arrays.sort(check, 0, chkIdx);
		return cnt;
	}
}
