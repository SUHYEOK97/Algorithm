import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,1,-1};
	static int y,x,size,ans;
	static int[][] map, clone;
	static boolean[][] visited;
	static boolean[] check;
	static ArrayList<int[]> wallList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		map = new int[y][x];
		for(int i=0; i<y; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<x; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) wallList.add(new int[] {i, j});
			}
		}
		size = wallList.size();
		check = new boolean[size];
		dfs(0);
		System.out.println(ans);
	}
	private static void dfs(int idx) {
		if(idx == 3) {
			int j = 0;
			int[] wall = new int[3];
			for(int i=0; i<size; i++) if(check[i]) wall[j++] = i;
			bfs(wall);
			ans = Math.max(get(), ans);
			return;
		}
		for(int i=0; i<size; i++) {
			if(check[i]) continue;
			check[i] = true;
			dfs(idx + 1);
			check[i] = false;
		}
	}
	private static void bfs(int[] wall) {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[y][x];
		mkClone(wall);
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				if(map[i][j] == 2) {
					q.offer(new int[] {i,j});
				}
			}
		}
		while(!q.isEmpty()) {
			int[] p = q.poll();
			for(int i=0; i<4; i++) {
				int cY = p[0] + dy[i];
				int cX = p[1] + dx[i];
				if(cY < 0 || cX < 0 || cY == y || cX == x) continue;
				if(visited[cY][cX]) continue;
				if(clone[cY][cX] == 1) continue;
				clone[cY][cX] = 2;
				visited[cY][cX] = true;
				q.offer(new int[] {cY, cX});
			}
		}
	}
	public static void mkClone(int[] wall) {
		clone = new int[y][x];
		for(int i=0; i<y; i++) for(int j=0; j<x; j++) {
			clone[i][j] = map[i][j];
		}
		clone[wallList.get(wall[0])[0]][wallList.get(wall[0])[1]] = 1;
		clone[wallList.get(wall[1])[0]][wallList.get(wall[1])[1]] = 1;
		clone[wallList.get(wall[2])[0]][wallList.get(wall[2])[1]] = 1;
	}
	public static int get() {
		int num = 0;
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) if(clone[i][j] == 0) num++;
		}
		return num;
	}
}
/*
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
ans : 27
 */
