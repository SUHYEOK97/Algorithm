import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static boolean[] check;
	static List<Integer>[] node;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		node = new ArrayList[N];
		check = new boolean[N];
		for(int i=0; i<N; i++) node[i] = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			node[from].add(to);
			node[to].add(from);
		}
		for(int i=0; i<N; i++) {
			if(!node[i].isEmpty()) {
				dfs(i, 1);
			}
		}
		System.out.println(0);
	}
	private static void dfs(int idx, int cnt) {
		check[idx] = true;
		if(cnt == 5) {
			System.out.println(1);
			System.exit(0);
		}
		for(int i=0; i<node[idx].size(); i++) {
			if(check[node[idx].get(i)]) continue;
			dfs(node[idx].get(i), cnt + 1);
		}
		check[idx] = false;
	}
}
