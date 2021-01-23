import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] arr = {11,7,5,3,2};
		for(int tc=1; tc<=T; tc++) {
			int[] arrCnt = new int[5];
			int N = sc.nextInt();
			
			for(int i=0; i<arr.length; i++) {
				while(N % arr[i] == 0) {
					N /= arr[i];
					arrCnt[i]++;
				}
			}
			
			System.out.print("#"+tc+" ");
			for(int i=4; i>=0; i--) System.out.print(arrCnt[i] + " ");
			System.out.println();
		}
	}
}
