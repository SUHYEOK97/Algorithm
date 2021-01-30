import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int ans = 0;
			for(int i=0; i<100; i++) for(int j=0; j<100; j++) arr[i][j] = sc.nextInt();
			for(int i=0; i<100; i++) {
				int num = -1;
				for(int j=0; j<100; j++) {
					if(arr[j][i]==2) {
						if(num == 1) ans++;
					}
					if(arr[j][i] != 0) num = arr[j][i];
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
