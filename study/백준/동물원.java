import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[100002];
		// 1 2 5 12
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<=N+1; i++) {
			dp[i] = (dp[i-2] + dp[i-1]*2) % 9901;
		}
		System.out.println((dp[N]*3 + dp[N-1]) % 9901);
	}
}
