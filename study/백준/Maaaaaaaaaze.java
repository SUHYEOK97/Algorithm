import java.io.*;
import java.util.*;

public class Main {
	static int ans=9876;
	static int[] r, arr;
	static int[][][] map, game;
	static boolean[][][] visited;
	static boolean[] check;
	static int[] dy = {-1, 0, 1, 0, 0, 0};
	static int[] dx = {0, -1, 0, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	static class Node{
		int y, x, z, move;

		public Node(int y, int x, int z, int move) {
			this.y = y;
			this.x = x;
			this.z = z;
			this.move = move;
		}
	}
	static Queue<Node> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		map = new int[5][5][5];
		game = new int[5][5][5];
		r = new int[5];
		arr = new int[5];
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<5; k++) map[i][j][k] = Integer.parseInt(st.nextToken());
			}
		}
		check = new boolean[5];
		dfs(0);
		System.out.println(ans == 9876 ? -1 : ans);
	}
	private static void rotateCount(int idx) {
		if(idx == 5) {
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					for(int k=0; k<5; k++) game[i][j][k] = map[arr[i]][j][k];
				}
			}
			for(int i=0; i<5; i++) for(int j=0; j<r[i]; j++) rotate(i);
			bfs();
			return;
		}
		for(int i=0; i<4; i++) {
			r[idx] = i;
			rotateCount(idx+1);
		}
	}
	private static void dfs(int idx) {
		if(idx == 5) {
			rotateCount(0);
			return;
		}
		for(int i=0; i<5; i++) {
			if(check[i]) continue;
			check[i] = true;
			arr[idx] = i;
			dfs(idx + 1);
			check[i] = false;
		}
	}
	private static void bfs() {
		q.offer(new Node(0, 0, 0, 0));
		visited = new boolean[5][5][5];
		if(game[0][0][0] == 0) return;
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i=0; i<6; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				int nz = node.z + dz[i];
				if(ny < 0 || ny >= 5 || nx < 0 || nx >= 5 || nz < 0 || nz >= 5) continue;
				if(visited[nz][ny][nx]) continue;
				if(game[nz][ny][nx] == 0) continue;
				visited[nz][ny][nx] = true;
				if(game[nz][ny][nx] == 1 && nz==4 && ny==4 && nx==4) {
					ans = Math.min(ans, node.move+1);
					return;
				}
				q.offer(new Node(ny, nx, nz, node.move+1));
			}
		}
	}
	private static void rotate(int idx) {
		int[][] tmp = new int[5][5];
		for(int i=0; i<5; i++) for(int j=0; j<5; j++) tmp[j][4-i] = game[idx][i][j];
		for(int i=0; i<5; i++) for(int j=0; j<5; j++) game[idx][i][j] = tmp[i][j];
	}
}
