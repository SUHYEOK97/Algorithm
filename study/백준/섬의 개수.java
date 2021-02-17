import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {-1,1,0,0,-1,-1,1,1};
	static int[] dx = {0,0,-1,1,-1,1,-1,1};
	static int x;
	static int y;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			if(x==0 && y==0) break;
			arr = new int[y][x];
			for(int i=0; i<y; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<x; j++) arr[i][j] = Integer.parseInt(st.nextToken());
			}
			System.out.println(ans());
			
		}while(x != 0 && y != 0);
	}
	public static void find(int cY, int cX) {
		arr[cY][cX] = 0;
		for(int i=0; i<8; i++) {
			int curY = cY+dy[i];
			int curX = cX+dx[i];
			if(curY < 0 || curX < 0 || curY == y || curX == x) continue; 
			if(arr[curY][curX] == 1) find(curY, curX);
		}
	}
	public static int ans() {
		int cnt = 0;
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				if(arr[i][j]==1) {
					find(i, j);
					cnt++;
				}
			}
		}
		return cnt;
	}
}
