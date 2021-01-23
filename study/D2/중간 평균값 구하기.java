package solution;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int[] arr = new int[10];
			for(int i=0; i<10; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			float result = 0;
			for(int i=1; i<9; i++) {
				result += arr[i];
			}
			result = (float) (result / 8.0);
			result = Math.round(result);
			System.out.println("#"+tc+" "+(int)result);
		}
	}
}
