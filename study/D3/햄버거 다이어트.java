import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static boolean check[];
	static int[] cal;
	static int[] score;
	static int maxScore = 0;
	static int N;
	static int L;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			cal = new int[N];
			score = new int[N];
			check = new boolean[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			recur(0);
			sb.append("#"+tc+" "+maxScore+"\n");
			maxScore = 0;
		}
		System.out.println(sb);
		
	}
	
	public static void recur(int idx) {
		
		if(idx == cal.length) {
			int calSum = 0;
			int scoreSum = 0;
			for(int i=0; i<idx; i++) {
				if(check[i]) {
					calSum += cal[i];
					scoreSum += score[i];
				}
			}
			if(calSum > L) return;
			if(scoreSum > maxScore) maxScore = scoreSum;
			return;
		}
		
		check[idx] = true;
		recur(idx+1);
		check[idx] = false;
		recur(idx+1);
	}
}
