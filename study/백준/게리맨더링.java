import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] population;
	static int[][] relation;
	static boolean[] check;
	static boolean[] visited;
	static int a;
	static int b;
	static int ans = 99999;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		population = new int[n];
		relation = new int[n][n];
		check = new boolean[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) population[i] = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int[] tmp = new int[Integer.parseInt(st.nextToken())];
			for(int j=0; j<tmp.length; j++) tmp[j] = Integer.parseInt(st.nextToken()) - 1;		
			relation[i] = tmp;
		}
		div(0);
		System.out.println(ans == 99999 ? "-1" : ans);
	}
	private static void div(int idx) {
		if(idx == n) {
			if(checking()) return;
			visited = new boolean[n];
			bfs(true);	bfs(false);
			for(int i=0; i<n; i++) {
				if(!visited[i]) return;
			}
			a = 0;	b = 0;
			for(int i=0; i<n; i++) {
				if(check[i]) a += population[i];
				else b += population[i];
			}
			ans = Math.min(ans, Math.abs(a-b));
			return;
		}
		if(check[idx]) return;
		check[idx] = true;
		div(idx + 1);
		check[idx] = false;
		div(idx + 1);
	}
	private static void bfs(boolean flag) {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<n; i++) {
			if(check[i] == flag) {
				q.offer(i);
				break;
			}
		}
		while(!q.isEmpty()) {
			int point = q.poll();
			if(check[point] != flag) continue;
			if(visited[point]) continue;
			visited[point] = true;
			for(int i=0; i<relation[point].length; i++) {
				q.offer(relation[point][i]);
			}
		}
	}
	private static boolean checking() {
		int cnt = 0;
		for(int i=0; i<n; i++) {
			if(check[i]) cnt++;
		}
		if(cnt == n || cnt == 0) return true;
		return false;
	}
}
