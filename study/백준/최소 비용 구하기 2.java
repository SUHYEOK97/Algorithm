import java.io.*;
import java.util.*;

public class Main {
	static int N, M, start, end;
	static int[] distance, parentNode;
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
		parentNode = new int[N];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(parentNode, Integer.MAX_VALUE);
		edge = new ArrayList[N];
		for(int i=0; i<N; i++) {
			edge[i] = new ArrayList<>();
		}
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
		parentNode[start] = start;
		dijkstra();
	}
	private static void dijkstra() {
		while(!pq.isEmpty()) {
			Edge p = pq.poll();
			int next = p.v;
			if(distance[next] < p.dis) continue;
			for(Edge e : edge[next]) {
				if(distance[e.v] > distance[next] + e.dis) {
					distance[e.v] = distance[next] + e.dis;
					pq.offer(new Edge(e.v, e.dis));
					parentNode[e.v] = next;
				}
			}
//			System.out.println(Arrays.toString(parentNode));
		}
		System.out.println(distance[end]);
		int node = end;
		StringBuilder sb = new StringBuilder((end+1)+" ");
		while(node != start) {
			sb.append(parentNode[node]+1).append(" ");
			node = parentNode[node];
		}
		
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.reverse().toString());
	}
	
	
	
}
