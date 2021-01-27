import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		char[] c = {'a','e','i','o','u'};
		for(int tc=1; tc<=T; tc++) {
			String str = sc.next();
			for(int i=0; i<5; i++) str = str.replaceAll(c[i]+"", "");
			System.out.println("#"+tc+" "+str);
		}
	}
}
