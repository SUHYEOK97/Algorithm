import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			
			int payA = W * P;
			int payB = (W<=R) ? Q : Q + (W-R)*S;
			int willPay = (payA < payB) ? payA : payB;
			System.out.println("#"+tc+" " + willPay);
			
		}
	}
}
