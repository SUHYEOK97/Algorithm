import java.io.*;
import java.util.*;

public class Main {
	static float[][] edge;
	static int[] node;
	static int N;
	
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static class Edge implements Comparable<Edge>{
		int v1,v2;
		float dis;
		
		public Edge(int v1, int v2, float dis) {
			this.v1 = v1;
			this.v2 = v2;
			this.dis = dis;
		}


		@Override
		public int compareTo(Edge o) {
			return Float.compare(this.dis, o.dis);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		node = new int[N];
		edge = new float[N][2];
		for(int i=0; i<N; i++) node[i] = i;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			float x = Float.parseFloat(st.nextToken());
			float y = Float.parseFloat(st.nextToken());
			edge[i][0] = x;
			edge[i][1] = y;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i == j) continue;
				double dis = Math.pow(edge[i][0]-edge[j][0], 2);
				dis += Math.pow(edge[i][1]-edge[j][1], 2);
				dis = Math.sqrt(dis);
				pq.offer(new Edge(i, j, (float)dis));
			}
		}
		float ans = 0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(union(e.v1, e.v2)) ans += e.dis;
		}
		System.out.printf("%.2f",ans);
	}
	
	public static int getRoot(int idx) {
		if(idx == node[idx]) return idx;
		else return getRoot(node[idx]);
	}
	
	public static boolean union(int a, int b) {
		int ra = getRoot(a);
		int rb = getRoot(b);
		if(ra == rb) return false;
		if(ra < rb) node[rb] = ra;
		else node[ra] = rb;
		return true;
	}
	
	
}
