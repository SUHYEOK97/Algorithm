import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] dp, arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
		dp[0] = arr[0];		
		if(n > 1 )dp[1] = dp[0] + arr[1];		
		if(n > 2) {
			dp[2] = Math.max(dp[0]+arr[2], arr[1] + arr[2]);
			for(int i=3; i<n; i++) {
				dp[i] = Math.max(dp[i-3]+arr[i-1]+arr[i], dp[i-2]+arr[i]);
				if(i > 3) dp[i] = Math.max(dp[i], dp[i-4]+arr[i-1]+arr[i]);
			}
		}
		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
}
