import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static BigInteger dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		dp = new BigInteger[101][101];
		dp[1][1] = new BigInteger("1");
		for(int i=2; i<101; i++) {
			dp[i][1] = new BigInteger(i+"");
			dp[i][i] = new BigInteger("1");
		}
		for(int i=3; i<101; i++) {
			for(int j=2; j<i; j++) dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
		}
		System.out.println(dp[n][m]);
	}
}
