import java.io.*;
import java.util.*;

public class Main {
	static int[] answer;
	static char[][] check;
	static boolean[] visited;
	static int n, size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		answer = new int[n];
		visited = new boolean[n];
		check = new char[n][n];
		String c = br.readLine();
		int idx = 0;
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++, idx++) {
				check[i][j] = c.charAt(idx);
			}
		}
		size = c.length();
		dfs(0);
	}
	private static void dfs(int idx) {
		if(idx == n) {
			for(int i=0; i<n; i++) System.out.print(answer[i] + " ");
			System.exit(0);
		}
		for(int i=-10; i<=10; i++) {
			answer[idx] = i;
			visited[idx] = true;
			if(!checking(idx)) dfs(idx+1);
			visited[idx] = false;
		}
	}
	
	private static boolean checking(int idx) {
		int sum = 0;
		for(int j=idx; j>=0; j--) {
			sum += answer[j];
			if(!visited[idx]) return true;
			if(check[j][idx] == '0' && sum != 0) return true;
			if(check[j][idx] == '+' && sum <= 0) return true;
			if(check[j][idx] == '-' && sum >= 0) return true;
		}
		return false;
	}
	
}
