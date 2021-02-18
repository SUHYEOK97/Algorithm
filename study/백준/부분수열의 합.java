import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] check;
	static Integer[] arr;
	static int ans;
	static int n;
	static int s;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new Integer[n];
		check = new boolean[n];
		s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
		recur(0, 0);
		System.out.println(ans);
	}
	private static void recur(int idx, int sum) {
		if(idx == n) return;
		int tmp = sum + arr[idx];
		if(tmp == s) ans++;
		recur(idx + 1, tmp);
		recur(idx + 1, sum);
	}
}
