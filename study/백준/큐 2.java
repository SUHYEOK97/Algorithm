import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		int lastNum = 0;
		for(int i=1; i<=num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(st.countTokens() > 1) {
				st.nextToken();
				int input = Integer.parseInt(st.nextToken());
				lastNum = input;
				q.offer(input);
			}
			else {
				switch(st.nextToken()) {
				case "front" :
					sb.append((q.isEmpty() ? -1 :q.peek()) + "\n");
					break;
				case "back" :
					sb.append((q.isEmpty() ? -1 : lastNum) + "\n");
					break;
				case "size" :
					sb.append((q.size()) + "\n");
					break;
				case "empty" :
					sb.append((q.isEmpty() ? 1 : 0) + "\n");
					break;
				case "pop" :
					sb.append((q.isEmpty() ? -1 : q.poll()) + "\n");
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}
}
