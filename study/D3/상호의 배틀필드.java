import java.util.Scanner;

public class 상호의_배틀필드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			
			int x = 0;
			int y = 0;
			
			char[][] game = new char[h][w];
			for(int i=0; i<h; i++) {
				String str = sc.next();
				for(int j=0; j<w; j++) {
					game[i][j] = str.charAt(j);
					if(game[i][j] == '<' || game[i][j] == '>'
							|| game[i][j] == 'v' || game[i][j] == '^') {
						x = j;
						y = i;
					}
				}
			}
			int n = sc.nextInt();
			String command = sc.next();
			int[] dc = {-1, 1, 0, 0}; // y
			int[] dr = {0, 0, -1, 1}; // x
			int dir = 0;
			if(game[y][x]=='^') dir = 0;
			if(game[y][x]=='v') dir = 1;
			if(game[y][x]=='<') dir = 2;
			if(game[y][x]=='>') dir = 3;
			for(int i=0; i<n; i++) {
				char c = command.charAt(i);
				if(c == 'U') {
					game[y][x] = '^'; dir = 0;
					if(y > 0 && game[y-1][x] == '.') {
						game[y][x] = '.';
						game[--y][x] = '^';
					}
				}
				if(c == 'D') {
					game[y][x] = 'v'; dir = 1;
					if(y < h-1 && game[y+1][x] == '.') {
						game[y][x] = '.';
						game[++y][x] = 'v';
					}
				}
				if(c == 'L') {
					game[y][x] = '<'; dir = 2;
					if(x > 0 && game[y][x-1] == '.') {
						game[y][x] = '.';
						game[y][--x] = '<';
					}
				}
				if(c == 'R') {
					game[y][x] = '>'; dir = 3;
					if(x < w-1 && game[y][x+1] == '.') {
						game[y][x] = '.';
						game[y][++x] = '>';
					}
				}
				int curX = x;
				int curY = y;
				if(c == 'S') {
					while(true) {
						// 맵 끝으로 나가거나, 벽에 부딪히거나 
						curX += dr[dir];
						curY += dc[dir];
						if(curX < 0 || curX == w || curY < 0 || curY == h) break;
						if(game[curY][curX] == '#') {
							break;
						}
						if(game[curY][curX] == '*') {
							game[curY][curX] = '.';
							break;
						}
					}
				}
			}
			System.out.print("#"+tc+" ");
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					System.out.print(game[i][j]);
				}System.out.println();
			}
		}
	}
}
