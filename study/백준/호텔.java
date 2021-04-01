import java.io.*;
import java.util.*;

public class Main {
	static int n, c;
	static int[] dp;
	static int[][] price;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		price = new int[n+1][2];
		dp = new int[100001];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int pr = Integer.parseInt(st.nextToken());
			int pe = Integer.parseInt(st.nextToken());
			dp[pr] = pe;
			price[i][0] = pr;
			price[i][1] = pe;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=100000; j++) {
				if(j - price[i][0] >= 0) dp[j] = Math.max(dp[j], dp[j - price[i][0]]+price[i][1]);
			}
		}
		for(int i=0; i<=100000; i++) if(dp[i] >= c) {
			System.out.println(i);
			break;
		}
//		System.out.println(Arrays.toString(dp));
	}
	
}
/*
1000 1
1 99
ans : 11

12 2
3 5
1 1
ans : 8
*/
