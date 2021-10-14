import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb  = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] inDegree = new int[N];
			int[] seconds = new int[N];
			int[] dp = new int[N];
			ArrayList<Integer>[] arr = new ArrayList[N];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<N; i++) {
				seconds[i] = Integer.parseInt(st.nextToken());
				arr[i] = new ArrayList<>();
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()) - 1;
				int v = Integer.parseInt(st.nextToken()) - 1;
				inDegree[v]++;
				arr[u].add(v);
			}
			
			int W = Integer.parseInt(br.readLine()) - 1;
			
			Queue<Integer> q = new LinkedList<>();

			for(int i=0; i<N; i++) if(inDegree[i] == 0) {
				q.offer(i);
				dp[i] = seconds[i];
			}
			
			while(!q.isEmpty()) {
				int n = q.poll();
				for(int i=0; i<arr[n].size(); i++) {
					int m = arr[n].get(i);
					
					inDegree[m]--;
					dp[m] = Math.max(dp[m], dp[n] + seconds[m]);
					if(inDegree[m] == 0) {
						q.offer(m);
					}
				}
			}
			System.out.println(dp[W]);
		}
		
	}
	
}
