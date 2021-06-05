import java.io.*;
import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		int n1 = 0, n2 = 0;
		for(int i=N; i>0; i--) {
			int num1 = i, num2 = i;
			while(num1 % 2 == 0) {
				num1 /= 2;
				n1++;
			}
			while(num2 % 5 == 0) {
				num2 /= 5;
				n2++;
			}
		}
		System.out.println(Math.min(n1, n2));
	}
	
}
