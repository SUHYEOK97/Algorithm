import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] crane, freight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        crane = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) crane[i] = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        freight = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) freight[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(crane);
        Arrays.sort(freight);
        if(crane[crane.length-1] < freight[freight.length - 1]) {
        	System.out.println(-1);
        	System.exit(0);
        }
        int ans = 1;
        int count = m;
        int i=n-1, j=m-1; 
        while(count != 0) {
        	if(j < 0 || i < 0) {
        		j = m-1;
        		i = n-1;
        		ans++;
        	}
        	if(freight[j] == -1) {
        		j--;
        		continue;
        	}
        	if(freight[j] <= crane[i]) {
        		count--;
        		freight[j] = -1;
        		i--;
        	}
        	j--;
        }
        System.out.println(ans);
    }

}
