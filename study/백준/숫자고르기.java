import java.io.*;
import java.util.*;

public class Main {
	static int N, ans;
	static int[] arr;
	static boolean[] check, visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		check = new boolean[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(br.readLine());
		for(int i=1; i<=N; i++) {
			if(check[i]) continue; 
			dfs(i, i);
		}
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=1; i<=N; i++) if(check[i]) answer.add(arr[i]);
		Collections.sort(answer);
		System.out.println(answer.size());
		for(int i=0; i<answer.size(); i++) System.out.println(answer.get(i));
	}
	private static void dfs(int idx, int start) {
		if(visited[idx] && idx == start) {
			for(int i=1; i<=N; i++) {
				if(visited[i] && !check[i]) check[i] = true;
			}
		}
		if(visited[idx]) return;
		
		visited[idx] = true;
		dfs(arr[idx], start);
		visited[idx] = false;
	}
	
}
