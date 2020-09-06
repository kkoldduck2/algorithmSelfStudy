package brute_force_search;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1107
// 완전탐색 
/* 1. 이동할 채널 C를 정한다
 * 2. C에 포함되어 있는 숫자 중에 망가진 버튼이 있는지 확인한다
 * 3. 망가진 버튼이 없다면 |N-C|를 계산해 +나 -버튼을 총 몇번 눌러야하는지 계산한다.
 * 4. 예외처리) N= 101일 경우, 현재 위치(100)에서 + 버튼만 누르면됨
 * 				즉, 이동할 채널 (C)를 누를 필요가 없다.  
 * 			=> 가장 초기값을 100에서 숫자버튼을 누르지 않고 이동하는 횟수로 지정한다!
 * */
public class _01_1107_RemoteController {
	static boolean[] broken = new boolean[10]; //버튼이 망가져 있으면 true, 아니면 false
	
	// C에 포함되어 있는 숫자 중에 망가진 버튼이 있는지 검사
	// 불가능하면 0, 가능하면 버튼을 눌러야 하는 횟수를 리턴하게 변경
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
				
		// 이동할 채널 C를 정한다. 
		// 0 -> 50만 <- 100만
		
		for(int i=0; i<= 1000000; i++) {
			int c= i;
			int len = possible(c);
			if(len>0) {
				int press = Math.abs(c-n); // +나 -를 몇 번 눌러야하는지 계산
				if(ans > len +press) {
					ans = len +press;
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
	
}
