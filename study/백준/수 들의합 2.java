import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int[] aArr = new int[a];
		
		int res = 0;
		
		int l = 0;
		int r = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<a; i++) aArr[i] = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		while(l < a) {
			if (sum >= b | r == a) sum -= aArr[l++];
			else sum += aArr[r++];
			
			if(sum == b) res++;
		} 
	
		System.out.println(res);
	}
}
