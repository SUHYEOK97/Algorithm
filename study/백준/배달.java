import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int Y, X, ans=99998;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[][][][] m;
	static char[][] map;
	static boolean[][][] visited;
	static Queue<Node> q = new LinkedList<>();
	static class Node{
		int y,x,move,pDir,f,fy,fx;

		public Node(int y, int x, int move, int pDir, int f, int fy, int fx) {
			this.y = y;
			this.x = x;
			this.move = move;
			this.pDir = pDir;
			this.f = f;
			this.fy = fy;
			this.fx = fx;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new char[Y][X];
		m = new int[3][Y][X][4];
		char cnt = '1';
		for(int i=0; i<Y; i++) {
			String str = br.readLine();
			for(int j=0; j<X; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') q.offer(new Node(i, j, 0, -1, 0, -1, -1));
				if(map[i][j] == 'C') map[i][j] = cnt++;
			}
		}
		bfs();
		System.out.println(ans == 99998 ? -1 : ans);
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			Node o = q.poll();
			
			for(int i=0; i<4; i++) {
				if(o.pDir == i) continue;
				int ny = dy[i] + o.y;
				int nx = dx[i] + o.x;
				if(ny < 0 || nx < 0 || ny == Y || nx == X) continue;
				if(map[ny][nx] == '#') continue;
				if(m[o.f][ny][nx][i] == 2) continue;
				if(map[ny][nx] == '1' || map[ny][nx] == '2') {
					
					if(ny == o.fy && nx == o.fx) {
						q.offer(new Node(ny,nx,o.move+1,i,o.f,ny,nx));
						m[o.f][ny][nx][i]++;
					}
					else {
						if((o.f == 1 && map[ny][nx] == '2') || (o.f == 2 && map[ny][nx] == '1')) {
							ans = o.move+1;
							return;
						}
						q.offer(new Node(ny,nx,o.move+1,i,map[ny][nx]-48,ny,nx));
					}
				} else {
					m[o.f][ny][nx][i]++;
					q.offer(new Node(ny,nx,o.move+1,i,o.f,o.fy,o.fx));
				}
			}
			
		}
	}
	
}
