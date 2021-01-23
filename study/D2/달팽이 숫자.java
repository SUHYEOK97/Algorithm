import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			int num = 1;
			int dir = 1;
			int cnt = 1;
			
			int y = 0;
			int x = 0;
			
			int maxNum = N*N;
			while(num<=maxNum) {
				
				switch(dir) {
				case 1:
					for(int i=0; i<N; i++) {
						arr[y][x] = num++;
						if(i != N-1) x++;
						else y++;
					}
					dir++;
					break;
				case 2:
					N--;
					for(int i=0; i<N; i++) {
						arr[y][x] = num++;
						if(i != N-1) y++;
						else x--;
					}
					dir++;
					break;
				case 3:
					for(int i=0; i<N; i++) {
						arr[y][x] = num++;
						if(i != N-1) x--;
						else y--;
					}
					dir++;
					break;
				case 4:
					N--;
					for(int i=0; i<N; i++) {
						arr[y][x] = num++;
						if(i != N-1) y--;
						else x++;
					}
					dir=1;
					break;
				}
			}
			System.out.println("#"+tc+" ");
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[i].length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
