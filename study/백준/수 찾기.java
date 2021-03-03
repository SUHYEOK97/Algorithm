package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Arrays.sort(arr);
		for(int i=0; i<m; i++) {
			find(Integer.parseInt(st.nextToken()));
		}
	}
	private static void find(int num) {
		int start = 0;
		int end = n-1;
		while(start <= end) {
			int mid = (start+end)/2;
			if(arr[mid] < num) start = mid+1;
			else if(arr[mid] > num) end = mid-1;
			else {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}
}
