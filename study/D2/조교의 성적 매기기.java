import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		String[] score = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt(); // 학생 수
			int K = sc.nextInt() - 1; // 학생 번호 
			Float[] students = new Float[N];
			float select = 0;
			int cnt = 1;
			for(int i=0; i<N; i++) {
				float midEx = sc.nextInt();
				float finalEx = sc.nextInt();
				float sook = sc.nextInt();
				students[i] = (float) ((midEx*0.35) + (finalEx*0.45) + (sook*0.2));
			}
			select = students[K];
			Arrays.sort(students, Collections.reverseOrder());
			
			for(int i=0; i<N; i++) {
				if(students[i] == select) {
					cnt = i;
					break;
				}
			}
			float re = (float)cnt/N * 10;
			re = (float) Math.floor(re);
			System.out.println("#"+tc+" "+score[(int)re]);
		}
	}
}
