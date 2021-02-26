import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] point;
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<4; i++) {
			point = new int[8];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<8; j++) point[j] = Integer.parseInt(st.nextToken());
			
			int startX = Math.max(point[0], point[4]);
			int startY = Math.max(point[1], point[5]);
			if(startX <= point[2] && startX <= point[6]
					&& startY <= point[3] && startY <= point[7]) {
				int startXx = Math.min(point[2], point[6]);
				int startYy = Math.min(point[3], point[7]);
				int lenA = startXx - startX;
				int lenB = startYy - startY;
				if(lenA == 0 && lenB == 0) System.out.println("c");
				else if(lenA == 0 || lenB == 0) System.out.println("b");
				else System.out.println("a");
			}
			else System.out.println("d");
		}
	}
}
