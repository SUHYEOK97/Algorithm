import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3 {
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
	static int y;
	static int x;
	static int ans;
	static char[][] c;
	static boolean[][] visited;
	static int[][] visitedCnt;
	static StringBuilder sb =  new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			c = new char[y][x];
			ans = 0;
			for(int i=0; i<y; i++) {
				String str = br.readLine();
				for(int j=0; j<x; j++) c[i][j] = str.charAt(j);
			}
			visitedCnt = new int[y][x];
			visited = new boolean[y][x];
			bfs();
			for(int i=0; i<y; i++) {
				for(int j=0; j<x; j++) if(c[i][j] == 'L') ans += visitedCnt[i][j];
			}
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
		System.exit(0);
	}
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				if(c[i][j] == 'W') {
					visited[i][j] = true;
					q.offer(new int[] {i, j});
				}
			}
		}
		int cnt = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				int[] p = q.poll();
				for(int j=0; j<4; j++) {
					int curY = p[0]+dy[j];
					int curX = p[1]+dx[j];
					if(curY >= y || curX >= x || curY < 0 || curX < 0) continue;
					if(visited[curY][curX]) continue;
					visited[curY][curX] = true;
					visitedCnt[curY][curX] = cnt;
					q.offer(new int[] {curY,curX});
				}
			}
			cnt++;
		}
	}
}
