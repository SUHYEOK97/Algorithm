import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] arr;
    static PriorityQueue<Number> pq = new PriorityQueue<>();
    static class Number implements Comparable<Number>{
    	int num;
    	public Number(int n) {
    		this.num = n;
    	}
		@Override
		public int compareTo(Number o) {
			return this.num - o.num;
		}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++) pq.offer(new Number(Integer.parseInt(br.readLine())));
        int sum = 0;
        while(pq.size() > 1) {
        	int first = pq.poll().num;
        	int second = pq.poll().num;
        	sum += first+second;
        	pq.offer(new Number(first+second));
        }
        System.out.println(sum);
    }
}
