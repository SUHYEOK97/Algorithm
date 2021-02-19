import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class sdoku {
	static int[][] arr;
	static int ans;
	static int s;
	static int num;
	static int flag = 1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9][9];
		for(int i=0; i<9; i++) {
			String str = br.readLine();
			for(int j=0; j<9; j++) arr[i][j] = Integer.parseInt(str.charAt(j)+"");
		}
		dfs(0);
	}
	
	public static void dfs(int idx) {
		if(idx == 81) {
			printf();
			System.exit(0);
			return;
		}
		int y = idx / 9;
		int x = idx % 9;
		
		if(arr[y][x] == 0) {
			for(int i=1; i<=9; i++) {
				if(checking(y, x, i)) {
					arr[y][x] = i;
					dfs(idx + 1);
					arr[y][x] = 0;
				}
			}
		}
		else dfs(idx + 1);
	}
	
	public static boolean checking(int cY, int cX, int number) {
		for(int i=0; i<9; i++) {
			if(i != cX && number == arr[cY][i]) return false;
			if(i != cY && number == arr[i][cX]) return false;
		}
		for(int i= (cY/3)*3; i < (cY/3 + 1)*3; i++) {
			for(int j = (cX/3)*3; j < (cX/3 + 1)*3; j++) {
				if((i != cY && j != cX) && arr[i][j] == number) return false;
			}
		}
		return true;
	}
	
	public static void printf() {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(arr[i][j]);
			}System.out.println();
		}
	}
}
