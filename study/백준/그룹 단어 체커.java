import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int cnt = 0;
		
		for(int tc=1; tc<=T; tc++) {
			String str = sc.next();
			ArrayList<Character> c = new ArrayList<>();
			boolean ans = true;
			for(int i=0; i<str.length(); i++) 
				if(!c.contains(str.charAt(i))) c.add(str.charAt(i));
			
			out : for(int i=0; i<c.size(); i++) {
				ArrayList<Integer> arr = new ArrayList<>();
				for(int j=0; j<str.length(); j++) {
					if(str.charAt(j)==c.get(i)) arr.add(j);
				}
				int idx = arr.get(0);
				for(int j=0; j<arr.size(); j++) {
					if(!(idx == arr.get(j))) {
						ans = false;
						break out;
					}
					idx++;
				}
			}
			cnt = ans ? cnt+1 : cnt;
			
		}
		System.out.println(cnt);
	}
	
}
