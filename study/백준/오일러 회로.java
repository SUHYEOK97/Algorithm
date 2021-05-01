import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int start = -1;
	static int[][] adj;
	static StringBuilder sb  = new StringBuilder();
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		adj = new int[N][N];
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int count = 0;
			for(int j=0; j<N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
				count += adj[i][j];
				if(start == -1 && adj[i][j] > 0) start = i;
			}
			if(count % 2 == 1) {
				System.out.println("-1");
				System.exit(0);
			}
		}
		// 1. 순환 찾기
		// 2. 순환 했던 정점 중 아직 돌 수 있는 간선이 남아있는 정점 찾기
		// 3. 1번, 2번 반복
		dfs(start);
		for(int i=0; i<list.size(); i++) sb.append(list.get(i) + " ");
		System.out.println(sb);
	}
	private static void dfs(int start) {
		for(int i=0; i<N; i++) {
			if(adj[start][i] == 0) continue;
			adj[i][start]--;
			adj[start][i]--;
			dfs(i);
		}
		list.add(start+1);
		
	}
}
