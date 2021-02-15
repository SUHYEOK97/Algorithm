import java.util.Scanner;

public class tmp {
	static int n;
	static int arrS[];
	static int arrB[];
	static boolean check[];
	static int ans = 99999;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arrS = new int[n];
		arrB = new int[n];
		check = new boolean[n];
		
		for(int i=0; i<n; i++) {
			arrS[i] = sc.nextInt();
			arrB[i] = sc.nextInt();
		}
		recur(0, 0);
		System.out.println(ans);
	}
	static void recur(int idx, int start) {
		if(idx == n) {
			int cnt = 0;
			for(int i=0; i<n; i++) if(!check[i]) cnt++;
			if(cnt==n) return;
			
			int sumS = 1;
			int sumB = 0;
			for(int i=0; i<n; i++) {
				if(check[i]) {
					sumS *= arrS[i];
					sumB += arrB[i];
				}
			}
			ans = Math.min(ans, Math.abs(sumS - sumB));
			return;
		}
		for(int i=start; i<n; i++) {
			if(check[i]) continue;
			check[i] = true;
			recur(idx + 1, i + 1);
			check[i] = false;
			recur(idx + 1, i + 1);
			
		}
	}
}
