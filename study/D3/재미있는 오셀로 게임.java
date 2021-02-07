import java.util.Scanner;

public class Solution {
	static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
	static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};
	static int[][] arr;
	static int n;
	
	static int[] checkX; // 이동 전 위치배열
	static int[] checkY;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			n = sc.nextInt();
			checkX = new int[n];
			checkY = new int[n];
			
			int m = sc.nextInt();
			arr = new int[n][n];
			
			arr[n/2][n/2] = 2; 		arr[n/2-1][n/2-1] = 2;
			arr[n/2-1][n/2] = 1; 	arr[n/2][n/2-1] = 1;
			
			// 1 : 흑돌, 2 : 백돌
			for(int i=0; i<m; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				int turn = sc.nextInt();
				arr[x][y] = turn;
				
				for(int j = 0; j < 8; j++) {
					int curX = x + dx[j];
					int curY = y + dy[j];
					if(curX >= 0 && curY >= 0 && curX < n && curY < n && arr[curX][curY] != 0) {
							   //델타값 더한 위치, k값, idx
						search(curX, curY, dx[j], dy[j], turn, 0);
					}
				}
			}
			
			int black = 0;
			int white = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(arr[i][j] == 1) black++;
					else if(arr[i][j] == 2) white++;
				}
			}
			System.out.println("#" + tc + " " + black + " " + white);
		}
	}
	
	public static void search(int x, int y, int dx, int dy, int turn, int cnt) {
		if(arr[x][y] == turn) {
			for(int i=0; i<cnt; i++) {
				arr[checkX[i]][checkY[i]] = turn;
			}
			return;
		}
		checkX[cnt] = x;
		checkY[cnt] = y;
		int curX = x + dx;
		int curY = y + dy;
		
		if(curX >= 0 && curY >= 0 && curX < n && curY < n) {
			if(arr[curX][curY] != 0) search(curX, curY, dx, dy, turn, cnt+1);
		}
		checkX[cnt] = 0;
		checkY[cnt] = 0;
	}
}
