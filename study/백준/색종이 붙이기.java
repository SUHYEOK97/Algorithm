import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int ans = 9999;
	static int[] paper = new int[5];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[10][10];
		for(int i=0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		find(0);
		System.out.println(ans == 9999 ? -1 : ans);
	}

	private static void find(int cnt) {
		
		int y = -1;
		int x = -1;
		out : for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(arr[i][j] == 1) {
					y = i;	x = j;
					break out;
				}
			}
		}
		if(y == -1 && x == -1) {
			ans = Math.min(ans, cnt);
			return;
		}
		int size = square(y, x); // 현재 위치에서 가장 많이 덮을 수 있는 개수
		
		for(int rect=size; rect>0; rect--) {
			if(paper[rect-1] == 5) continue;
			for(int i=y; i<y+rect; i++) {
				for(int j=x; j<x+rect; j++) {
					arr[i][j] = 0;
				}
			}
			paper[rect-1]++;
			find(cnt + 1);
			for(int i=y; i<y+rect; i++) {
				for(int j=x; j<x+rect; j++) {
					arr[i][j] = 1;
				}
			}
			paper[rect-1]--;
		}
		
	}
	
	private static int square(int r, int c) {
		int cnt = 5;
		while(cnt > 0) {
			int flag = 1;
			if(r+cnt > 10 || c+cnt > 10) {
				cnt--;
				continue;
			}
			out : for(int i=r; i<r+cnt; i++) {
				for(int j=c; j<c+cnt; j++) {
					if(arr[i][j] == 0) {
						flag = -1;
						break out;
					}
				}
			}
			if(flag == 1) break;
			cnt--;
		}
		
		return cnt;
	}
	
}
