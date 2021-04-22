import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, C, ans;
    static int map[][];
    static int[] harvestA, harvestB;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int tc= 1; tc<=T; tc++) {
            ans = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            harvestA = new int[M];	harvestB = new int[M];
            for(int i=0; i<N; i++) {
            	st = new StringTokenizer(br.readLine());
            	for(int j=0; j<N; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }
            
            for(int a=0; a<N; a++) { // y
            	for(int b=0; b<=N-M; b++) { // x 
            		for(int c=0; c<N; c++) {
            			for(int d=0; d<=N-M; d++) {
                        	if(a==c && b==d) continue;
                        	if(a==c && Math.abs(b-d) < M) continue;
                        	for(int i=0; i<M; i++) {
                        		harvestA[i] = map[a][b+i];
                        		harvestB[i] = map[c][d+i];
                        	}
                        	dfsA(0, 0, 0);
                        }
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
    
    private static void dfsA(int idx, int sum, int pow) {
    	if(sum > C) return;
    	if(idx == M) {
    		dfsB(0, pow, 0, 0);
    		return;
    	}
    	dfsA(idx+1, sum + harvestA[idx] , pow+(harvestA[idx]*harvestA[idx]));
    	dfsA(idx+1, sum, pow);
	}
    private static void dfsB(int idx, int sumA, int sumB, int pow) {
    	if(sumB > C) return;
    	if(idx == M) {
    		ans = Math.max(ans, sumA+pow);
    		return;
    	}
    	dfsB(idx+1, sumA, sumB + harvestB[idx], pow+(harvestB[idx]*harvestB[idx]));
    	dfsB(idx+1, sumA, sumB, pow);
    }

}
