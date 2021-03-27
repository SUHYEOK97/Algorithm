import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] adj;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		adj = new int[n][n];
		for(int i=0; i<n; i++) Arrays.fill(adj[i], 9999999);
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			
			adj[from][to] = Math.min(adj[from][to], cost);
		}
		
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				if(i == k) continue;
				for(int j=0; j<n; j++) {
					if(j == i || j == k) continue;
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
				}
			}
		}
		pf();
		
	}
	public static void pf() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(adj[i][j] == 9999999) sb.append("0 ");
				else sb.append(adj[i][j]).append(" ");
			}sb.append("\n");
		}
		System.out.println(sb);
	}
	
}
