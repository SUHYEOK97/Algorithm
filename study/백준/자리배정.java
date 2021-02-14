import java.util.Scanner;

public class Main {
	static int[] dy = {1,0,-1,0}; // 하우상좌
	static int[] dx = {0,1,0,-1}; // 하우상좌
	
	static int[][] arr;
	static int y;
	static int x;
	static int num = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		arr = new int[y][x];
		int ans = sc.nextInt();
		int dir = 0;
		int curY = 0;
		int curX = 0;
		while(num != y*x) {
			arr[curY][curX] = num++;
			
			int tpY = curY + dy[dir];
			int tpX = curX + dx[dir];
			
			if(tpY < 0 || tpY == y || tpX < 0 || tpX == x) {
				dir++;
				if(dir == 4) dir = 0;
				curY += dy[dir];
				curX += dx[dir];
				continue;
			}
			if(arr[tpY][tpX] != 0) {
				dir++;
				if(dir == 4) dir = 0;
				curY += dy[dir];
				curX += dx[dir];
				continue;
			}
			curY += dy[dir];
			curX += dx[dir];
		}
		arr[curY][curX] = num;
		boolean flag = false;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j] == ans) {
					System.out.println((j+1) + " "+ (i+1));
					flag = true;
					break;
				}
			}
		}
		if(!flag) System.out.println("0");
	}
	
}
