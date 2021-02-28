import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] dice;
	public static int n;
	public static int top;
	public static int bottom;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// (0,5) (1,3) (2,4) 
		n = Integer.parseInt(br.readLine());
		dice = new int[n][6];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<6; j++) dice[i][j] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		for(int i=0; i<6; i++) ans = Math.max(ans, find(i));
		System.out.println(ans);
	}
	
	public static int find(int start) {
		int ans = 0;
		bottom = dice[0][start];
		findTop(0, start);
		ans += findMaxNum(0, top, bottom);
		for(int i=1; i<n; i++) {
			for(int j=0; j<6; j++) {
				if(top == dice[i][j]) {
					bottom = top;
					findTop(i, j);
					break;
				}
			}
			ans += findMaxNum(i, top, bottom);
		}
		return ans;
	}
	public static int findMaxNum(int idx, int top, int bottom) {
		int max = 0;
		for(int i=0; i<6; i++) {
			if(dice[idx][i] != top && dice[idx][i] != bottom) max = Math.max(max, dice[idx][i]);
		}
		return max; 
	}
	
	public static void findTop(int i, int j) {
		if(j == 0) top = dice[i][5];
		else if(j == 1) top = dice[i][3];
		else if(j == 2) top = dice[i][4];
		else if(j == 3) top = dice[i][1];
		else if(j == 4) top = dice[i][2];
		else if(j == 5) top = dice[i][0];
	}

}
