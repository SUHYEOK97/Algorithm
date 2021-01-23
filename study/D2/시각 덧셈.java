import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int hour1 = sc.nextInt();
			int min1 = sc.nextInt();
			int hour2 = sc.nextInt();
			int min2 = sc.nextInt();
			
			int pH = hour1 + hour2;
			int pM = min1 + min2;
			
			if(pH > 12) pH -= 12;
			if(pM >= 60) {
				pM -= 60;
				pH++;
			}
			
			System.out.println("#"+tc+" "+pH +" "+pM);
		}
	}
}
