import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            StringBuilder a = new StringBuilder(sc.next());
            int size = a.length();
            int cnt = 0;
            for(int j=0; j<size; j++) {
                if(a.charAt(j) == '1') {
                    for(int k=j; k<size; k++) {
                        if(a.charAt(k) == '1') a.setCharAt(k, '0');
                        else if(a.charAt(k) == '0') a.setCharAt(k, '1');
                    }
                    cnt++;
                }
            }
            System.out.println("#" + (i+1) + " " + cnt);
        }
         
    }
}
