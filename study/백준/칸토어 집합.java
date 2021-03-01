import java.util.Scanner;

public class Main {
	static int n;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			n = sc.nextInt();
			sb = new StringBuilder();
			for(int i=0; i<(int) Math.pow(3, n); i++) sb.append("-");
			int left = (int) Math.pow(3, n-1);
			int right = (int) (Math.pow(3, n-1) * 2);
			division(n, left, right);
			System.out.println(sb);
		}
	}
	public static void division(int idx, int left, int right) {
		if(idx == 0) return;
		for(int i=left; i<right; i++) sb.setCharAt(i, ' ');
		idx--;
		division(idx, left - (int) (Math.pow(3, idx-1)*2), left - (int)Math.pow(3, idx-1)); // left
		division(idx, right + (int) (Math.pow(3, idx-1)), right + (int)Math.pow(3, idx-1)*2); // right
 	}
	
}
