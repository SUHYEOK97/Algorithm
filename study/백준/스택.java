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
		Stack<Integer> s = new Stack<>();
		for(int i=1; i<=num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(st.countTokens() > 1) {
				st.nextToken();
				int input = Integer.parseInt(st.nextToken());
				s.push(input);
			}
			else {
				switch(st.nextToken()) {
				case "top" :
					sb.append((s.isEmpty() ? -1 : s.peek()) + "\n");
					break;
				case "size" :
					sb.append((s.size()) + "\n");
					break;
				case "empty" :
					sb.append((s.isEmpty() ? 1 : 0) + "\n");
					break;
				case "pop" :
					sb.append((s.isEmpty() ? -1 : s.pop()) + "\n");
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}
}
