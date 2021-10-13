import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		String char1 = br.readLine();
		String char2 = br.readLine();
		N = char1.length();
		M = char2.length();
		dp = new int[N + 1][M + 1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(char1.charAt(i - 1) == char2.charAt(j - 1)) dp[i][j] = dp[i-1][j-1] + 1;
				else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		System.out.println(dp[N][M]);
	}


}
