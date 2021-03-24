import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n,w;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		ArrayList<Integer> ans = new ArrayList<>();
		int max = -1;
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			ans.add(num);
			max = Math.max(num, max);
		}
		if(max < 4) max = 4;
		dp = new int[max+1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=4; i<=max; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		for(int i=0; i<n; i++) {
			System.out.println(dp[ans.get(i)]);
		}
	}
	
}
