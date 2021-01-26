import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			char[][] arr = new char[8][8];
			for(int i=0; i<8; i++) {
				String str = sc.next();
				for(int j=0; j<8; j++) arr[i][j] = str.charAt(j);
			}
			int cnt = 0;
			for(int i=0; i<8; i++) {
				for(int j=0; j<=8-N; j++) {
					{
						String rowStr = "";
						String colStr = "";
						for(int k=0; k<N; k++) {
							rowStr += arr[i][j+k];
							colStr += arr[j+k][i];
						}
						StringBuilder rowReverse = new StringBuilder(rowStr);
						StringBuilder colReverse = new StringBuilder(colStr);
						rowReverse = rowReverse.reverse();
						colReverse = colReverse.reverse();
						if(rowStr.equals(rowReverse.toString())) cnt++;
						if(colStr.equals(colReverse.toString())) cnt++;
					}
				}
			}
			
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
