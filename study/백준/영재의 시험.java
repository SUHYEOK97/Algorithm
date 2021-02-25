import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] my;
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[10];
		my = new int[10];
		for(int i=0; i<10; i++) arr[i] = Integer.parseInt(st.nextToken());
		// 1121121121
		dfs(0, 0);
		System.out.println(count);
	}
	private static void dfs(int idx, int cntAns) {
		if(idx == 10) {
			int num = 0;
			for(int i=0; i<10; i++) {
				if(arr[i] == my[i]) num++;
			}
			if(num >= 5) count++;
			return;
		}
		for(int i=1; i<=5; i++) {
			if(idx >= 2) if(!check(idx, i)) continue;
			my[idx] = i;
			if(arr[idx] == my[idx]) dfs(idx + 1, cntAns + 1);
			else dfs(idx + 1, cntAns);
		}
	}
	
	public static boolean check(int idx, int num) {
		int cnt = 0;
		for(int i=idx; i>=idx-2; i--) {
			if(my[i] == num) cnt++;
			else cnt = 0;
			if(cnt == 2) {
				return false;
			}
		}
		return true;
	}
	
}
