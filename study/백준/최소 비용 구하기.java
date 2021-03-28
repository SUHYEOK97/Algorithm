import java.io.*;
import java.util.*;

public class Main {
	static int N, M, start, end;
	static int[] distance;
	static ArrayList<Edge> edge[];
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static class Edge implements Comparable<Edge>{
		int v, dis;

		public Edge(int v, int dis) {
			this.v = v;
			this.dis = dis;
		}

		@Override
		public int compareTo(Edge o) {
			return this.dis - o.dis;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		distance = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		edge = new ArrayList[N];
		for(int i=0; i<N; i++) edge[i] = new ArrayList<>();
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int dis = Integer.parseInt(st.nextToken());
			edge[from].add(new Edge(to, dis));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken())-1;
		end = Integer.parseInt(st.nextToken())-1;
		pq.offer(new Edge(start, 0));
		distance[start] = 0;
		dijkstra();
	}
	private static void dijkstra() {
		while(!pq.isEmpty()) {
			Edge p = pq.poll();
			if(distance[p.v] < p.dis) continue;
			for(Edge e : edge[p.v]) {
				if(distance[e.v] > distance[p.v] + e.dis) {
					distance[e.v] = distance[p.v] + e.dis;
					pq.offer(new Edge(e.v, e.dis));
				}
			}
		}
		System.out.println(distance[end]);
	}
	
	
	
}
