import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			n = Integer.parseInt(br.readLine());
			
			int arr[][] = new int[n][2];
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			int cnt = 1;
			Arrays.sort(arr,(o1, o2) -> o1[0] - o2[0]);
			int num = arr[0][1];
			for(int i=1; i<n; i++) {
				if(num > arr[i][1]) {
					num = arr[i][1];
					cnt++;
				}
			}
			System.out.println(cnt);
		}
		
	}
}
