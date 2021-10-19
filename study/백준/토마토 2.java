import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int Y, X, Z;
	static int[] dz = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0 ,0};
	static int[] dx = {0, 0, 0, 0, -1 ,1};
	static int[][][] map;
	static boolean[][][] check;
	static Queue<Node> q = new LinkedList<>();
	static class Node{
		int z,y,x,step;
		public Node(int z, int y, int x, int step) {
			this.z = z;
			this.y = y;
			this.x = x;
			this.step = step;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		Z = Integer.parseInt(st.nextToken());
		map = new int[Z][Y][X];
		check = new boolean[Z][Y][X];
		for(int i=0; i<Z; i++) {
			for(int j=0; j<Y; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<X; k++) {
					int num = Integer.parseInt(st.nextToken());
					map[i][j][k] = num;
					if(map[i][j][k] == 1) {
						q.offer(new Node(i, j, k, 0));
						check[i][j][k] = true;
					}
				}
			}
		}
		bfs();
	}
	private static void bfs() {
		int ans = 0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i=0; i<6; i++) {
				int nY = node.y + dy[i];
				int nX = node.x + dx[i];
				int nZ = node.z + dz[i];
				if(nY < 0 || nZ < 0 || nX < 0 || nY == Y || nZ == Z || nX == X) continue;
				if(check[nZ][nY][nX]) continue;
				if(map[nZ][nY][nX] != 0) continue;
				check[nZ][nY][nX] = true;
				map[nZ][nY][nX] = 1;
				q.offer(new Node(nZ, nY, nX, node.step + 1));
			}
			ans = Math.max(ans, node.step);
		}
		for(int i=0; i<Z; i++) {
			for(int j=0; j<Y; j++) {
				for(int k=0; k<X; k++) {
					if(map[i][j][k] == 0) ans = -1;
				}
			}
		}
		System.out.println(ans);
	}
}
