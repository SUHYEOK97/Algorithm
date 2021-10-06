import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int l = 0;
		int r = 0;
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			r += arr[i];
		}
		l = Arrays.stream(arr).max().getAsInt();
		
		int m;
		int res = 0;
		while(l <= r) {
			m = (l+r)/2;
			int n = findN(m);
			if(n > K) l = m + 1;
			else {
				r = m - 1;
				res = m;
			}
		}
		System.out.println(res);
	}

	private static int findN(int m) {
		int n = 1;
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += arr[i];
			if(sum > m) {
				n++;
				sum = 0;
				i--;
			}
		}
		return n;
	}


}
