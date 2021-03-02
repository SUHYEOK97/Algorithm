import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int a;
	static int b;
	static String[] arrA;
	static String[] arrB;
	static ArrayList<String> ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken()); // 듣
		b = Integer.parseInt(st.nextToken()); // 보
		arrA = new String[a];
		arrB = new String[b];
		ans = new ArrayList<>();
		for(int i=0; i<a; i++) arrA[i] = br.readLine();
		for(int i=0; i<b; i++) arrB[i] = br.readLine();
		Arrays.sort(arrA);		Arrays.sort(arrB);
		for(int i=0; i<a; i++) {
			int idx = Arrays.binarySearch(arrB, arrA[i]);
			if(idx >= 0) ans.add(arrA[i]);
		}
		System.out.println(ans.size());
		for(int i=0; i<ans.size(); i++) System.out.println(ans.get(i));
	}
}
