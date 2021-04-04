import java.io.*;
import java.util.*;

public class Main {
	static int n, level=2, exp, curY, curX;
	static boolean[][] visited;
	static int[][] map;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
	
	static Queue<int[]> q = new LinkedList<>();
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static class Node implements Comparable<Node>{
		int y, x, dis;

		public Node(int y, int x, int dis) {
			this.y = y;
			this.x = x;
			this.dis = dis;
		}

		@Override
		public int compareTo(Node o) {
			if(this.dis == o.dis) {
				if(this.y == o.y) return this.x - o.x;
				return this.y - o.y;
			}
			return this.dis - o.dis;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					q.offer(new int[] {i, j, 0});
					curY = i;
					curX = j;
					map[i][j] = 0;
				}
			}
		}
		int distance = 0;
		while(checking()) {
			visited = new boolean[n][n];
			while(!q.isEmpty()) {
				int[] point = q.poll();
				
				for(int i=0; i<4; i++) {
					int cy = point[0] + dy[i];
					int cx = point[1] + dx[i];
					if(cy == n || cx == n || cy < 0 || cx < 0) continue;
					if(visited[cy][cx]) continue;
					if(map[cy][cx] > level) continue;
					if(map[cy][cx] != 0 && map[cy][cx] < level) pq.offer(new Node(cy, cx, point[2]+1));
					
					visited[cy][cx] = true;
					q.offer(new int[] {cy, cx, point[2] + 1});
				}
			}
			if(pq.isEmpty()) break;
			Node p = pq.poll();
			distance += p.dis;
			map[p.y][p.x] = 0; 
			q.offer(new int[] {p.y, p.x, 0});
			exp++;
			if(exp == level) {
				level++;
				exp = 0;
			}
			pq.clear();
		}
		System.out.println(distance);
		
		
	}
	public static boolean checking() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) if(map[i][j] != 0 && map[i][j] < level) return true;
		}
		return false;
	}
}
