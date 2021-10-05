import java.io.*;
import java.util.*;

public class Main {
	static int K, N;
	static long[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new long[K];
		for (int i = 0; i < K; i++) arr[i] = Integer.parseInt(br.readLine());
		long r = Arrays.stream(arr).max().getAsLong();
		long l = 1;
		long m;
		long res = 1;
		long getNum;
		while (l <= r) {
			m = (l + r) / 2;
			getNum = returnValue(m);

			if (getNum < N) {
				r = m - 1;
			} 
			else if (getNum >= N) {
				res = m;
				l = m + 1;
			}
		}

		System.out.println(res);
	}

	public static long returnValue(long m) {
		long sum = 0;
		for (int i = 0; i < K; i++) {
			sum += arr[i] / m;
		}
		return sum;
	}

}
