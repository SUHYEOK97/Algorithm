import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] adj;
	static int[] degree;
	static Queue<Integer> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new int[N][N];
		degree = new int[N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int pre = Integer.parseInt(st.nextToken())-1;
			for(int j=0; j<idx-1; j++) {
				int cur = Integer.parseInt(st.nextToken())-1;
				if(adj[pre][cur] != 1) degree[cur]++;
				adj[pre][cur] = 1;
				pre = cur;
			}
		}
		for(int i=0; i<N; i++) if(degree[i] == 0) q.offer(i);
		int cnt = 0;
		while(!q.isEmpty()) {
			int n = q.poll();
			sb.append(n+1).append("\n");
			cnt++;
			for(int i=0; i<N; i++) {
				if(adj[n][i] == 1) {
					degree[i]--;
					if(degree[i] == 0) q.offer(i);
				}
			}
		}
		System.out.println(cnt == N ? sb : 0);
	}
}
