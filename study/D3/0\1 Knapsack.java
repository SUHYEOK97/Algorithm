import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] dp, value;
	static int n, k;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			dp = new int[n+1][k+1];
			value = new int[n+1][k+1];
			for(int i=1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				value[i][0] = Integer.parseInt(st.nextToken());
				value[i][1] = Integer.parseInt(st.nextToken());
			}
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=k; j++){
					if(value[i][0] <= j) {
						dp[i][j] = Math.max(value[i][1]+dp[i-1][j-value[i][0]], dp[i-1][j]);
					}
					else dp[i][j] = dp[i-1][j];
				}
			}
			for(int i=0; i<=n; i++) System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println(sb);
	}
	
}
