package solution;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			String str = sc.next();
			String reverse = "";
			for(int i=str.length()-1; i>=0; i--) {
				reverse += str.charAt(i);
			}
			
			if(reverse.equals(str)) {
				System.out.println("#"+tc+" "+1);
			}else {
				System.out.println("#"+tc+" "+0);
			}
		}
	}
}
