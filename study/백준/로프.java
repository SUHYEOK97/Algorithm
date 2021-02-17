import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int ans = 0;
		for(int i=0; i<n; i++) {
			int tmp = (arr.length - i) * arr[i];
			ans = Math.max(ans, tmp);
		}
		System.out.println(ans);
	}
}
