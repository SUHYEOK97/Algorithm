import java.io.*;
import java.util.*;

public class Main {
	static int Y, X, ans=9876;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static char[] wall = {'A','B','C','D','E','F'};
	static char[] keys = {'a','b','c','d','e','f'};
	static int[] wallValue = {1,2,4,8,16,32};
	static char[][] map;
	static boolean[][][] visited;
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new char[Y][X];
		// 경우의 수 2^6
		// A B C D E F
		// 1 2 4 8 16 32
		visited = new boolean[64 + 1][Y][X]; // 64bit
		
		for(int i=0; i<Y; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for(int j=0; j<X; j++) {
				map[i][j] = sb.charAt(j);
				if(map[i][j] == '0') {
					q.offer(new int[] {i, j, 0, 0});
					visited[0][i][j] = true;
				}
			}
		}
		bfs();
		System.out.println(ans == 9876 ? -1 : ans);
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int[] o = q.poll();
			int move = o[2];
			long key = o[3];
			
			go : for(int i=0; i<4; i++) {
				int cy = o[0] + dy[i];
				int cx = o[1] + dx[i];
				if(cy < 0 || cx < 0 || cy == Y || cx == X) continue;
				if(visited[(int) key][cy][cx]) continue;
				if(map[cy][cx] == '#') continue;
				for(int j=0; j<6; j++) {
					if(wall[j] == map[cy][cx]) {
						if((wallValue[j] & o[3]) == 0) continue go;
						q.offer(new int[] {cy,cx,move + 1, o[3]});
						visited[(int) key][cy][cx] = true;
						continue go;
					}
				}
				for(int j=0; j<6; j++) {
					if(keys[j] == map[cy][cx]) {
						q.offer(new int[] {cy,cx,move + 1, (int) (key | wallValue[j])});
						visited[(int) (key | wallValue[j])][cy][cx] = true;
						continue go;
					}
				}
				if(map[cy][cx] == '1') {
					ans = move + 1;
					return;
				}
				visited[(int) key][cy][cx] = true;
				q.offer(new int[] {cy,cx,move + 1, (int) key});
			}
			
		}
	}
}
