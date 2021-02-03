import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i=0; i<N; i++) {
				int num = sc.nextInt();
				if(num==0) arr.remove(arr.size()-1);
				else arr.add(num);
			}
			int ans = 0;
			for(int i=0; i<arr.size(); i++) ans+=arr.get(i);
			System.out.println("#"+tc+" "+ans);
		}
		
	}

}
