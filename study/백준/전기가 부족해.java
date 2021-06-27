import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[] node, elec;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static class Edge implements Comparable<Edge>{
    	int u,v,w;

		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        node = new int[n];
        elec = new int[k];
        for(int i=0; i<k; i++) elec[i] = Integer.parseInt(st.nextToken()) - 1;
        for(int i=0; i<n; i++) node[i] = i;
        int sum = 0;
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken()) - 1;
        	int v = Integer.parseInt(st.nextToken()) - 1;
        	int w = Integer.parseInt(st.nextToken());
        	pq.offer(new Edge(u, v, w));
        }
        while(!pq.isEmpty()) {
        	Edge edge = pq.poll();
        	if(!union(edge.u, edge.v)) sum += edge.w;
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
    	int cA = isConnected(node_a);
    	int cB = isConnected(node_b);
    	if(cA != -1 && cB != -1) return true;
    	if(cA == -1 && cB == -1) node[node_a] = node_b;
    	else {
    		if(cA == -1) node[node_a] = cB;
    		else node[node_b] = cA;
    	}
    	return false;
    }

	private static int isConnected(int idx) {
		for(int i=0; i<k; i++) if(elec[i] == idx) return elec[i];
		return -1;
	}
}
