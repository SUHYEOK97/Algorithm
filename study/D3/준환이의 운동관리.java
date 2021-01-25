
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int L = sc.nextInt();
			int U = sc.nextInt();
			int X = sc.nextInt();
			int result = 0;
			if(X < L) result = L - X;
			if(X > U) result = -1;
			
			System.out.println("#"+tc+" "+result);
		}
	}
}
