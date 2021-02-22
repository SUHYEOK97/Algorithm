import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int ans[];
	static StringBuilder sb;
	static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			ans = new int[6];
			sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			int[] arr = new int[k];
			for(int i=0; i<k; i++) arr[i] = Integer.parseInt(st.nextToken());
			perm(arr, 0, 0);
			System.out.println(sb);
		}
	}
	public static void perm(int[] arr, int idx, int start) {
		if(idx == 6) {
			for(int i=0; i<6; i++) sb.append(ans[i] + " ");
			sb.append("\n");
			return;
		}
		for(int i=start; i<k; i++) {
			ans[idx] = arr[i];
			perm(arr, idx+1, i + 1);
		}
	}
}
