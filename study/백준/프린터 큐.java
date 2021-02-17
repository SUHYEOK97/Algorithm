import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			Queue<Integer> q = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> rank = new ArrayList<>();
			for(int i=0; i<n; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(!rank.contains(num)) rank.add(num);
				q.offer(num);
			}
			Collections.sort(rank, Collections.reverseOrder());
			int findIdx = 0;
			int findNum = rank.get(findIdx);
			
			int cnt = 0;
			while(!q.isEmpty()) {
				int num = q.poll();
				idx--;
				if(findNum == num) {
					cnt++;
					if(idx < 0) break;
					if(!q.contains(findNum) && findIdx < rank.size()) findNum = rank.get(++findIdx);
				}
				else {
					q.offer(num);
					if(idx < 0) idx += q.size();
				}
			}
			System.out.println(cnt);
		}
	}
}
