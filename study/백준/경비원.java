import java.io.*;
import java.util.*;

public class Main {
	static int m,n;
	static int n_store;
	static int[]stores;
	static int dir,len; //방향과 거리
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine());
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		n_store=Integer.parseInt(br.readLine());
		stores=new int[n_store];
		for (int i = 0; i < n_store; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			if(a==1) {
				stores[i]=b;
			}else if(a==2) {
				stores[i]=m+n+(m-b);
			}else if(a==3) {
				stores[i]=m+n+m+(n-b);
			}else {
				stores[i]=m+b;
			}
			
		}
		
		st=new StringTokenizer(br.readLine());
		dir=Integer.parseInt(st.nextToken());
		int x=Integer.parseInt(st.nextToken());
		if(dir==1) {
			len=x;
		}else if(dir==2) {
			len=m+n+(m-x);
		}else if(dir==3) {
			len=m+n+m+(n-x);
		}else {
			len=m+x;
		}
		calculate();

		System.out.println(sum);
		
	}
	
	
	private static void calculate() {
		for (int i = 0; i < n_store; i++) {
			int max=len>stores[i]?len:stores[i];
			int min=len<=stores[i]?len:stores[i];
			sum+=Math.min(max-min, 2*(m+n)-max+min);
		}
		
	}
	
	
}
