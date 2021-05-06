import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(br.readLine());
		dfs(0);
	}
	private static void dfs(int idx) {
		if(checking()) return;
		if(idx == n) {
			System.out.println(sb.toString());
			System.exit(0);
			return;
		}
		for(int i=1; i<=3; i++) {
			sb.append(i);
			dfs(idx+1);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	private static boolean checking() {
		// 예외 : true
		int size = sb.length();
		for(int cnt=1; cnt<size; cnt++) {
			for(int i=0; i<size; i++){
				if(i+cnt+cnt > size) continue;
				if(sb.substring(i, i+cnt).equals(sb.substring(i+cnt, i+cnt+cnt))) return true;
			}
		}
		return false;
	}
}
