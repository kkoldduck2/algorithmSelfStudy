package brute_force_search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1525

// 2���� �迭 ���������� 1���� �迭ó�� �����Ѵ�. 
// 0�� 1�� �ٲٸ� �׻� 9�ڸ� ���ڰ� �ȴ�.
// 123456789 <- �� ���·� ����°� �����̴�. 
public class queue_04_1525 {
	
	public static final int[] dx = {0,0,1,-1};
	public static final int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 3;
		int start =0;		// ���� ��� 
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int temp = sc.nextInt();
				if(temp==0) {
					temp =9;
				}
				start = start*10 + temp;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		HashMap<Integer, Integer> dist = new HashMap<Integer, Integer>();
		dist.put(start, 0); 	// start -> start, 0���̸� ����
		q.add(start);
		
		while(!q.isEmpty()) {
			int now_num = q.poll();
			String now = Integer.toString(now_num);
			int z = now.indexOf('9');
			int x = z/3;  // 9�� �ִ� ��ġ x��ǥ
			int y = z%3;  // 9�� �ִ� ��ġ y��ǥ
			
			// ��,��, ��, �Ʒ� 4���� ����� ���� ���ؼ� 
			for(int k=0; k<4; k++) {
				int nx = x +dx[k];
				int ny = y +dy[k];
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					StringBuilder next = new StringBuilder(now);
					char temp = next.charAt(x*3+y);		// ���� ��ġ
					next.setCharAt(x*3+y, next.charAt(nx*3+ny));		// ���� ��ġ <- �ٲ� ��ġ�� ��
					next.setCharAt(nx*3+ny, temp);
					
					int next_num = Integer.parseInt(next.toString());
					if(!dist.containsKey(next_num)) {
						dist.put(next_num, dist.get(now_num)+1);
						q.add(next_num);
					}
				}
			}
		}
		if(dist.containsKey(123456789)) {
			System.out.println(dist.get(123456789));
		}else {
			System.out.println("-1");
		}
		
	}
}
