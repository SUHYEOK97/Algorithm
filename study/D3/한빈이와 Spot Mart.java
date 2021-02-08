import java.util.Scanner;

public class Solution {
	static int N;
	static int M;
	static int[] arr;
	static int[] take = new int[2];
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			arr = new int[N];
			
			for(int i=0; i<N; i++) arr[i] = sc.nextInt();
			recur(0, 0);
			
			System.out.println("#" + tc + " " + (ans==0 ? -1 : ans));
			ans = 0;
		}
	}
	
	public static void recur(int idx, int start) {
		if(idx == 2) {
			int max = 0;
			for(int i=0; i<2; i++) {
				max += take[i];
				if(max > M) return;
			}
			ans = ans < max ? max : ans;
			return;
		}
		for(int i=start; i<N; i++) {
			take[idx] = arr[i];
			recur(idx + 1, i + 1);
		}
	}
}
