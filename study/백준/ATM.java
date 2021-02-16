import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				ans += arr[j];
			}
		}
		System.out.println(ans);
	}
}
