import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> c = new Stack<>();
		
		for(int tc=1; tc<=10; tc++) {
			int n = sc.nextInt();
			String str = sc.next();
			int ans = 1;
			for(int i=0; i<n; i++) {
				if(str.charAt(i)==')' || str.charAt(i)==']' || str.charAt(i)=='>' || str.charAt(i)=='}') {
					char C = c.pop();
					if(C=='(' && str.charAt(i) != ')') {
						ans = 0;
						break;
					}
					if(C=='[' && str.charAt(i) != ']') {
						ans = 0;
						break;
					}
					if(C=='{' && str.charAt(i) != '}') {
						ans = 0;
						break;
					}
					if(C=='<' && str.charAt(i) != '>') {
						ans = 0;
						break;
					}
				}
				else c.push(str.charAt(i));
			}
			
			System.out.println("#"+tc+" "+ans);
			
			
		}
		
		
	}

}
