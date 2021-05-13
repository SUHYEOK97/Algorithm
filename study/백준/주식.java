import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[n];
			for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
			long money = 0;
			int top = -1;
			for(int i=n-1; i>=0; i--) {
				if(arr[i] > top) {
					top = Math.max(arr[i], top);
				}
				else {
					money += (top - arr[i]);
				}
			}
			System.out.println(money);
		}
	}
}
