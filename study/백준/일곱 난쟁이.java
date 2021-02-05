import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] h = new int[9];
	static int[] ans = new int[7];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) h[i] = Integer.parseInt(br.readLine());
		recur(0,0);
		System.out.println(sb);
	}
	
	public static void recur(int idx, int startIdx) {
		if(idx == 7) {
			int sum = 0;
			for(int i=0; i<7; i++) {
				sum += ans[i];
			}
			if(sum == 100) {
				Arrays.sort(ans);
				for(int i=0; i<7; i++) sb.append(ans[i] + "\n");
			}
			return;
		}
		
		for(int i=startIdx; i<9; i++) {
			ans[idx] = h[i];
			recur(idx+1, i+1);
		}
	}

}
