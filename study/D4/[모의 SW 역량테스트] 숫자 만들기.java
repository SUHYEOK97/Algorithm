import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int number[];
	static int operator[];
	static int oCnt[];
	static int n;
	static int max, min=100000000;
	static int size;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			n = Integer.parseInt(br.readLine());
			number = new int[n];
			operator = new int[4];
			oCnt = new int[4];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				operator[i] = Integer.parseInt(st.nextToken());
			}
			max = -100000000;	min = 100000000;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) number[i] = Integer.parseInt(st.nextToken());
			dfs(1, number[0]);
			sb.append("#"+tc+" "+ (max-min)+"\n");
		}
		System.out.println(sb);
	}
	private static void dfs(int idx, int num) {
		if(idx == n) {
			max = Math.max(num, max);
			min = Math.min(num, min);
			return;
		}
		for(int i=0; i<4; i++) {
			if(oCnt[i] >= operator[i]) continue;
			oCnt[i]++;
			int a = num;
			if(i == 0) dfs(idx+1, num +=number[idx]);
			else if(i == 1) dfs(idx+1, num -=number[idx]);
			else if(i == 2) dfs(idx+1, num *=number[idx]);
			else if(i == 3) dfs(idx+1, num /=number[idx]);
			oCnt[i]--;
			num = a;
		}
	}
}
