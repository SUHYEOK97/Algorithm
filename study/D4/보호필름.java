import java.io.*;
import java.util.*;

public class Solution {
    static int Y,X,K,ans;
    static int[][] map, game;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int tc= 1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            Y = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            ans = 999;
            map = new int[Y][X]; 	game = new int[Y][X];
            for(int i=0; i<Y; i++) {
            	st = new StringTokenizer(br.readLine());
            	for(int j=0; j<X; j++) {
            		map[i][j] = Integer.parseInt(st.nextToken());
            		game[i][j] = map[i][j];
            	}
            }
            sb.append("#").append(tc).append(" ");
            dfs(0, 0);
            dfs(0, 0);
            if(checking()) sb.append(0).append("\n");
            else {
            	dfs(0, 0);
            	sb.append(ans).append("\n");
            }
        }
        System.out.println(sb);
    }
	private static void dfs(int idx, int cnt) {
		if(ans < cnt) return;
		if(idx == Y) {
			if(!checking()) return;
			ans = Math.min(ans, cnt);
			return;
		}
		dfs(idx + 1, cnt);
		for(int i=0; i<X; i++) game[idx][i] = 0;
		dfs(idx + 1, cnt + 1);
		for(int i=0; i<X; i++) game[idx][i] = 1;
		dfs(idx + 1, cnt + 1);
		for(int i=0; i<X; i++) game[idx][i] = map[idx][i];
	}
	public static boolean checking() {
		if(K == 1) return true;
		for(int i=0; i<X; i++) {
			int cnt = 0;
			for(int j=1; j<Y; j++) {
				if(game[j-1][i] == game[j][i]) cnt++;
				else cnt = 0;
				if(cnt == K-1) break;
			}
			if(cnt < K-1) return false;
		}
		return true;
	}
}
