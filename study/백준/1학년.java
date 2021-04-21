import java.io.*;
import java.util.*;

public class Main {
	static int N, ANSWER;
	static int[] arr;
	static long[][] sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N-1];
		sum = new long[100][21];
		for(int i=0; i<N-1; i++) arr[i] = Integer.parseInt(st.nextToken());
		sum[0][arr[0]] = 1;
		ANSWER = Integer.parseInt(st.nextToken());
		for(int i=1; i<N-1; i++) {
			for(int j=0; j<21; j++) {
				if(sum[i-1][j] == 0) continue;
				int minus = j - arr[i];
				int plus = j + arr[i];
				if(minus <= 20 && minus >= 0) sum[i][minus] += sum[i-1][j];
				if(plus <= 20 && plus >= 0) sum[i][plus] += sum[i-1][j];
			}
		}
		System.out.println(sum[N-2][ANSWER]);
	}
}
