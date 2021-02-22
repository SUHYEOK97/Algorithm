import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;
	static int arr[][] = new int[101][101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // n줄
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			for(int y=a; y<a+c; y++){
				for(int x=b; x<b+d; x++) {
					arr[y][x] = i;
				}
			}
		}
		for(int idx=1; idx<=n; idx++) {
			int ans = 0;
			for(int i=0; i<101; i++) {
				for(int j=0; j<101; j++) {
					if(idx == arr[i][j]) ans++;
				}
			}
			System.out.println(ans);
		}
		
	}
}
