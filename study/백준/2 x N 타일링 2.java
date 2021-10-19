import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dp = new int[N+1];
		dp[0] = 1; dp[1] = 1;
		for(int i=2; i<=N; i++) dp[i] = (dp[i-1] + dp[i-2]*2) % 10007;
		System.out.println(dp[N]);
	}
}
