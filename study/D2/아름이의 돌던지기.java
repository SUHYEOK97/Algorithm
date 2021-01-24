import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Math.abs(sc.nextInt());
			}
			Arrays.sort(arr);
			int n = 0;
			for(int i=0; i<N; i++) if(arr[0]==arr[i]) n++;
			System.out.print("#"+tc+" " + arr[0] + " " + n + "\n");
		}
	}
}
