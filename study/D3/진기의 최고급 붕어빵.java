package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class recursion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			
			boolean ans = true;
			
			int[] timeLine = new int[N];
			int time = 0;
			int boong = 0;
			int idx = 0;
			for(int i=0; i<N; i++) {
				timeLine[i] = sc.nextInt();
				time += timeLine[i];
			}
			Arrays.sort(timeLine);
			
			for(int i=0; i<=time; i++) {
				if(timeLine[0] == 0) ans = false;
				if(i>0 && i % m ==0) boong += k;
				
				if(timeLine[idx] == i) {
					if(boong == 0) {
						ans = false;
						break;
					}
					boong--;
					if(idx < N - 1) idx++;
				}
			}
			if(ans) System.out.println("#"+tc+" Possible");
			else System.out.println("#"+tc+" Impossible");
		}
	}
}
