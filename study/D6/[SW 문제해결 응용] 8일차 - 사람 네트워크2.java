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
	static int n;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int[][] adj = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					adj[i][j] = Integer.parseInt(st.nextToken());
					if(adj[i][j] == 0) adj[i][j] = 9999999;
				}
			}
			for(int k=0; k<n; k++) {
				for(int i=0; i<n; i++) {
					if(i == k) continue;
					for(int j=0; j<n; j++) {
						if(j == k || j == i) continue;
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
					}
				}
			}
			int ans = 9999999;
			for(int i=0; i<n; i++) {
				int num = 0;
				for(int j=0; j<n; j++) {
					if(adj[i][j] == 9999999) continue;
					num += adj[i][j];
				}
				ans = Math.min(num, ans);
			}
			sb.append("#"+tc+" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
}
