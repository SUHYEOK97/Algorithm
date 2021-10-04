import java.io.*;
import java.util.*;

public class Main {
	static int N, M, T;
	static int[] arr1, arr2;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			
			N = Integer.parseInt(br.readLine());
			arr1 = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) arr1[j] = Integer.parseInt(st.nextToken());
			
			
			M = Integer.parseInt(br.readLine());
			arr2 = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) arr2[j] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr1);
			binarySearch();
		}
		System.out.println(sb.toString());
	}
	private static void binarySearch() {
		for(int i=0; i<M; i++) {
			int findNumber = arr2[i];
			
			int r = N-1;
			int l = 0;
			int m;
			int res = 0;
			while(l <= r) {
				m = (r+l) / 2;
				if(arr1[m] == findNumber) {
					res = m;
					break;
				}
				else if(arr1[m] > findNumber) {
					r = m - 1;
				}
				else if(arr1[m] < findNumber) {
					l = m + 1;
				}
			}
			if(arr1[res] == findNumber) sb.append(1 + "\n");
			else sb.append(0 + "\n");
		}
	}
	
}
