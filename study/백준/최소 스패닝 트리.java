import java.io.*;
import java.util.*;

public class Main {
	static int v,e;
	static int[] root;
	static Edge[] node;
	static class Edge{
		int from, to, weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		node = new Edge[e];
		root = new int[v];
		for(int i=0; i<v; i++) root[i] = i;
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken()) - 1;
			int t = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			node[i] = new Edge(f, t, w);
		}
		Arrays.sort(node, (o1,o2)->o1.weight-o2.weight);
		
		int cnt = 0;	int ans = 0;
		for(int i=0; i<e; i++) {
			if(cnt == v-1) continue;
			if(getParent(node[i].from) == getParent(node[i].to)) continue;
			union(node[i].from, node[i].to);
			ans += node[i].weight;
			cnt++;
		}
		System.out.println(ans);
	}
	
	public static int getParent(int idx) {
		if(idx == root[idx]) return idx;
		return getParent(root[idx]);
	}
	
	public static void union(int a, int b) {
		int rA = getParent(a);
		int rB = getParent(b);
		if(rA == rB) return;
		if(rA < rB) root[rB] = rA;
		else root[rA] = rB;
	}
	

}
