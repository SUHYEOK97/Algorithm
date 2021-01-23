import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt(); // N*N배열 
			int k = sc.nextInt(); // 글자 크기
			
			int[][] arr = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int area = 0;
			for(int i=0; i<N; i++) {
				int rowCnt = 0;
				for(int j=0; j<N; j++) {
					if(arr[i][j]==1) rowCnt++;
					else {
						if(rowCnt==k) area++;
						rowCnt = 0;
					}
					if(j==N-1) {
						if(rowCnt==k) area++;
						rowCnt = 0;
					}
				}
				
				int colCnt = 0;
				for(int j=0; j<N; j++) {
					if(arr[j][i]==1) colCnt++;
					else {
						if(colCnt==k) area++;
						colCnt = 0;
					}
					if(j==N-1) {
						if(colCnt==k) area++;
						colCnt = 0;
					}
				}
			}
			
			System.out.println("#"+tc+" "+area);
		}
	}
}
