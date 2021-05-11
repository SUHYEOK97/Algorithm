import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long ans = Long.parseLong(st.nextToken());
		int cnt = 1;
		
		while(ans != n) {
			if(ans % 10 == 1 && ans >= 10) ans = Long.parseLong(new StringBuilder(ans+"").deleteCharAt((ans+"").length()-1).toString());
			else if(ans % 2 == 0) ans /= 2;
			else break;
			cnt++;
			if(ans == n) {
				System.out.println(cnt);
				return;
			}
		}
		System.out.println(-1);
	}
	
}
