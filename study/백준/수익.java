import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			dp = new int[n+1];
			Arrays.fill(dp, Integer.MIN_VALUE);
			dp[0] = Integer.parseInt(br.readLine());
			for(int i=1; i<n; i++) {
				int num = Integer.parseInt(br.readLine());
				dp[i] = Math.max(dp[i-1] + num, num);
			}
			System.out.println(Arrays.stream(dp).max().getAsInt());
		}
	}
}
