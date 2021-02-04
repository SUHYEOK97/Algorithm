import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		for(int i=1; i<=num; i++) {
			Stack<Character> s = new Stack<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken(); 
			
			int strSize = str.length();
			for(int j=0; j<strSize; j++) {
				if(!s.isEmpty() && str.charAt(j)==')') {
					if(s.peek() != '(') break;
					else s.pop();
				}
				else s.push(str.charAt(j));
			}
			sb.append((s.isEmpty() ? "YES" : "NO") + "\n");
		}
		System.out.println(sb);
	}
}
