import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] coin = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		int[] idx = new int[8];
		for(int tc=1; tc<=T; tc++) {
			int price = sc.nextInt();
			for(int i=0; i<coin.length; i++) {
				int moneyCnt = price / coin[i];
				idx[i] = moneyCnt;
				price -= idx[i]*coin[i];
			}
			for(int i=0; i<8; i++) {
				if(i==0) System.out.println("#"+tc);
				System.out.print(idx[i]+" ");
				if(i==7)System.out.println();
			}
		}
	}
}
