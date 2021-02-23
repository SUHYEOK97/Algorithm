import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int y;
	static int x;
	static char[][] map;
	static int[] checkX;
	static int[] checkG;
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		map = new char[y][x];
		checkX = new int[x];
		checkG = new int[x];
		boolean[] check = new boolean[x];
		boolean[] tmp = new boolean[x];
		for(int i=0; i<y; i++) {
			String str = br.readLine();
			for(int j=0; j<x; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'X') {
					tmp[j] = true;
					checkX[j] = i;
				}
				if(map[i][j] == '#' && !check[j]) {
					check[j] = true;
					checkG[j] = i;
				}
			}
		}
		int maxMove = 3000;
		for(int i=1; i<x; i++) {
			if(tmp[i]) maxMove = Math.min(maxMove, checkG[i] - checkX[i]);
		}
		maxMove--;
		for(int i=y-1; i>=0; i--) {
			for(int j=x-1; j>=0; j--) {
				if(map[i][j] == 'X') {
					if(i+maxMove < y) {
						map[i][j] = '.';
						map[i+maxMove][j] = 'X';
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}
