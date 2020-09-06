package greedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1744
/*����� ū �������,  ������ ���� �������� ���ؼ� ���Ѵ�
 * ���� ) 1�� �� ���ϴ°� ���� (�׳� ���Ѵ�.)   1+2 > 1*2
 * ���� ) 0�� �ϳ� ���� ������ ���ϴ°� ����. */

public class _20_01_13_1744 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> plus  = new ArrayList<Integer>();
		ArrayList<Integer> minus = new ArrayList<Integer>();
		
		int zero = 0;
		int one = 0;
		
		for(int i=0; i<n ; i++) {
			int x = sc.nextInt();
			if(x==1) one ++;
			else if(x>0) {
				plus.add(x);
			} else if(x<0) {
				minus.add(x);
			}else {
				zero++;
			}
		}
		
		Collections.sort(plus);
		Collections.sort(minus);	// ��������  -10 , -9, -8 ...
		Collections.reverse(plus);	// ��������10, 9, 8 ... 
		
		if(plus.size()%2!=0) {
			plus.add(1);  // ���⼭ 1�� ���Ƿ� �߰��ϴ� ��, ���߿� �ᱹ ���ϸ� ����� ����
		}
		if(minus.size()%2!=0) {
			minus.add(zero > 0 ? 0 : 1); // �־��� ���� �߿� 0�� ������ minus�� �߰��ϰ� �ƴϸ� �� 1�߰�(���ϸ鼭 �������)
		}
		
		int ans = one; // 1�� ������ŭ ����
		for(int i=0; i<plus.size(); i+=2) {
			ans += plus.get(i) * plus.get(i+1);
		}
		
		for(int i=0; i<minus.size(); i+=2) {
			ans += minus.get(i)*minus.get(i);
		}
		
		System.out.println(ans);
	}
}
