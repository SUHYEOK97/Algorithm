import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][];
		for(int i=0; i<n; i++) {
			arr[i] = new int[i+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=n-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				int max = Math.max(arr[i][j], arr[i][j+1]);
				arr[i-1][j] += max;
			}
		}
		System.out.println(arr[0][0]);
	}
	
}
