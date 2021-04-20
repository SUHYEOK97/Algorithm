import java.io.*;
import java.util.*;

public class Main {
	static int n, T;
	static int[] arr, dp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		arr = new int[T+1];	dp = new int[T+1];
		for(int i=1; i<=T; i++) arr[i] = Integer.parseInt(br.readLine());
		
		for (int i=1; i<=T; i++){
			dp[i] = 1;
		    for (int j=1; j<i; j++){
		        if(arr[j] < arr[i]){
		            dp[i] = Math.max(dp[i], dp[j] + 1);
		        }        
		    }
		}
		System.out.println(T - Arrays.stream(dp).max().getAsInt());
	}
	
}
