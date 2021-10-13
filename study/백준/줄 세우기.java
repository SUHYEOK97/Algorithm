import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] arr;
	static int[] size;
	static Queue<Integer> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N];
		for(int i=0; i<N; i++) arr[i] = new ArrayList<>();
		size = new int[N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			size[end]++;
			arr[start].add(end);
		}
		for(int i=0; i<N; i++) if(size[i] == 0) {
			sb.append((i+1)).append(" ");
			q.offer(i);
			size[i]--;
		}
		while(!q.isEmpty()) {
			
			int num = q.poll();
			for(int i=0; i<arr[num].size(); i++) {
				int n = arr[num].get(i);
				size[n]--;
				if(size[n] == 0) {
					sb.append((n+1)).append(" ");
					q.offer(n);
					size[n]--;
				}
			}
			
		}
		System.out.println(sb.toString());
	}


}
