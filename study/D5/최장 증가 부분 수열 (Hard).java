import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[] dp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			dp = new int[n];
			int[] arr = new int[n];
			arr[0] = Integer.parseInt(st.nextToken());
			dp[0] = arr[0];
			int idx = 0;
			for(int i=1; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken()); // 기준점
				if(arr[i] > dp[idx]) dp[++idx] = arr[i];
				else {
					int start = 0;
					int end = idx;
					while(start < end) {
						int mid = (start+end)/2;
						if(dp[mid] <= arr[i]) start = mid + 1;
						else end = mid;
					}
					if(end != -1) dp[end] = arr[i];
				}
			}
			sb.append("#"+tc+" "+(idx+1)).append("\n");
		}
		System.out.println(sb);
	}
}
