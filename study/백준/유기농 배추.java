import java.util.Scanner;

public class Main {
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] arr;
	static int ans;
	static int x;
	static int y;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			x = sc.nextInt(); // M
			y = sc.nextInt(); // N
			int k = sc.nextInt();
			
			arr = new int[y][x];
			for(int i=0; i<k; i++) {
				int insX = sc.nextInt();
				int insY = sc.nextInt();
				arr[insY][insX] = 1;
			}
			
			for(int i=0; i<y; i++) {
				for(int j=0; j<x; j++) {
					if(arr[i][j] == 1) {
						recursion(i, j);
						ans++;
					}
				}
			}
			System.out.println(ans);
			ans = 0;
		}
		
	}
	public static void recursion(int y, int x) {
		arr[y][x] = -1;
		for(int i=0; i<4; i++) {
			int curY = y+dy[i];
			int curX = x+dx[i];
			if(curY == arr.length || curY < 0 || curX == arr[0].length || curX < 0) continue;
			if(arr[curY][curX] == 1) {
				recursion(curY, curX);
			}
		}
	}
}
