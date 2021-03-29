import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			dp = new int[2][n];
			int[][] arr = new int[2][n];
			for(int j=0; j<n; j++) {
				arr[0][j] = Integer.parseInt(st1.nextToken());
				arr[1][j] = Integer.parseInt(st2.nextToken());
			}
			dp[0][0] = arr[0][0];	dp[0][1] = arr[0][1] + arr[1][0];
			dp[1][0] = arr[1][0];	dp[1][1] = arr[1][1] + arr[0][0];
			
			for(int i=2; i<n; i++) {
				dp[0][i] = Math.max(dp[1][i-2]+arr[0][i], dp[1][i-1]+arr[0][i]);
				dp[1][i] = Math.max(dp[0][i-2]+arr[1][i], dp[0][i-1]+arr[1][i]);
			}
//			System.out.println();
//			System.out.println(Arrays.toString(dp[0]));
//			System.out.println(Arrays.toString(dp[1]));
			sb.append(Math.max(dp[0][n-1], dp[1][n-1])).append("\n");
		}
		System.out.println(sb);
	}
}t
