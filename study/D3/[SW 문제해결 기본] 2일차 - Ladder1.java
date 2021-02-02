import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int N = sc.nextInt();
			int x = 0;
			int y = 99;
			int[][] arr = new int[100][100];
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					arr[i][j] = sc.nextInt();
					if(arr[i][j] == 2) x = j;
				}
			}
			int move = -1; // -1 : 상, 0 : 좌,  1 : 우
			while(y > 0) {
				if(x > 0 && arr[y][x-1] == 1) {
					while(x > 0 && arr[y][x-1]==1) {
						x--;
					}
				}
				else {
					if(x < 99 && arr[y][x+1] == 1) {
						while(x < 99 && arr[y][x+1]==1) {
							if(x < 99) x++;
						}
					}
				}
				if(arr[y-1][x]==1) y--;
			}
			System.out.println("#"+tc+" "+x);
		}
		
	}

}
