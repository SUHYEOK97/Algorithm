import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static int[] ans;
	static boolean[] check;
	static int max = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		ans = new int[n];
		check = new boolean[n];
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		comb(0);
		System.out.println(max);
	}
	
	public static void comb(int idx) {
		if(idx == n) {
			int sum = 0;
			for(int i=1; i<n; i++) {
				sum += Math.abs(ans[i-1] - ans[i]);
			}
			max = Math.max(sum, max);
			return;
		}
		for(int i=0; i<n; i++) {
			if(check[i]) continue;
			check[i] = true;
			ans[idx] = arr[i];
			comb(idx + 1);
			check[i] = false;
		}
	}
	
}
