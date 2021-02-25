import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
	static int n;
	static int[][] arr;
	static int count = 9999; // 전선
	static int node; // 노드
	static boolean check[];
	static ArrayList<int[]> point;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			n = sc.nextInt();
			arr = new int[n][n];
			point = new ArrayList<>();
			count = 9999;
			node = 0;
			for(int i=0; i<n; i++) for(int j=0; j<n; j++) arr[i][j] = sc.nextInt();
			for(int i=0; i<n; i++) {
				if(arr[i][0] == 1) {
					node++;
					arr[i][0] = 3;
				}
				if(arr[i][n-1] == 1) {
					node++;
					arr[i][n-1] = 3;
				}
				if(arr[0][i] == 1) {
					node++;
					arr[0][i] = 3;
				}
				if(arr[n-1][i] == 1) {
					node++;
					arr[n-1][i] = 3;
				}
			}
			findCore();
			check=  new boolean[point.size()];
			findPath(0);
			System.out.println("#"+tc+" "+count);
			
		}
		
	}
	private static void findCore() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == 1) point.add(new int[] {i,j});
			}
		}
	}
	public static void findPath(int idx) {
		if(idx == point.size()) {
			int cntNode = 0;
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][j] == 3) cntNode++;
					if(arr[i][j] == 2) cnt++;
				}
			}
			if(cntNode > node) {
				node = cntNode;
				count = cnt;
			}
			else if(cntNode == node) {
				count = Math.min(count, cnt);
			}
			return;
		}
		int y = point.get(idx)[0];
		int x = point.get(idx)[1];
		
		for(int i=0; i<4; i++) {
			int curY = y+dy[i];
			int curX = x+dx[i];
			if(arr[curY][curX] == 1) continue;
			go(idx, y, x, i);
		}
		findPath(idx+1);
	}
	
	private static void go(int idx, int y, int x, int dir) {
		if(idx == point.size()) return;
		int curY = y+dy[dir];
		int curX = x+dx[dir];
		if(curY < 0 || curX < 0 || curY == n || curX == n) return;
		if(arr[curY][curX] == 1) return;
		if(arr[curY][curX] == 2) return;
		if(arr[curY][curX] == 3) return;
		arr[curY][curX] = 2;
		go(idx, curY, curX , dir);
		
		if(curY == n-1 || curX == n-1 || curX == 0 || curY == 0) {
			check[idx] = true;
			arr[point.get(idx)[0]][point.get(idx)[1]] = 3;
			findPath(idx + 1);
			check[idx] = false;
			arr[point.get(idx)[0]][point.get(idx)[1]] = 1;
		}
		arr[curY][curX] = 0;
	}
	
}
