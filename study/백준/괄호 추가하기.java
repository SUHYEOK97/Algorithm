import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, ans = Integer.MIN_VALUE;
	static String[] str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		str = new String[n];
		for(int i=0; i<n; i++) str[i] = s.charAt(i)+"";
		dfs(1, str);
		System.out.println(ans);
	}
	private static void dfs(int idx, String[] s) {
		if(idx >= n-1) {
			cal(s);
			return;
		}
		// 괄호를 추가하지 않는 경우
		dfs(idx + 2, s);
		
		// 괄호를 추가하는 경우
		String a = s[idx];
		s[idx] = a+")";
		dfs(idx + 4, s);
		s[idx] = a;
		
	}
	private static void cal(String[] s) {
		ArrayList<String> sb = new ArrayList<>();
		for(int i=0; i<n; i++) {
			if(s[i].contains(")")) {
				int num1 = Integer.parseInt(s[i-1]);
				int num2 = Integer.parseInt(s[i+1]);
				int res = 0;
				if(s[i].contains("+")) res = num1+num2;
				if(s[i].contains("-")) res = num1-num2;
				if(s[i].contains("*")) res = num1*num2;
				sb.set(sb.size()-1, res+"");
				i++;
			}
			else {
				sb.add(s[i]);
			}
		}
		int num = Integer.parseInt(sb.get(0));
		for(int i=1; i<sb.size(); i+=2) {
			if(sb.get(i).equals("+")) num += Integer.parseInt(sb.get(i+1));
			if(sb.get(i).equals("-")) num -= Integer.parseInt(sb.get(i+1));
			if(sb.get(i).equals("*")) num *= Integer.parseInt(sb.get(i+1));
		}
		ans = Math.max(num, ans);
	}

}
