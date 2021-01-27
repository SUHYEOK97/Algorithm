import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0; i<arr.length; i++) arr[i] = sc.nextInt();
			
			int[] ans = new int[N-1];
			int up = 0;
			int down = 0;
			for(int i=0; i<N-1; i++) {
				int num = arr[i]-arr[i+1];
				if(num < 0 && up > num) up = num;
				if(num > 0 && down < num) down = Math.abs(num);
			}
			Arrays.sort(ans); //음수면 올라가는 것, 양수면 내려가는 것
			
			System.out.println("#"+tc+" "+Math.abs(up)+" "+down);
		}
	}
}
