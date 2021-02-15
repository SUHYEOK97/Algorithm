import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static int[][] arr;
	static int[][] clone;
	static int[][] check;
	static int y;
	static int x;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		arr = new int[y][x];
		clone = new int[y][x];
		check = new int[y][x];
		
		for(int i=0; i<y; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<x; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		int bingsanCnt = 0;
		while(bingsanCnt < 2) {
			for(int i=0; i<y; i++) {
				for(int j=0; j<x; j++) {
					if(arr[i][j] != 0) {
						clone[i][j] = checkZero(i, j);
					}
				}
			}
			for(int i=0; i<y; i++) {
				for(int j=0; j<x; j++) {
					arr[i][j] = (arr[i][j] + clone[i][j] <= 0 ? 0 : arr[i][j] + clone[i][j]);
				}
			}
			ans++;
			bingsanCnt = 0;
			for(int i=0; i<y; i++) for(int j=0; j<x; j++) check[i][j] = arr[i][j];
			for(int i=0; i<y; i++) {
				for(int j=0; j<x; j++) {
					if(check[i][j] != 0) {
						bingsan(check, i, j);
						bingsanCnt++;
					}
				}
			}
			int cnt = 0;
			for(int i=0; i<y; i++) {
				for(int j=0; j<x; j++) {
					if(arr[i][j] == 0) cnt++;
				}
			}
			if(cnt == y*x) {
				ans = 0;
				break;
			}
		}
		System.out.println(ans);
	}
	
	public static int checkZero(int Y, int X) {
		int cnt = 0;
		for(int i=0; i<4; i++) {
			int curY = Y + dy[i];
			int curX = X + dx[i];
			if(curY < 0 || curY == y || curX < 0 || curX == x) continue;
			if(arr[curY][curX] == 0) cnt--;
		}
		return cnt;
	}
	
	public static void bingsan(int[][] check, int Y, int X) {
		check[Y][X] = 0;
		for(int i=0; i<4; i++) {
			int curX = X + dx[i];
			int curY = Y + dy[i];
			if(curX == x || curY < 0 || curX < 0 || curY == y) continue;
			if(check[curY][curX] != 0) {
				bingsan(check, curY, curX);
			}
		}
	}
	
	
}
