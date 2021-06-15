import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        arr = new int[n][4];
        boolean[] check = new boolean[n];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[i][0] = Integer.parseInt(st.nextToken());
        	arr[i][1] = Integer.parseInt(st.nextToken());
        	arr[i][2] = Integer.parseInt(st.nextToken());
        	arr[i][3] = Integer.parseInt(st.nextToken());
        }
        int[] point = new int[] {3,1};
        int cnt = 0;
        int idx = -1;
        while(true) {
        	if(point[0] > 11) break;
        	boolean isUpdate = false;
        	for(int i=0; i<n; i++) {
        		if(point[0] < arr[i][0]) continue;
        		if(point[0] == arr[i][0] && point[1] < arr[i][1]) continue;
        		if(check[i]) continue;
        		check[i] = true;
    			isUpdate = true;
    			if(idx == -1) idx = i;
    			else {
    				if(arr[idx][2] <= arr[i][2]) {
    					if(arr[idx][2] == arr[i][2]) {
    						if(arr[idx][3] < arr[i][3]) idx = i;
    					}
    					else idx = i;
    				}
    			}
        			
        	}
        	if(isUpdate) {
        		point[0] = arr[idx][2];
        		point[1] = arr[idx][3];
        		cnt++;
        	}
        	else {
        		System.out.println(0);
        		System.exit(0);
        		break;
        	}
        }
        System.out.println(cnt);
        
    }
}
