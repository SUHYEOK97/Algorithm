import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[][] arr;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n+1][3];
		dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		for(int i=2; i<=n; i++) {
			arr[i][0] = Math.min(arr[i][0] + arr[i-1][1], arr[i][0] + arr[i-1][2]);
			arr[i][1] = Math.min(arr[i][1] + arr[i-1][0], arr[i][1] + arr[i-1][2]);
			arr[i][2] = Math.min(arr[i][2] + arr[i-1][0], arr[i][2] + arr[i-1][1]);
			
			for(int j=0; j<3; j++) dp[i] = Math.min(dp[i], arr[i][j]);
		}
		System.out.println(dp[n]);
	}
	
}
