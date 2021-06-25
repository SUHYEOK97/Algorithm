import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] node;
    static int[][] arr;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static class Edge implements Comparable<Edge>{
    	int u, v;
    	double w;

		public Edge(int u, int v, double w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        node = new int[n];
        arr = new int[n][2];
        double sum = 0;
        for(int i=0; i<n; i++) node[i] = i;
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	arr[i] = new int[] {u,v};
        }
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken())-1;
        	int v = Integer.parseInt(st.nextToken())-1;
        	union(u, v);
        }
        for(int i=0; i<n; i++) {
        	for(int j=i; j<n; j++) {
        		if(i == j) continue;
        		pq.offer(new Edge(i, j, getDistance(i, j)));
        	}
        }
        while(!pq.isEmpty()) {
        	Edge edge = pq.poll();
        	if(!union(edge.u, edge.v)) sum += edge.w;
        }
        System.out.printf("%.2f", sum);
    }
    public static double getDistance(int i, int j) {
    	double a = Math.pow(Math.abs(arr[i][0] - arr[j][0]), 2);
    	double b = Math.pow(Math.abs(arr[i][1] - arr[j][1]), 2);
    	return Math.sqrt(a+b);
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
