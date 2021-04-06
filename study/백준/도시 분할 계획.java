import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	
	static boolean[] node;
	static ArrayList<Edge>[] arr;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static class Edge implements Comparable<Edge>{
		int v,d;
		public Edge(int v, int d) {
			this.v = v;
			this.d = d;
		}
		@Override
		public int compareTo(Edge o) {
			return this.d - o.d;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		node = new boolean[n];
		arr = new ArrayList[n];
		for(int i=0; i<n; i++) arr[i] = new ArrayList<>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			arr[u].add(new Edge(v, d));
			arr[v].add(new Edge(u, d));
		}
		int dis = 0;	int cnt = 1;	int max = 0;
		pq.add(new Edge(0, 0));
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(node[edge.v]) continue;
			node[edge.v] = true;
			dis += edge.d;
			max = Math.max(edge.d, max);
			for(int i=0; i<arr[edge.v].size(); i++) {
				if(node[arr[edge.v].get(i).v]) continue;
				pq.offer(new Edge(arr[edge.v].get(i).v, arr[edge.v].get(i).d));
			}
			if(cnt++ == n) break;
		}
		System.out.println(dis - max);
	}
}
