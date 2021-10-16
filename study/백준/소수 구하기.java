import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int[] primeNumbers = new int[e + 1];
		
		for(int i=2; i<=e; i++) {
			for(int j=2; j*i<=e; j++) primeNumbers[i*j] = -1;
		}
		for(int i=2; i<=e; i++) if(primeNumbers[i] != -1 && s<=i && i<=e) sb.append(i).append("\n");
		System.out.println(sb);
		
	}
}
