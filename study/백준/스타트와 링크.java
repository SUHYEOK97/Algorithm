import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static boolean[] team;
	static int[][] arr;
	static int N;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		team = new boolean[N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) arr[i][j] = sc.nextInt();
		}
		
		recur(0, 0);
		System.out.println(ans);
	}
	public static void recur(int idx, int start) {
		if(idx==N/2) {
			int teamA = 0;
			int teamB = 0;
			
			for(int i=0; i<N; i++) {
				if(team[i]) {
					for(int j=i+1; j<N; j++) {
						if(team[j]) teamA += (arr[i][j] + arr[j][i]);
					}
				}
				else {
					for(int j=i+1; j<N; j++) {
						if(!team[j]) teamB += (arr[i][j] + arr[j][i]);
					}
				}
			}
			ans = Math.min(ans, Math.abs(teamA - teamB));
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(team[i]) continue;
			team[i] = true;
			recur(idx + 1, i+1);
			team[i] = false;
		}
		
	}
}
