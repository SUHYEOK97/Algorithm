import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int[][] a = new int[N][N]; // 90
			int[][] b = new int[N][N]; // 180
			int[][] c = new int[N][N]; // 270
			
			for(int i=0; i<N; i++) {
				int idx = 0;
				for(int j=N-1; j>=0; j--) {
					a[i][idx] = arr[j][i];
					idx++;
				}
			}
			int y = 0;
			for(int i=N-1; i>=0; i--) {
				int x = 0;
				for(int j=N-1; j>=0; j--) {
					b[y][x] = arr[i][j];
					x++;
				}
				y++;
			}
			y = 0;
			for(int i=N-1; i>=0; i--) {
				int idx = 0;
				for(int j=0; j<N; j++) {
					c[y][idx] = arr[j][i];
					idx++;
				}
				y++;
			}
			System.out.println("#"+tc);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(a[i][j]);
				}
				System.out.print(" ");
				for(int j=0; j<N; j++) {
					System.out.print(b[i][j]);
				}
				System.out.print(" ");
				for(int j=0; j<N; j++) {
					System.out.print(c[i][j]);
				}
				System.out.println();
			}
			
		}
	}
}
