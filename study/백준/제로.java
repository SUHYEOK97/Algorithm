import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		for(int i=1; i<=num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken()); 
			if(number==0) s.pop();
			else s.push(number);
		}
		int ans = 0;
		while(!s.isEmpty()) ans += s.pop();
		System.out.println(ans);
	}
}
