import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int v, e, start;
	static int[] d;
	static boolean[] check;
	
	static ArrayList<Node> nodeList[];
	static class Node implements Comparable<Node>{
		int weight, next;

		public Node(int next, int weight) {
			this.weight = weight;
			this.next = next;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		d = new int[v];
		check = new boolean[v];
		e = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine()) - 1;
		nodeList = new ArrayList[v];
		for(int i=0; i<v; i++) nodeList[i] = new ArrayList<>();
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int cur = Integer.parseInt(st.nextToken()) - 1;
			int next = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			nodeList[cur].add(new Node(next, weight));
		}
		Arrays.fill(d, Integer.MAX_VALUE);
		d[start] = 0;
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			
			if(check[curNode.next]) continue;
			check[curNode.next] = true;
			
			// 값 갱신
			// 기존에 가진 Node가중치보다 더 낮을 경우에만 
			for(Node nextNode : nodeList[curNode.next]) {
				if(d[nextNode.next] >= d[curNode.next] + nextNode.weight) {
					d[nextNode.next] = d[curNode.next] + nextNode.weight;
					q.offer(new Node(nextNode.next, d[nextNode.next]));
				}
			}
		}
		for(int i=0; i<v; i++) {
			if(d[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(d[i]);
		}
	}
	
}
