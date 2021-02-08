import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스_문제 {
	static int n;
	static int k;
	static Queue<Integer> q = new LinkedList<Integer>();
	static Queue<Integer> ans = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++) q.offer(i+1);
		int cnt = 0;
		while(!q.isEmpty()) {
			int num = q.poll();
			cnt++;
			if(cnt == k) {
				ans.offer(num);
				cnt = 0;
			}
			else q.offer(num);
		}
		System.out.print("<");
		for(int i=0; i<n; i++) {
			if(i == n-1) System.out.print(ans.poll() + ">");
			else System.out.print(ans.poll() + ", ");
		}
	}
}
