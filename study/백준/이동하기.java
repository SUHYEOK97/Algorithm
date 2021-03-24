import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int y,x;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		dp = new int[y+1][x+1];
		
		for(int i=1; i<=y; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=x; j++) dp[i][j] = Integer.parseInt(st.nextToken());
			
		}
		for(int i=1; i<=y; i++) {
			for(int j=1; j<=x; j++) {
				int a = dp[i][j] + dp[i-1][j];
				int b = dp[i][j] + dp[i][j-1];
				int c = dp[i][j] + dp[i-1][j-1];
				int max = 0;
				if(max < a) max = a;
				if(max < b) max = b;
				if(max < b) max = c;
				
				dp[i][j] = max;
			}
		}
		System.out.println(dp[y][x]);
		
	}
}
