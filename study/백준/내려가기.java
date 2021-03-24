import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] dpMax, dpMin;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dpMax = new int[2][3];
		dpMin = new int[2][3];
		
		int ans1=0, ans2=9999999;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				dpMax[1][j] = Integer.parseInt(st.nextToken());
				dpMin[1][j] = dpMax[1][j];
			}
			
			int aMax = Math.max(dpMax[1][0] + dpMax[0][0], dpMax[1][0] + dpMax[0][1]);
			int bMax = Math.max(dpMax[1][1] + dpMax[0][0], dpMax[1][1] + dpMax[0][1]);
			bMax = Math.max(bMax, dpMax[1][1] + dpMax[0][2]);
			int cMax = Math.max(dpMax[1][2] + dpMax[0][1], dpMax[1][2] + dpMax[0][2]);
			
			int aMin = Math.min(dpMin[1][0] + dpMin[0][0], dpMin[1][0] + dpMin[0][1]);
			int bMin = Math.min(dpMin[1][1] + dpMin[0][0], dpMin[1][1] + dpMin[0][1]);
			bMin = Math.min(bMin, dpMin[1][1] + dpMin[0][2]);
			int cMin = Math.min(dpMin[1][2] + dpMin[0][1], dpMin[1][2] + dpMin[0][2]);
			
			dpMax[0][0] = aMax;		dpMin[0][0] = aMin;
			dpMax[0][1] = bMax;		dpMin[0][1] = bMin;
			dpMax[0][2] = cMax;		dpMin[0][2] = cMin;
		}
		for(int i=0; i<3; i++) {
			if(dpMin[0][i] < ans2) ans2 = dpMin[0][i];
			if(dpMax[0][i] > ans1) ans1 = dpMax[0][i];
		}
		System.out.println(ans1 + " " + ans2);
	}
}
