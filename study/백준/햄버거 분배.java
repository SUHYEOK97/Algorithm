import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;
	static char[] arr;
	static int count;
	static boolean check[];
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		arr = str.toCharArray();
		check = new boolean[n];
		for(int i=0; i<n; i++) {
			for(int j=1; j<=k; j++) {
				if(!check[i] && i-j >= 0 && !check[i-j] && arr[i] != arr[i-j]) {
					check[i] = true; 	check[i-j] = true;
					count++;
					break;
				}
				if(!check[i] && i+j < n && !check[i+j] && arr[i] != arr[i+j]) {
					check[i] = true; 	check[i+j] = true;
					count++;
					break;
				}
			}
		}
		System.out.println(count);
		
	}
	
}
