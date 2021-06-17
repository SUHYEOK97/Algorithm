import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] scores, days;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        scores = new int[n];
        days = new int[n];
        int maxDay = 0;
        for(int i=0; i<n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int score = Integer.parseInt(st.nextToken());
        	int day = Integer.parseInt(st.nextToken());
        	days[i] = day;
        	scores[i] = score;
        	maxDay = Math.max(maxDay, day);
        }
        int sum = 0;
        for(int i=maxDay; i>0; i--) {
        	int maxIdx = -1;
        	int maxNum = -1;
        	for(int j=0; j<n; j++) {
        		if(days[j] < i) continue;
        		if(maxNum < scores[j]) {
        			maxNum = scores[j];
        			maxIdx = j;
        		}
        	}
        	if(maxIdx != -1) {
        		sum += scores[maxIdx];
        		days[maxIdx] = -1;
        		scores[maxIdx] = -1;
        	}
        }
        System.out.println(sum);
    }
}
