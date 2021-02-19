import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char[] crr;
	static int n;
	static int m;
	static StringBuilder str = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());		
		m = Integer.parseInt(st.nextToken());
		crr = new char[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) crr[i] = st.nextToken().charAt(0);
		Arrays.sort(crr);
		dfs(0, 0);
		
	}
	private static void dfs(int idx, int start) {
		if(idx == n) {
			int mo = 0;	int ja = 0;
			for(int i=0; i<n; i++) {
				char c = str.charAt(i);
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') mo++;
				else ja++;
			}
			if(mo == 0 || ja < 2) return;
			System.out.println(str);
			return;
		}
		for(int i=start; i<m; i++) {
			str.append(crr[i]);
			dfs(idx+1, i + 1);
			str.deleteCharAt(str.length()-1);
		}
	}
	
}
