import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[] root;
	static int n, m;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			root = new int[n];
			for(int i=0; i<n; i++) root[i] = i;
			sb.append("#" + tc + " ");
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int cal = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				if(cal == 0) {
					union(a, b);
				}
				else if(cal == 1) {
					if(getParent(a) == getParent(b)) sb.append("1");
					else sb.append("0");
				}
			}
			sb.append("\n");
			
			System.out.println(Arrays.toString(root));
		}
		System.out.println(sb);
	}
	
	private static int getParent(int idx) {
		if(root[idx] == idx) return idx;
		root[idx] = getParent(root[idx]);
		return root[idx];
	}
	private static void union(int a, int b) {
		int rootA = getParent(a); // 0
		int rootB = getParent(b); // 2
		if(rootA == rootB) return;
		// 합치는 부분
		if(rootA < rootB) root[rootB] = rootA;
		else root[rootA] = rootB;
	}
	
}
