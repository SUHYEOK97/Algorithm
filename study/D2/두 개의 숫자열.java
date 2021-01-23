import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] arrA = new int[N];
			int[] arrB = new int[M];
			
			for(int i=0; i<N; i++) arrA[i] = sc.nextInt();
			for(int i=0; i<M; i++) arrB[i] = sc.nextInt();
			int idx = (N < M) ? N : M;
			int sub = (N < M) ? M-N : N-M;
			int max = 0;
			for(int i=0; i<=sub; i++) {
				int a = 0;
				for(int j=0; j<idx; j++) {
					if(idx==N) {
						a += (arrA[j]*arrB[i+j]);
					}
					else {
						a += (arrB[j]*arrA[i+j]);
					}
				}
				if(max < a) max = a;
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}
