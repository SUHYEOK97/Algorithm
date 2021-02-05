import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int ans = 0;
			for(int i=0; i<N; i++) arr[i] = sc.nextInt();
			for(int i=2; i<N-2; i++) {
				if(arr[i-2] < arr[i] && arr[i-1] < arr[i]) {
					if(arr[i+2] < arr[i] && arr[i+1] < arr[i]) {
						int min = 99999;
						min = arr[i] - arr[i-2] < min ? arr[i] - arr[i-2] : min;
						min = arr[i] - arr[i-1] < min ? arr[i] - arr[i-1] : min;
						min = arr[i] - arr[i+1] < min ? arr[i] - arr[i+1] : min;
						min = arr[i] - arr[i+2] < min ? arr[i] - arr[i+2] : min;
						ans += min;
					}
				}
			}
			System.out.println("#"+tc+" "+ ans);
		}
		
	}

}
