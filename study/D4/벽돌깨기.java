import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] game;
	static int[][] clone;
	static int[] idxList;
	static int[] dy = {0,0,-1,1};
	static int[] dx = {1,-1,0,0};
	static int n;
	static int w;
	static int h;
	static int ans = 99999;
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			game = new int[h][w];
			idxList = new int[n];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) game[i][j] = Integer.parseInt(st.nextToken());
			}
			ans = 99999;
			dfs(0);
			System.out.println("#"+tc+" "+ ans);
		}
		
	}
	private static void dfs(int cnt) {
		if(cnt == n) {
			setClone();
			for(int i=0; i<n; i++) {
				play(idxList[i]);
				if(checking()) {
					ans = 0;
					return;
				}
				down();
			}
			int count = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(clone[i][j] != 0) count++;
				}
			}
			ans = Math.min(count, ans);
			return;
		}
		for(int i=0; i<w; i++) {
			idxList[cnt] = i;
			dfs(cnt+1);
		}
	}

	private static void play(int idx) {
		for(int i=0; i<h; i++) {
			if(clone[i][idx] != 0) {
				bfs(i, idx);
				return;
			}
		}
	}

	private static void bfs(int y, int x) {
		
		q.offer(new int[] {y, x, clone[y][x]-1});
		while(!q.isEmpty()) {
			int[] p = q.poll();
			clone[p[0]][p[1]] = 0;
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<p[2]; j++) {
					int nY = p[0]+(dy[i]*(j+1));
					int nX = p[1]+(dx[i]*(j+1));
					if(nY >= h || nX >= w || nY < 0 || nX < 0) continue;
					if(clone[nY][nX] == 0) continue;
					q.offer(new int[] {nY,nX,clone[nY][nX]-1});
					clone[nY][nX] = 0;
				}
			}
		}
	}
	private static void down() {
		boolean flag = false;
		for(int i=h-1; i>=0; i--) {
			for(int j=0; j<w; j++) {
				if(i-1 >= 0 && (clone[i][j] == 0 && clone[i-1][j] != 0)) {
					clone[i][j] = clone[i-1][j];
					clone[i-1][j] = 0;
					flag = true;
				}
			}
		}
		if(flag) down();
	}
	
	public static boolean checking() {
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) if(clone[i][j] != 0) return false;
		}
		return true;
	}
	
	private static void setClone() {
		clone = new int[h][w];
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				clone[i][j] = game[i][j];
			}
		}
	}
}
