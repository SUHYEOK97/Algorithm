package com.ssafy.algo;

import java.util.Scanner;

public class Solution22 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[][] pond = new int[N][N]; // 연못
			int ws = sc.nextInt(); // 소금쟁이
			int[] move = {3,2,1};
			int death = 0;
			
			loop : for(int i=0; i<ws; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				int dir = sc.nextInt();
				
				for(int j=0; j<move.length; j++) {
					if(pond[y][x] == -1) {
						death++;
						continue loop;
					}
					switch(dir) {  
					case 1: 
						y -= move[j];
						if(y < 0 || pond[y][x] == -1) {
							death++;
							continue loop;
						}
						if(pond[y][x] == 0 && j == move.length-1) pond[y][x] = -1;
						break;
					case 2: 
						y += move[j];
						if(y >= N || pond[y][x] == -1) {
							death++;
							continue loop;
						}
						if(pond[y][x] == 0 && j == move.length-1) pond[y][x] = -1;
						break;
					case 3: 
						x -= move[j];
						if(x < 0 || pond[y][x] == -1) {
							death++;
							continue loop;
						}
						if(pond[y][x] == 0 && j == move.length-1) pond[y][x] = -1;
						break;
					case 4: 
						x += move[j];
						if(x >= N || pond[y][x] == -1) {
							death++;
							continue loop;
						}
						if(pond[y][x] == 0 && j == move.length-1) pond[y][x] = -1;
						break;
					}
				}
				
			}
			System.out.println("#"+tc+" "+(ws-death));
			
		}
	}
}
