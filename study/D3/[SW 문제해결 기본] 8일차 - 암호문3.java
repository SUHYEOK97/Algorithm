import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i=0; i<N; i++) {
				int a = sc.nextInt();
				arr.add(a);
			}
			
			int command = sc.nextInt();
			for(int i=0; i<command; i++) {
				String c = sc.next();
				
				switch(c) {
				case "I" : {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for(int j=0; j<y; j++) {
						int addNum = sc.nextInt();
						arr.add(x+j, addNum);
					}
					break;
				}
				case "D" : {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for(int j=1; j<=y; j++) {
						arr.remove(x+j);
					}
					break;
				}
					
				case "A" : {
					int y = sc.nextInt();
					for(int j=0; j<y; j++) {
						int s = sc.nextInt();
						arr.add(s);
					}
					break;
				}
				}
				
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<10; i++) System.out.print(arr.get(i) + " ");
			System.out.println();
		}
	}
}
