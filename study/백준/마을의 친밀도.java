import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int arr[][] = new int[n][3];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
		int ans = 999999;
		for(int i=0; i<n; i++) {
			int idx = -1;
			int dir1 = 999999;
			int dir2 = 999999;
			for(int j=0; j<n; j++) {
				if(j != i) {
					int num = Math.abs(arr[i][0]-arr[j][0])+ Math.abs(arr[i][1]-arr[j][1]) + Math.abs(arr[i][2]-arr[j][2]);
					if(num < dir1) {
						idx = j;
						dir1 = num;
					}
				}
			}
			for(int j=0; j<n; j++) {
				if(j != i && j != idx) {
					int num = Math.abs(arr[i][0]-arr[j][0])+ Math.abs(arr[i][1]-arr[j][1]) + Math.abs(arr[i][2]-arr[j][2]);
					dir2 = Math.min(dir2, num);
				}
			}
			ans = Math.min(dir1+dir2, ans);
		}
		System.out.println(ans);
	}
}
