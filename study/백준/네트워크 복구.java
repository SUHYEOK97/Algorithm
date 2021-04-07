import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	
	static int[] node, pre;
	static ArrayList<Edge>[] arr;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static class Edge implements Comparable<Edge>{
		int v,t;
		public Edge(int v, int t) {
			this.v = v;
			this.t = t;
		}
		@Override
		public int compareTo(Edge o) {
			return this.t - o.t;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		node = new int[n];
		pre = new int[n];
		Arrays.fill(node, 99999);
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
		pq.add(new Edge(0, 0));
		node[0] = 0;
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int cur = edge.v;
			if(node[cur] < edge.t) continue;
			for(int i=0; i<arr[cur].size(); i++) {
				Edge e = arr[cur].get(i);
				if(node[cur]+e.t > node[e.v]) continue;
				pre[e.v] = cur;
				node[e.v] = node[cur]+e.t;
				pq.offer(new Edge(e.v, node[e.v]));
			}
		}
		System.out.println(n-1);
		for(int i=1; i<pre.length; i++) {
			System.out.println(pre[i]+1 + " " + (i+1));
		}
	}
}
