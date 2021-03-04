import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static Long n;
	static Long m; // 목표
	static Long max = (long) 0;
	static HashMap<Long, Long> map;
	static ArrayList<Long> idx;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		map = new HashMap<>();
		idx = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			Long num = Long.parseLong(st.nextToken());
			if(map.containsKey(num)) map.put(num, map.get(num)+1);
			else {
				idx.add(num);
				map.put(num, (long) 1);
			}
		}
		Collections.sort(idx, Collections.reverseOrder());
		search();
		sb.append(max);
		System.out.println(sb);
	}
	public static void search() {
		Long start = (long) 0;
		Long end = idx.get(0);
		while(start <= end) {
			Long mid = (start+end)/2;
			Long s = getSum(mid);
			if(s >= m) {
				start = mid+1;
				max = Math.max(mid, max);
			}
			else if(s < m) end = mid-1;
		}
	}
	public static Long getSum(Long mid) { 
		Long sum = (long) 0;
		for(int i=0; i<idx.size(); i++) {
			Long num = idx.get(i);
			if(num-mid < 0) continue;
			sum += (num-mid)*map.get(num);
		}
		return sum;
	}
	
}
