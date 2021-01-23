import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int[] day = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		for(int tc=1; tc<=T; tc++) {
			int m1 = sc.nextInt() - 1;
			int d1 = sc.nextInt();
			int m2 = sc.nextInt() - 1;
			int d2 = sc.nextInt();
			
			int sum = (day[m1]-d1+1);
			for(int i=m1+1; i<m2; i++) {
				sum += day[i];
			}
			if(m1!=m2) sum += d2;
			
			
			System.out.println("#"+tc+" "+sum);
		}
	}
}
