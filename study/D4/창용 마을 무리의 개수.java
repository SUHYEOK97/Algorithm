import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int check[];
	static int arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int n = sc.nextInt();
			check = new int[n];
			arr = new int[n];
			
			for (int i = 0; i < n; i++) {
				check[i] = i;
				arr[i] = 1;
			}
			
			int m = sc.nextInt();
			for (int i = 0; i < m; i++) {
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				union(a, b);
			}
			System.out.println(Arrays.toString(check));
			System.out.println(Arrays.toString(arr));
			int cnt = 0;
			System.out.print(getRelation(0) + " ");
			for (int i = 1; i < n; i++) {
				System.out.print(getRelation(i) + " ");
				if (getRelation(0) == getRelation(i)) {
					cnt++;
				}
			}
		}
//		System.out.println(cnt);
	}

	public static int getRelation(int i) {
		if (check[i] == i)
			return i;
		return check[i] = getRelation(check[i]);
	}

	public static void union(int a, int b) {
		int rootA = getRelation(a);
		int rootB = getRelation(b);

		if (rootA == rootB)
			return;

		if (arr[rootA] < arr[rootB]) {
			int temp = rootA;
			rootA = rootB;
			rootB = temp;
		}
		check[rootB] = rootA;

		if (arr[rootA] == arr[rootB]) {
			arr[rootA]++;
		}
	}

}
