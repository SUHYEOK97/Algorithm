import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr = new int[26];
	static char[][] cArr;
	static String[] sr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cArr = new char[N][];
		int size = 0;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			size = Math.max(size, str.length());
			cArr[i] = str.toCharArray();
		}
		sr = new String[size];
		for(int i=0; i<size; i++) sr[i] = "";
		for(int i=0; i<N; i++) {
			int diff = size - cArr[i].length;
			for(int j=0; j<cArr[i].length; j++) {
				sr[diff + j] = sr[diff + j].concat(cArr[i][j]+"");
			}
		}
		for(int i=0; i<size; i++) {
			for(int j=0; j<sr[i].length(); j++) {
				arr[sr[i].charAt(j) - 'A'] += Math.pow(10, size-i-1);
			}
		}
		Arrays.sort(arr);
		int sum = 0;
		for(int i=25, num=9; i>=0; i--,num--) sum += (arr[i]*num);
		System.out.println(sum);
	}
}
