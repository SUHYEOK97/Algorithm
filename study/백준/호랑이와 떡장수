import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, pre;
	static StringBuilder sb = new StringBuilder();
	static boolean[][] check;
	static ArrayList<Integer>[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new ArrayList[n];
		check = new boolean[n][10];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			arr[i] = new ArrayList<>();
			for(int j=0; j<len; j++) arr[i].add(Integer.parseInt(st.nextToken()));
		}
		dfs(0, 0);
		System.out.println("-1");
	}

    public static void dfs(int idx, int pre) {
        if(idx == n) {
            System.out.println(sb);
            System.exit(0);
        }
        for(int i=0; i<arr[idx].size(); i++) {
        	int num = arr[idx].get(i);
        	if(num == pre) continue;
        	if(check[idx][num]) continue;
        	check[idx][num] = true;
        	sb.append(num).append("\n");
        	dfs(idx+1, num);
        	sb.deleteCharAt(sb.lastIndexOf("\n"));
        	sb.deleteCharAt(sb.lastIndexOf(num+""));
        }
        
    }
}
