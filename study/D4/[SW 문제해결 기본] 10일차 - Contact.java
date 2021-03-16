import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int start;
	static ArrayList<Integer> arr[];
	static int ans;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();
	static Queue<int[]> q = new LinkedList<>();
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken())+1;
			start = Integer.parseInt(st.nextToken());
			arr = new ArrayList[N];
			check = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) arr[i] = new ArrayList<>();
			
			for(int i=0; i<N/2; i++) {
				int id = Integer.parseInt(st.nextToken());
				arr[id].add(Integer.parseInt(st.nextToken()));
			}
			sb.append("#"+tc);
			bfs(start);
		}
		System.out.println(sb);
	}
	private static void bfs(int idx) {
		q.offer(new int[] {idx, 0});
		check[idx] = true;
		int a[] = {0, 0};
		while(!q.isEmpty()) {
			int[] point = q.poll();
			if(a[1] < point[1]) a = new int[]{point[0], point[1]};
			else if(a[1] == point[1]) a[0] = Math.max(a[0], point[0]);
			
			for(int i=0; i<arr[point[0]].size(); i++) {
				if(check[arr[point[0]].get(i)]) continue;
				check[arr[point[0]].get(i)] = true;
				q.offer(new int[] {arr[point[0]].get(i), point[1] + 1});
			}
		}
		sb.append(" "+ a[0] +"\n");
	}
	
}
