import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int Y, X;
	static int[][] map, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[Y][X];
		dp = new int[Y][X];
		for(int i =0; i<Y; i++) {
			String str = br.readLine();
			for(int j=0; j<X; j++) {
				map[i][j] = str.charAt(j) - 48;
				dp[i][j] = map[i][j];
			}
		}
		
		for(int i=0; i<Y; i++) {
			for(int j=0; j<X; j++) {
				if(dp[i][j] == 0) continue;
				int len = dp[i][j];
				out : while(true) {
					for(int y=i; y<=i+len; y++) {
						if(y >= Y) break out;
						for(int x=j; x<=j+len; x++) {
							if(x >= X) break out;
							if(dp[y][x] == 0) break out;
						}
					}
					len++;
				}
				if(len != dp[i][j]) {
					for(int y=i; y<i+len; y++) {
						for(int x=j; x<j+len; x++) dp[y][x] = Math.max(len, dp[i][j]);
					}
				}
			}
		}
		int ans = 0;
		for(int i=0; i<Y; i++) ans = Math.max(ans, Arrays.stream(dp[i]).max().getAsInt());
		System.out.println(ans*ans);
		
	}
}
