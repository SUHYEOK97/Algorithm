import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String number = "";
		for(int i=0; i<4; i++) number += Integer.parseInt(st.nextToken());
		int n = findClock(Integer.parseInt(number));
		int ans = 0;
		for(int i=1111; i<=n; i++) {
			String str = i + "";
			if(str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0' || str.charAt(3) == '0') continue;
			if(findClock(i) == i) ans++;
		}
		System.out.println(ans);
	}
	public static int findClock(int num) {
		String str = num+"";
		int min = 9999;
		for(int i=0; i<4; i++) {
			String tmp = str.charAt(i)+"";
			int idx = i+1;
			for(int j=0; j<3; j++) {
				if(idx == 4) idx = 0;
				tmp += str.charAt(idx++);
			}
			min = Math.min(min, Integer.parseInt(tmp));
		}
		return min;
	}
}
