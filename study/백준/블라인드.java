import java.util.Arrays;
import java.util.Scanner;

public class 블라인드 {
	static int ans[] = new int[5];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt(); // 층
		int n = sc.nextInt(); // 창문
		
		int y = m*5 + 1;
		int x = n*5 + 1;
		char[][] arr = new char[m*5 + 1][n*5 + 1];
		
		for(int i=1; i<m*5 + 1; i++) {
			String str = sc.next();
			for(int j=0; j<n*5 + 1; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		for(int i=1; i<x; i+=5) {
			int cnt=0;
			boolean flag = true;
			for(int j=1; j<y; j++) {
				if(arr[j][i]=='#') flag = true;
				if(flag) {
					if(arr[j][i]=='*') cnt++;
					else if(arr[j][i]=='.'){
						flag = false;
						ans[cnt]++;
						cnt=0;
					}
					if(cnt==4) {
						ans[cnt]++;
						cnt = 0;
					}
				}
			}
		}
		for(int i=0; i<5; i++) System.out.print(ans[i] + " ");
	}
}
