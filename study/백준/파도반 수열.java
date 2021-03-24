import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static long[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		Queue<Integer> idx = new LinkedList<>();
		int max = 0;
		for(int tc=1; tc<=T; tc++) {
			int num = Integer.parseInt(br.readLine());
			max = Math.max(num, max);
			idx.add(num);
		}
		dp = new long[max + 1];
		dp[1] = 1;	dp[2] = 1; dp[3] = 1;  dp[4] = 2;
		for(int i=5; i<=max; i++) {
			dp[i] = dp[i-1] + dp[i-5];
		}
		while(!idx.isEmpty()) System.out.println(dp[idx.poll()]);
	}
	
}
