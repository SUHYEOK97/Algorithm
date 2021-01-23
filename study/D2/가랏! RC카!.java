import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int ms = 0;
			int move = 0;
			for(int i=0; i<N; i++) {
				int a = sc.nextInt();
				if(a != 0) {
					int b = sc.nextInt();
					if(a==1) ms += b;
					else if(a==2) ms -= b;
					if(ms < 0) ms = 0;
				}
				move += ms;
			}
			
			System.out.println("#"+tc+" "+move);
		}
	}
}
