import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static boolean check[];
	static int n;
	static int m;
	static int ans = Integer.MAX_VALUE;
	static ArrayList<int[]> point;
	static ArrayList<int[]> home;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		point = new ArrayList<>();
		home = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int num = sc.nextInt();
				if(num == 2) {
					int[] tmp = {i, j};
					point.add(tmp);
				}
				if(num == 1) {
					int[] tmp = {i, j};
					home.add(tmp);
				}
			}
		}
		check = new boolean[point.size()];
		recur(0, 0);
		System.out.println(ans);
	}
	
	public static void recur(int start, int idx) {
		if(idx == m) {
			int tmpAns = 0;
			
			for(int i=0; i<home.size(); i++) {
				int tmp = 999999;
				for(int j=0; j<point.size(); j++) {
					if(check[j]) {
						tmp = Math.min(tmp, (Math.abs(home.get(i)[0] - point.get(j)[0]) + Math.abs(home.get(i)[1] - point.get(j)[1])));
						
					}
				}
				tmpAns += tmp;
			}
			if(tmpAns == 0) return;
			ans = Math.min(tmpAns, ans);
			return;
		}
		for(int i=start; i<check.length; i++) {
			if(check[i]) continue;
			check[i] = true;
			recur(i + 1, idx+1);
			check[i] = false;
			recur(i + 1, idx+1);
		}
	}
	
}
