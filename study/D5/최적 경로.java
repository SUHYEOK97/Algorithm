import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
    static boolean[] check;
    static int[] arr;
    static int[] x;
    static int[] y;
    static int n;
    static int ans = Integer.MAX_VALUE;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt() + 2;
            x = new int[n];
            y = new int[n];
            arr = new int[n];
            check = new boolean[n];
            arr[0] = 0;
            arr[n - 1] = 1;
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }
            recur(1);
 
            System.out.println("#" + tc + " " + ans);
            ans = Integer.MAX_VALUE;
        }
    }
 
    private static void recur(int idx) {
        if (idx == n-1) { // 기저조건
            int distance = 0;
            for (int i = 1; i < n; i++) {
                distance += (Math.abs(x[arr[i - 1]] - x[arr[i]]) + Math.abs(y[arr[i - 1]] - y[arr[i]]));
            }
            ans = ans > distance ? distance : ans;
            return;
        }
        for (int i = 2; i < n; i++) {
            if (check[i]) continue;
            arr[idx] = i;
            check[i] = true;
            recur(idx + 1);
            check[i] = false;
        }
    }
}
