import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int n;
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			n = sc.nextInt();
			count = sc.nextInt();
			count /= 45;
			int rotation = Math.abs(count);
			arr = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for(int i=0; i<rotation; i++) {
				if(count < 0) rotateMinus(n/2 - 1,n/2 + 2,n/2 + 2, 1);
				else if (count > 0) rotatePlus(n/2 - 1,n/2 + 2,n/2 + 2, 1);
			}
			printf();
		}
	}
	
	public static void rotatePlus(int start, int endCol, int endRow, int n) {
		if(start < 0) return;
		int num = arr[start][start];
		int preNum = arr[start][start];
		for(int i=start; i<endCol; i += n) {
			preNum = arr[start][i];
			arr[start][i] = num;
			num = preNum;
		}
		
		for(int i=start+n; i<endRow; i += n) {
			preNum = arr[i][endCol-1];
			arr[i][endCol-1] = num;
			num = preNum;
		}
		
		for(int i=endCol-(1+n); i>=start; i -= n) {
			preNum = arr[endRow-1][i];
			arr[endRow-1][i] = num;
			num = preNum;
		}
		
		for(int i=endRow-(1+n); i>=start; i -= n) {
			preNum = arr[i][start];
			arr[i][start] = num;
			num = preNum;
		}
		rotatePlus(start-1, endCol+1, endRow+1, n+1);
	}
	
	public static void rotateMinus(int start, int endCol, int endRow, int n) {
		if(start < 0) return;
		int num = arr[start][start];
		int preNum = arr[start][start];
		for(int i=start; i<endCol; i += n) {
			preNum = arr[i][start];
			arr[i][start] = num;
			num = preNum;
		}
		
		for(int i=start+n; i<endRow; i += n) {
			preNum = arr[endCol-1][i];
			arr[endCol-1][i] = num;
			num = preNum;
		}
		
		for(int i=endCol-(1+n); i>=start; i -= n) {
			preNum = arr[i][endRow-1];
			arr[i][endRow-1] = num;
			num = preNum;
		}
		
		for(int i=endRow-(1+n); i>=start; i -= n) {
			preNum = arr[start][i];
			arr[start][i] = num;
			num = preNum;
		}
		rotateMinus(start-1, endCol+1, endRow+1, n+1);
	}
	
	public static void printf() {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
	}
}
