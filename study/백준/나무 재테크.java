import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {-1,1,0,0,1,-1,1,-1};
	static int[] dx = {0,0,1,-1,1,-1,-1,1};
	static int[][] value, add;
	static int N,M,K,ans;
	
	static PriorityQueue<Tree> pq = new PriorityQueue<>();
	static class Tree implements Comparable<Tree>{
		int y,x,age;

		public Tree(int y, int x, int age) {
			this.y = y;
			this.x = x;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}

		@Override
		public String toString() {
			return "Tree [y=" + y + ", x=" + x + ", age=" + age + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		add = new int[N][N]; // 로봇이 추가하는 양분
		value = new int[N][N]; // 토지에 들어있는 양분
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) add[i][j] = Integer.parseInt(st.nextToken());
			Arrays.fill(value[i], 5);
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			pq.offer(new Tree(y, x, age));
		}
		simulation();
		
	}
	
	
	private static void simulation() {
		int year = 0;
		while(year++ < K) {
			if(pq.isEmpty()) break;
			ArrayList<Tree> live = new ArrayList<>();
			ArrayList<Tree> dead = new ArrayList<>();
			ArrayList<Tree> breeding = new ArrayList<>();
			int size = pq.size();
			for(int i=0; i<size; i++) { // 봄
				Tree tree = pq.poll();
				if(value[tree.y][tree.x] - tree.age >= 0) {
					value[tree.y][tree.x] -= tree.age;
					live.add(new Tree(tree.y, tree.x, tree.age + 1));
					if((tree.age+1) % 5 == 0) breeding.add(new Tree(tree.y, tree.x, tree.age+1));
				}
				else {
					dead.add(new Tree(tree.y, tree.x, tree.age));
				}
			}
			for(int i=0; i<dead.size(); i++) { // 여름
				value[dead.get(i).y][dead.get(i).x] += (dead.get(i).age / 2);
			}
			
			for(int i=0; i<breeding.size(); i++) { // 가을
				for(int j=0; j<8; j++) {
					int cy = breeding.get(i).y + dy[j];
					int cx = breeding.get(i).x + dx[j];
					if(cy < 0 || cx < 0 || cy == N || cx == N) continue;
					live.add(new Tree(cy, cx, 1));
				}
				
			}
			
			for(int i=0; i<N; i++) for(int j=0; j<N; j++) value[i][j] += add[i][j];
			for(int i=0; i<live.size(); i++) pq.add(live.get(i));
		}
		System.out.println(pq.size());
	}


	public static void printf() {
		System.out.println();
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(value[i]));
		}
	}
}
/*
5 2 6
2 3 2 3 2
2 3 2 3 2
2 3 2 3 2
2 3 2 3 2
2 3 2 3 2
2 1 3
3 2 3

output : 85
 */
