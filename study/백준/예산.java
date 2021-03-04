import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long max;
	static int[] arr;
	static long ans = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}
		Arrays.sort(arr);
		max = Long.parseLong(br.readLine());
		search();
		System.out.println(ans);
	}
	private static void search() {
		int start = 0;
		int end = arr[n-1];
		while(start <= end) {
			int mid = (start+end) / 2;
			long s = avg(mid);
			if(s > max) end = mid-1;
			else if(s <= max) {
				start = mid+1;
				ans = Math.max(mid, ans);
			}
		}
	}
	public static long avg(int mid) {
		long sum = 0;
		for(int i=0; i<n; i++) {
			if(arr[i] <= mid) sum += arr[i];
			else sum += mid;
		}
		return sum;
	}
	
}
