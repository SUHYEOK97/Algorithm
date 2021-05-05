import java.io.*;
import java.util.*;

public class Main {
	static int N,M,ans;
	static int[][] arr;
	static int[] count;
	static ArrayList<Integer> index = new ArrayList<>();
	static int size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		M -= 5;
		if(M < 0) {
			System.out.println(0);
			System.exit(0);
		}
		arr = new int[N][26];
		count = new int[N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) arr[i][str.charAt(j) - 'a'] = 1;
		}
		for(int i=0; i<N; i++) {
			arr[i]['a' - 'a'] = 0;
			arr[i]['c' - 'a'] = 0;
			arr[i]['i' - 'a'] = 0;
			arr[i]['t' - 'a'] = 0;
			arr[i]['n' - 'a'] = 0;
		}
		for(int i=0; i<N; i++) {
			int cnt = 0;
			for(int j=0; j<26; j++) {
				if(arr[i][j]==1) {
					if(!index.contains(j)) index.add(j);
					cnt++;
				}
			}
			count[i] = cnt;
		}
		size = index.size();
		Collections.sort(index);
		dfs(0);
		System.out.println(ans);
	}
	private static void dfs(int idx) {
		if(idx == size || M <= 0) {
			int cnt = 0;
			for(int i=0; i<N; i++) if(count[i] == 0) cnt++;
			ans = Math.max(ans, cnt);
			return;
		}
		for(int i=0; i<N; i++) if(arr[i][index.get(idx)] == 1) count[i]--;
		M--;
		dfs(idx + 1);
		for(int i=0; i<N; i++) if(arr[i][index.get(idx)] == 1) count[i]++;
		M++;
		dfs(idx + 1);
	}
	
}
