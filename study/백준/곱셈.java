import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int A,B,C;
	static long arr[];
	static char[] bit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new long[65];
		arr[1] = A % C;
		for(int i=2; i<=64; i++) arr[i] = arr[i-1] * arr[i-1] % C;
		bit = Integer.toBinaryString(B).toCharArray();
		Queue<Long> q = new LinkedList<>();
		long answer = 0;
		for(int i=bit.length-1, n=1; i>=0; i--,n++) {
			if(bit[i]=='1') q.offer(arr[n] % C);
		}
		
		while(!q.isEmpty()) {
			long num = q.poll();
			if(answer==0) answer = num;
			else answer = answer * num % C;
		}
		System.out.println(answer);
		
	}
}
