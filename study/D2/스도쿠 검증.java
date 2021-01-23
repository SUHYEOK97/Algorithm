import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int[][] game = new int[9][9];
			int result = 1;
			for(int i=0; i<9; i++) for(int j=0; j<9; j++) game[i][j]=sc.nextInt();
			for(int i=0; i<9; i++) {
				for(int num=1; num<=9; num++) {
					for(int j=0; j<9; j++) {
						int cntRow=0;
						int cntCol=0;
						for(int k=0; k<9; k++) {
							if(num==game[i][k]) {
								cntRow++;
							}
							if(cntRow>1) {
								result = 0;
							}
						}
						for(int k=0; k<9; k++) {
							if(num==game[k][i]) {
								cntCol++;
							}
							if(cntCol>1) {
								result = 0;
							}
						}
					}
				}
			}
			for(int i=0; i<3; i++) {
				for(int num=1; num<=9; num++) {
					int cnt=0;
					for(int j=i*3; j<i*3+3; j++) {
						for(int k=i*3; k<i*3+3; k++) {
							if(num==game[j][k]) cnt++;
						}
					}
					if(cnt>1) {
						result = 0;
					}
				}
			}
			System.out.println("#"+tc+" "+result);
		}
	}
}
