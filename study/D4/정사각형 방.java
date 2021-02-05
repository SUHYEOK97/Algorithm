import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int n;
	static int ans = 1;
	static int ansNum;
	static ArrayList<Integer> rank = new ArrayList<>();
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			n = sc.nextInt();
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++) 
				for(int j=0; j<n; j++) arr[i][j] = sc.nextInt();
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					moveCnt(arr,i,j,1, arr[i][j]);
				}
			}
			System.out.println("#"+tc+" "+ansNum+" "+ans);
			ans = 1;
			ansNum = 1;
		}
	}
	
	public static void moveCnt(int[][] arr, int y, int x, int cnt, int number) {
		for(int i=0; i<4; i++) {
			int curX = x + dx[i];
			int curY = y + dy[i];
			if(curX == n || curY < 0
					|| curX < 0 || curY == n) {
				continue;
			}
			if(arr[y][x] + 1 == arr[curY][curX]) {
				moveCnt(arr,curY,curX, cnt + 1, number);
				if(ans < cnt+1) {
					ansNum = number;
					ans = cnt+1;
				}
				else if(ans == cnt+1) {
					ansNum = number < ansNum ? number : ansNum;
				}
			}
		}
	}
}
