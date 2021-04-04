import java.io.*;
import java.util.*;

public class Main {
	static int y, x;
	static boolean[][] visited;
	static String[][] map;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
	
	static String ans = "KAKTUS";
	
	static Queue<int[]> s = new LinkedList<>(); 
	static Queue<int[]> w = new LinkedList<>(); 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		visited = new boolean[y][x];
		map = new String[y][x];
		
		for(int i=0; i<y; i++) {
			String str = br.readLine();
			for(int j=0; j<x; j++) {
				map[i][j] = (str.charAt(j))+"";
				if(map[i][j].equals("*")) {
					map[i][j] = 0+"";
					w.offer(new int[] {i, j, 0});
				}
				if(map[i][j].equals("S")) {
					s.offer(new int[] {i, j, 0});
					visited[i][j] = true;
				}
			}
		}
		while(!w.isEmpty()) {
			int[] water = w.poll();
			for(int i=0; i<4; i++) {
				int cy = water[0] + dy[i];
				int cx = water[1] + dx[i];
				if(cy < 0 || cx < 0 || cy == y || cx == x) continue;
				if(map[cy][cx].equals(".")) {
					int move = water[2] + 1;
					map[cy][cx] = move+"";
					w.offer(new int[] {cy, cx, water[2] + 1});
				}
			}
		}
		out : while(!s.isEmpty()) {
			int[] p = s.poll();
			for(int i=0; i<4; i++) {
				int cy = p[0] + dy[i];
				int cx = p[1] + dx[i];
				if(cy < 0 || cx < 0 || cy == y || cx == x) continue;
				if(visited[cy][cx]) continue;
				if(map[cy][cx].equals("X")) continue;
				int move = p[2] + 1;
				if(map[cy][cx].equals("D")) {
					ans = move+"";
					break out;
				}
				visited[cy][cx] = true;
				
				if(!map[cy][cx].equals(".")) {
					int mcnt = Integer.parseInt(map[cy][cx]);
					if(mcnt > move) {
						s.offer(new int[] {cy, cx, p[2] + 1});
					}
				}
				else s.offer(new int[] {cy, cx, p[2] + 1});
			}
		}
		System.out.println(ans);
		
	}
//	public static void printf() {
//		System.out.println();
//		for(int i=0; i<y; i++) System.out.println(Arrays.toString(map[i]));
//	}
}
