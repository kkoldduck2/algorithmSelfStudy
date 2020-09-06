package greedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1744
/*양수는 큰 양수끼리,  음수는 작은 음수끼리 곱해서 더한다
 * 예외 ) 1은 안 곱하는게 낫다 (그냥 더한다.)   1+2 > 1*2
 * 에외 ) 0은 하나 남는 음수랑 곱하는게 좋다. */

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
		Collections.sort(minus);	// 오름차순  -10 , -9, -8 ...
		Collections.reverse(plus);	// 내림차순10, 9, 8 ... 
		
		if(plus.size()%2!=0) {
			plus.add(1);  // 여기서 1은 임의로 추가하는 값, 나중에 결국 곱하면 사라질 숫자
		}
		if(minus.size()%2!=0) {
			minus.add(zero > 0 ? 0 : 1); // 주어진 숫자 중에 0이 있으면 minus에 추가하고 아니면 걍 1추가(곱하면서 사라지는)
		}
		
		int ans = one; // 1의 개수만큼 더함
		for(int i=0; i<plus.size(); i+=2) {
			ans += plus.get(i) * plus.get(i+1);
		}
		
		for(int i=0; i<minus.size(); i+=2) {
			ans += minus.get(i)*minus.get(i);
		}
		
		System.out.println(ans);
	}
}
