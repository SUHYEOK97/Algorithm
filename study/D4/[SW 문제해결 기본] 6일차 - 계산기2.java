import java.util.Scanner;
import java.util.Stack;

public class 계산기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int n = sc.nextInt();
			char[] str = sc.next().toCharArray();
			for(int i=0; i<n-1; i++) {
				if(str[i] == '/' || str[i] == '*') {
					swap(str, i);
					i++;
				}
			}
			for(int i=0; i<n-1; i++) {
				if(str[i] == '+' || str[i] == '-') {
					swap(str, i);
				}
			}
			Stack<Integer> s = new Stack<>();
			for(int i=0; i<n; i++) {
				int ans = 0;
				if(str[i]=='+') {
					s.push(s.pop() + s.pop());
				}
				else if(str[i]=='-') {
					s.push(s.pop() - s.pop());
				}
				else if(str[i]=='/') {
					int first = s.pop();
					int second = s.pop();
					ans = (second / first);
					s.push(ans);
				}
				else if(str[i]=='*') {
					int first = s.pop();
					int second = s.pop();
					ans += (second * first);
					s.push(ans);
				}
				else s.push(Integer.parseInt(str[i]+""));
			}
			System.out.println("#"+tc+" "+s.peek());
		}
	}
	public static void swap(char[] str, int i) {
		char tmp = str[i];
		str[i] = str[i+1];
		str[i+1] = tmp;
	}
}
