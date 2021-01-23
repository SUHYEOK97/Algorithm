import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			System.out.print("#"+tc+" ");
			
			String ans = "";
			int count = 0;
			for(int i=0; i<N; i++) {
				String ch = sc.next();
				int cnt = sc.nextInt();
				for(int j=0; j<cnt; j++) {
					if(count % 10 == 0) ans+="\n";
					count++;
					ans+=ch;
				}
				
			}
			System.out.print(ans);
			System.out.println();
			
		}
	}
}
