import java.io.*;
import java.util.*;

public class Main {
	static int N, M, T;
	static int[][] map;
	static StringBuilder sb  = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int x, d, k;
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			for(int j=1; j*x<=N; j++) {
				for(int y=0; y<k; y++) {
					if(d == 0) turn(j*x);
					if(d == 1) inverse(j*x);
				}
			}
			if(!getRidOf()) {
				int cnt = 0;
				int sum = 0;
				for(int n=0; n<N; n++) {
					for(int m=0; m<M; m++) {
						sum += map[n][m];
						if(map[n][m] != 0) cnt++;
					}
				}
				float avg = (float) sum / cnt;
				
				for(int n=0; n<N; n++) {
					for(int m=0; m<M; m++) {
						if(map[n][m] == 0) continue;
						if(map[n][m] < avg) map[n][m]++;
						else if(map[n][m] > avg) map[n][m]--;
					}
				}
			}
		}
		int res = 0;
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(map[n][m] != 0) res += map[n][m];
			}
		}
		System.out.println(res);
	}
	
	private static void turn(int j) {
		for(int i=M-1; i>0; i--) swap(j, i, (i+1) % M);
	}
	private static void inverse(int j) {
		for(int i=0; i<M-1; i++) swap(j, i, i+1);
	}
	private static void swap(int j,int x, int y) {
		int tmp = map[j-1][x];
		map[j-1][x] = map[j-1][y];
		map[j-1][y] = tmp;
	}
	private static boolean getRidOf() {
		boolean res = false;
		Queue<int[]> q = new LinkedList<>();
		for(int i=0; i<N; i++) {
			if(map[i][0] == map[i][M-1] && map[i][0] != 0 && map[i][M-1] != 0) {
				q.offer(new int[] {i, 0});
				q.offer(new int[] {i, M-1});
				res = true;
			}
			for(int j=0; j<M-1; j++) {
				if(map[i][j] == map[i][j+1] && map[i][j] != 0 && map[i][j+1] != 0) {
					q.offer(new int[] {i, j+1});
					q.offer(new int[] {i, j});
					res = true;
				}
			}
			if(i < N-1) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == map[i+1][j] && map[i][j] != 0 && map[i+1][j] != 0) {
						q.offer(new int[] {i, j});
						q.offer(new int[] {i+1, j});
						res = true;
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			map[tmp[0]][tmp[1]] = 0;
		}
		return res;
	}
	
	
}
