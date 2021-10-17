import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static char[][] ch;
	static char[] str1, str2;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		
		N = str1.length;
		M = str2.length;
		
		ch = new char[N][M];
		dp = new int[N + 1][M + 1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(str1[i-1] == str2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
					ch[i-1][j-1] = 'C';
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					if(dp[i][j-1] > dp[i-1][j]) {
						ch[i-1][j-1] = 'L';
						dp[i][j] = dp[i][j-1];
					}
					else {
						ch[i-1][j-1] = 'U';
						dp[i][j] = dp[i-1][j];
					}
				}
			}
		}
		
		System.out.println(dp[N][M]);
		findString(new Stack<>(), N-1, M-1);
		
	}

	private static void findString(Stack<Character> s, int y, int x) {
		if(s.size() == dp[N][M]) {
			while(!s.isEmpty()) System.out.print(s.pop());
			return;
		}
		if(ch[y][x] == 'U') findString(s, y-1, x);
		else if(ch[y][x] == 'L') findString(s, y, x-1);
		else if(ch[y][x] == 'C') {
			s.push(str1[y]);
			findString(s, y-1, x-1);
		}
		
	}

}
