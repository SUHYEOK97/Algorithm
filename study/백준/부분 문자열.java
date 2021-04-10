import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String parent = br.readLine();
		String pattern = br.readLine();
		System.out.println(kmp(parent, pattern));
	}
	static int[] fail(String pattern) {
		int[] f = new int[pattern.length()];
		int j=0;
		for(int i=1;i<pattern.length();i++) {
			
			while(j>0 && pattern.charAt(i)!=pattern.charAt(j)) j=f[j-1];
			
			if(pattern.charAt(i)==pattern.charAt(j)) f[i]=++j;
		}
		return f;
	}
	static int kmp(String parent, String pattern) {
		int f[] = fail(pattern);
		int j=0;
		
		for(int i=0;i<parent.length();i++) {
			
			while(j>0 && parent.charAt(i)!=pattern.charAt(j)) j = f[j-1];
			
			if(parent.charAt(i)==pattern.charAt(j)) {
				if(j==pattern.length()-1) {
					j=f[j];
					return 1;
				}
				else j++;
			}
		}
		return 0;
	}
}
