import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Integer> arr1, arr2;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr1 = new ArrayList<>();
        arr2 = new ArrayList<>();
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	if(num < 0) arr1.add(Math.abs(num));
        	else arr2.add(num);
        	max = Math.max(max, Math.abs(num));
        }
        Collections.sort(arr1, Collections.reverseOrder());
        Collections.sort(arr2, Collections.reverseOrder());
        int sum = 0;
        for(int i=0; i<arr1.size(); i+=m) sum += (arr1.get(i)*2);
        for(int i=0; i<arr2.size(); i+=m) sum += (arr2.get(i)*2);
        System.out.println(sum-max);
    }
}
