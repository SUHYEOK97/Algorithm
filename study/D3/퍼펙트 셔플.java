import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int pivot = N / 2;
			String[] str1 = new String[N];
			String[] str2 = new String[N];
			for(int i=0; i<N; i++) {
				if(i >= pivot) {
					int idx = N % 2 == 0 ? N-i : N-i-1;
					if(N % 2 == 1) {
						str2[N-1] = sc.next();
					}
					for(int j=0; j< idx; j++) {
						str2[j] = sc.next();
					}
					break;
				}
				else str1[i] = sc.next();
			}
			ArrayList<String> ans = new ArrayList<>();
			for(int i=0; i<N; i++) {
				ans.add(str1[i]);
				ans.add(str2[i]);
			}
			if(N % 2 == 1) {
				ans.add(N-1,str2[N-1]);
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<N; i++) System.out.print(ans.get(i)+" ");
			System.out.println();
		}
		
	}

}
