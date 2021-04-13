import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] arr;
	static int[] colorSum;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][3];
		colorSum = new int[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int color = Integer.parseInt(st.nextToken()) - 1;
			int size = Integer.parseInt(st.nextToken());
			arr[i][0] = color;
			arr[i][1] = size;
			arr[i][2] = i;
		}
		
		Arrays.sort(arr, (o1, o2) -> o1[1] - o2[1]);
		
		int[] answer = new int[n];
		int sum = 0;
		int idx = 0;
		for (int i = 0; i < n; i++) {
			int[] o = arr[i];
			
			while(o[1] > arr[idx][1]) {
				sum += arr[idx][1];
				colorSum[arr[idx][0]] += arr[idx][1];
				idx++;
			}
			answer[o[2]] += sum - colorSum[o[0]];
		}

		for (int i = 0; i < n; i++)
			sb.append(answer[i]).append("\n");
		System.out.println(sb);
	}

}
