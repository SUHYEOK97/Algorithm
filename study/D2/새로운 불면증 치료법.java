import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			
			int cnt = 1;
			int idx = 0;
			
			int num = 0;
			String str = "";
			while(idx != 10) {
				idx = 0;
				num = N*cnt;
				String tmp = num+"";
				for(int i=0; i<tmp.length(); i++) {
					if(!str.contains(tmp.charAt(i)+"")) {
						str += tmp.charAt(i)+"";
					}
				}
				for(int i=0; i<10; i++) {
					if(str.contains(i+"")) idx++;
				}
				cnt++;
			}
			
			System.out.println("#"+tc+" "+ num);
		}
	}
}
