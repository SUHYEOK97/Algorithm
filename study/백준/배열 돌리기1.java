import java.util.Scanner;

public class 배열_돌리기1 {
	static int[][] arr;
	static int m;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt(); // y
		n = sc.nextInt(); // x
		int rotation = sc.nextInt();
		arr = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<rotation; i++) rotate(0,m,n);
		printf();
		
	}
	public static void rotate(int start, int endCol, int endRow) {
		if(start == m/2 || start == n/2) return;
		int num = arr[start][start];
		int preNum = arr[start][start];
		for(int i=start; i<endCol; i++) {
			preNum = arr[i][start];
			arr[i][start] = num;
			num = preNum;
		}
		
		for(int i=start+1; i<endRow; i++) {
			preNum = arr[endCol-1][i];
			arr[endCol-1][i] = num;
			num = preNum;
		}
		
		for(int i=endCol-2; i>=start; i--) {
			preNum = arr[i][endRow-1];
			arr[i][endRow-1] = num;
			num = preNum;
		}
		
		for(int i=endRow-2; i>=start; i--) {
			preNum = arr[start][i];
			arr[start][i] = num;
			num = preNum;
		}
		rotate(start+1, endCol-1, endRow-1);
	}
	
	public static void printf() {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
	}
}
