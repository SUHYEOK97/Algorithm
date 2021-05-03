import java.io.*;
import java.util.*;

public class Main {
	static long[] fac;
	static long MOD = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		fac = new long[n+1];
		fac[0] = 1;
		for(int i=1; i<=n; i++) fac[i] = fac[i-1] * i % MOD;
		long b = fac[n-r] * fac[r] % MOD;
		long rb = fermat(b, MOD - 2);
		System.out.println(rb * fac[n] % MOD);
	}
	public static long fermat(long n, long x) {
		if(x == 0) return 1;
		long tmp = fermat(n, x/2);
		long ret = tmp * tmp % MOD;
		if(x % 2 == 0) return ret % MOD;
		else return ret * n % MOD;
	}
}
