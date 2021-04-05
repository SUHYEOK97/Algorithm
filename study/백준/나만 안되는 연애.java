import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static char[] cr;
	
	static int[] node;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static class Edge implements Comparable<Edge>{
		int u,v,d;
		public Edge(int u, int v, int d) {
			this.u = u;
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
		node = new int[n];
		cr = new char[n];
		for(int i=0; i<n; i++) node[i] = i;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) cr[i] = st.nextToken().charAt(0);
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			if(cr[u] == cr[v]) continue;
			pq.add(new Edge(u, v, d));
		}
		int dis = 0;	int cnt = 1;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(union(edge.u, edge.v)) {
				dis += edge.d;
				cnt++;
			}
			
		}
		System.out.println(cnt == n ? dis : "-1");
		
	}
	
	public static int getNode(int idx) {
		if(idx == node[idx]) return idx;
		else return getNode(node[idx]);
	}
	
	public static boolean union(int a, int b) {
		int ra = getNode(a);
		int rb = getNode(b);
		if(ra == rb) return false;
		if(ra > rb) node[ra] = rb;
		else node[rb] = ra;
		return true;
	}
}
