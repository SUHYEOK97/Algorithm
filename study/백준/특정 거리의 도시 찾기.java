import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, X;
	static int[] d;
	static boolean[] check;
	
	static ArrayList<Node>[] nodes;
	static class Node implements Comparable<Node>{
		int next;
		int weight = 1;
		public Node(int next) {
			this.next = next;
		}
		public Node(int next, int weight) {
			this.next = next;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 도시의 개수
		M = Integer.parseInt(st.nextToken()); // 도로의 개수
		K = Integer.parseInt(st.nextToken()); // 거리 정보
		X = Integer.parseInt(st.nextToken())-1; // 출발 도시 번호
		check = new boolean[N];
		nodes = new ArrayList[N];
		for(int i=0; i<N; i++) nodes[i] = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int next = Integer.parseInt(st.nextToken()) - 1;
			nodes[start].add(new Node(next));
		}
		d = new int[N];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[X] = 0;
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(X));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(check[cur.next]) continue;
			check[cur.next] = true;
			
			for(Node n : nodes[cur.next]) {
				if(d[n.next] > d[cur.next] + n.weight) {
					d[n.next] = d[cur.next] + n.weight;
					q.offer(new Node(n.next, d[n.next]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			if(d[i] == K) sb.append(i+1).append("\n");
		}
		System.out.println(sb.length() == 0 ? "-1" : sb);
		
	}
	
	
}
