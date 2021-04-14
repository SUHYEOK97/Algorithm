import java.io.*;
import java.util.*;

public class Main {
	
	static int N, E;
	static int[][] map;
	static int[] ans;
	
	// 1. child가 몇개인지 세고
	// 2. 역추적
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		ans = new int[N];
		for(int i=0; i<N; i++) Arrays.fill(map[i], 9999999);
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			map[from][to] = 1;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i == j) continue;
				for(int k=0; k<N; k++) {
					if(j == k || k == i) continue;
					map[j][k] = Math.min(map[j][i] + map[i][k], map[j][k]);
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 9999999) continue;
				ans[i]++; 	ans[j]++;
			}
		}
		int cnt = 0;
		for(int i=0; i<N; i++) if(ans[i] == N-1) cnt++;
		System.out.println(cnt);
	}
	
}
