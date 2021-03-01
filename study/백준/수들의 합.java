import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long num = n;
		for(int i=1; i<=n; i++) {
			num -= i;
			if(i >= num) {
				System.out.println(i);
				break;
			}
		}
	}
}
