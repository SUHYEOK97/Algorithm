import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static ArrayList<Integer> arr = new ArrayList<>();
	static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		insert(0);
	}

	private static void insert(int idx) {
		if(idx == str.length()) {
			for(int i=1; i<=arr.size(); i++) {
				if(!arr.contains(i)) return;
			}
			for(int i=0; i<arr.size(); i++) System.out.print(arr.get(i)  + " ");
			System.exit(0);
		}
		for(int i=1; i<=2; i++) {
			if(idx+i > str.length()) return;
			int num = Integer.parseInt(str.substring(idx, idx+i));
			if(num > 50) continue;
			if(arr.contains(num)) continue;
			arr.add(num);
			insert(idx + i);
			arr.remove(arr.lastIndexOf(num));
		}
	}
}
