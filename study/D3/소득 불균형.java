import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			float avg = 0;
			for(int i=0; i<N; i++) {
				int num = sc.nextInt();
				avg += num;
				arr[i] = num;
			}
			avg /= N;
			int ans = 0;
			for(int i=0; i<N; i++) {
				if(avg >= arr[i]) ans++;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
