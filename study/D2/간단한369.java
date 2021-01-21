package solution;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			String num = i+"";
			int cnt = 0;
			for(int j=0; j<num.length(); j++) {
				if(num.charAt(j)=='3' || num.charAt(j)=='6' || num.charAt(j)=='9') {
					cnt++;
				}
			}
			if(cnt > 0) {
				for(int j=0; j<cnt; j++) {
					System.out.print("-");
				}System.out.print(" ");
			}
			else System.out.print(i+" ");
		}
		
	}
}
