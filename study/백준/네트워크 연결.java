import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] node;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static class Edge implements Comparable<Edge>{
    	int start, end, weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        node = new int[n];
        for(int i=0; i<n; i++) node[i] = i;
        m = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken()) - 1;
        	int end = Integer.parseInt(st.nextToken()) - 1;
        	int weight = Integer.parseInt(st.nextToken());
        	pq.offer(new Edge(start, end, weight));
        }
        int sum = 0;
        while(!pq.isEmpty()) {
        	Edge edge = pq.poll();
        	if(!union(edge.start, edge.end)) sum += edge.weight;
        }
        System.out.println(sum);
    }
    
    
    public static int getNode(int i) {
    	if(i == node[i]) return i;
    	return getNode(node[i]);
    }
    public static boolean union(int a, int b) {
    	int node_a = getNode(a);
    	int node_b = getNode(b);
    	
    	if(node_a == node_b) return true;
    	
    	if(node_a > node_b) node[node_a] = node_b;
    	else node[node_b] = node_a;
    	return false;
    }
}
