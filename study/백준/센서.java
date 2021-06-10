import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] arr, dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        dis = new int[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        for(int i=1; i<n; i++) dis[i-1] = Math.abs(arr[i] - arr[i-1]);
        Arrays.sort(dis);
        int sum = 0;
        for(int i=0; i<n-k; i++) {
        	sum += dis[i];
        }
        System.out.println(sum);
        
    }

}
