import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr, dp, idx;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N + 1];
		dp = new int[N + 1];
		idx = new int[N + 1];
		for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());
		int maxIdx = 0;
		int max = -1;
		for(int i=1; i<=N; i++) {
			dp[i] = 1;
			for(int j=1; j<i; j++) {
				if(arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
					idx[i] = j;
				}
			}
			if(max < dp[i]) {
				max = dp[i];
				maxIdx = i;
			}
		}
		Stack<Integer> answer = new Stack<>();
		while(maxIdx != 0){
			answer.push(arr[maxIdx]);
			maxIdx = idx[maxIdx];
		}
		System.out.println(max);
		while(!answer.isEmpty()) System.out.print(answer.pop() + " ");
	}
}
