import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String[] minus = str.split("-");
		String[] first = minus[0].split("\\+");
		int ans = 0;
		for(int i=0; i<first.length; i++) ans += Integer.parseInt(first[i]);
		for(int i=1; i<minus.length; i++) {
			String[] plus = minus[i].split("\\+");
			int p = 0;
			for(int j=0; j<plus.length; j++) p += Integer.parseInt(plus[j]);
			ans -= p;
		}
		System.out.println(ans);
	}
}
