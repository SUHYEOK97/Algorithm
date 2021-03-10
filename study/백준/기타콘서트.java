import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int ans = 9999;
	static String[] name;
	static long[] bit;
	static long ansBit;
	static long max = 1;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		name = new String[n];
		bit = new long[n];
		check = new boolean[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			name[i] = st.nextToken();
			String str = st.nextToken();
			long mkBit = 0;
			for(int j=0; j<m; j++) {
				if(str.charAt(j) == 'Y') {
					mkBit = mkBit << 1;
					mkBit = mkBit | 1;
				}
				else {
					mkBit = mkBit << 1;
				}
			}
			bit[i] = mkBit;
		}
		recur(0, 0, 0);
		System.out.println(ans == 9999 ? "-1" : ans);
	}
	private static void recur(int idx, int start, long recurBit) {
		long bitCnt = bitCheck(recurBit);
		if(max <= bitCnt) {
			int cnt = 0;
			for(int i=0; i<n; i++) {
				if(check[i]) cnt++;
			}
			if(max == bitCnt) ans = Math.min(ans, cnt);
			else ans = cnt;
			max = bitCnt;
		}
		if(idx == n) {
			return;
		}
		for(int i=start; i<n; i++) {
			if(check[i]) continue;
			check[i] = true;
			recur(idx + 1, i + 1, (recurBit | bit[idx]));
			check[i] = false;
			recur(idx + 1, i + 1, recurBit);
		}
	}
	private static int bitCheck(long recurBit) {
		int cnt = 0;
		String str = Long.toBinaryString(recurBit);
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='1') cnt++;
		}
		return cnt;
	}
}진짜개줮같은문제다씨발ㅈ
