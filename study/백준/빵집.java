import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm12_식당예제 {
	static char[][] arr;
	static int[] dx = {1,1,1};
	static int[] dy = {-1,0,1};
	static int y;
	static int x;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		arr = new char[y][x];
		
		for(int i=0; i<y; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0; j<x; j++) arr[i][j] = str.charAt(j);
		}
		for(int i=0; i<y; i++) {
			flag = -1;
			find(i, 0);
			
		}
		System.out.println(cnt);
	}
	static int flag = -1;
	public static void find(int cY, int cX) {
		
		if(cX == x-1) {
			cnt++;
			flag = 1;
			return;
		}
		for(int i=0; i<3; i++) {
			int curY = cY + dy[i];
			int curX = cX + dx[i];
			if(curY < 0 || curY == y || curX < 0 || curX == x) continue;
			if(arr[curY][curX] == '.') {
				arr[curY][curX] = 'n';
				if(flag == -1) find(curY, curX);
				if(flag == 1) return;
			}
			else continue;
		}
	}
}
