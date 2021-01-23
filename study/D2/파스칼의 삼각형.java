package solution;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			System.out.println("#"+tc);
			int[] pre = new int[N+1];
			pre[0] = 1;
			int[] cur = new int[N+1];
			cur[0] = 1;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=i; j++) {
					if(j != i) cur[j+1] = pre[j] + pre[j+1];
					else cur[j] = 1;
					System.out.print(cur[j] + " ");
				}
				
				for(int j=0; j<N; j++) pre[j] = cur[j];
				System.out.println();
			}
			
		}
	}
}
