package recursion;

import java.util.Scanner;

public class Backjoon_4811 {
	
	public static int multipleCases(int half, int whole) {
		
		if(half==0 && whole==0) {
			return 1 ; // 종료 조건
		}
		else if(half==0 && whole !=0) {
			return multipleCases(half+1, whole-1); 
		}
		else if (half != 0 && whole ==0) {
			return multipleCases(half-1, whole);
		}
		else { //(half !=0 && whole !=0)
			return multipleCases(half+1, whole-1) + multipleCases(half-1, whole); // 경우의 수 2가지 x2
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// 입력 : 약 개수(N) <= 30
		// 반복 : 2*N  -> until 남아있는 약의 개수 =0 && 반쪽 개수=0
		
		Scanner sc = new Scanner(System.in);
//		System.out.println("알약의 개수를 입력하세요 : ");
		int N=sc.nextInt();
		int half=0;
		
//		System.out.println("결과는 다음과 같습니다. >> "+multipleCases(0,N));
		System.out.println(multipleCases(0,N));
		
	}
}
