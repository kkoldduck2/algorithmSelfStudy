package brute_force_search;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1107
// ����Ž�� 
/* 1. �̵��� ä�� C�� ���Ѵ�
 * 2. C�� ���ԵǾ� �ִ� ���� �߿� ������ ��ư�� �ִ��� Ȯ���Ѵ�
 * 3. ������ ��ư�� ���ٸ� |N-C|�� ����� +�� -��ư�� �� ��� �������ϴ��� ����Ѵ�.
 * 4. ����ó��) N= 101�� ���, ���� ��ġ(100)���� + ��ư�� �������
 * 				��, �̵��� ä�� (C)�� ���� �ʿ䰡 ����.  
 * 			=> ���� �ʱⰪ�� 100���� ���ڹ�ư�� ������ �ʰ� �̵��ϴ� Ƚ���� �����Ѵ�!
 * */
public class _01_1107_RemoteController {
	static boolean[] broken = new boolean[10]; //��ư�� ������ ������ true, �ƴϸ� false
	
	// C�� ���ԵǾ� �ִ� ���� �߿� ������ ��ư�� �ִ��� �˻�
	// �Ұ����ϸ� 0, �����ϸ� ��ư�� ������ �ϴ� Ƚ���� �����ϰ� ����
	static int possible(int c) {
		if(c==0) {
			return broken[0] ? 0 : 1;
		}
		
		int len = 0;
		while(c > 0) {
			if(broken[c%10]) return 0;
			len+=1;
			c/=10;
		}
		return len;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = Math.abs(n-100);
				
		// �̵��� ä�� C�� ���Ѵ�. 
		// 0 -> 50�� <- 100��
		
		for(int i=0; i<= 1000000; i++) {
			int c= i;
			int len = possible(c);
			if(len>0) {
				int press = Math.abs(c-n); // +�� -�� �� �� �������ϴ��� ���
				if(ans > len +press) {
					ans = len +press;
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
	
}
