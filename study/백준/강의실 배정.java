import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static ArrayList<Edge> list = new ArrayList<>();
	static class Edge implements Comparable<Edge>{
		int start,end;
		public Edge(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Edge o) {
			if(this.start == o.start) return this.end - o.end;
			return this.start - o.start;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Edge(start, end));
		}
		Collections.sort(list);
		for(int i=0; i<N; i++) {
			int start = list.get(i).start;
			int end = list.get(i).end;
			if(pq.isEmpty()) pq.offer(end);
			else {
				if(pq.peek() <= start) pq.poll();
				pq.offer(end);
			}
		}
		System.out.println(pq.size());
	}
}
