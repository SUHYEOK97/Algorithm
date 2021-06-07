import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num <= 0) arr2.add(num);
			else arr1.add(num);
		}
		Collections.sort(arr1);
		Collections.sort(arr2);
		int sum = 0;
		for(int i=arr1.size()-1; i>0; i-=2) {
			if(arr1.get(i) * arr1.get(i-1) > arr1.get(i) + arr1.get(i-1)) sum += (arr1.get(i) * arr1.get(i-1));
			else sum += (arr1.get(i) + arr1.get(i-1));
		}
		if(arr1.size() % 2 == 1) sum += arr1.get(0);
		for(int i=0; i<arr2.size()-1; i+=2) {
			if(arr2.get(i) * arr2.get(i+1) > arr2.get(i) + arr2.get(i+1)) sum += (arr2.get(i) * arr2.get(i+1));
			else sum += (arr2.get(i) + arr2.get(i+1));
		}
		if(arr2.size() % 2 == 1) sum += arr2.get(arr2.size()-1);
		System.out.println(sum);
	}
}
