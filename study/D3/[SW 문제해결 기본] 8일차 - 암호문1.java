import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int n = sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i=0; i<n; i++) arr.add(sc.nextInt());
			
			int c = sc.nextInt();
			for(int i=0; i<c; i++) {
				String command = sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				for(int j=0; j<y; j++) {
					int s = sc.nextInt();
					arr.add(x+j, s);
				}
			}
			System.out.print("#"+tc+" ");
			for(int i=0; i<10; i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.println();
		}
	}
}
