import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int num = sc.nextInt();
			int cnt = sc.nextInt();
			System.out.print("#"+tc+" ");
			System.out.print(recursion(num, cnt)+"\n");
		}
	}
	
	public static int recursion(int num, int cnt) {
		if(cnt == 0) return 1;
		return num * recursion(num,cnt-1);
	}
}
