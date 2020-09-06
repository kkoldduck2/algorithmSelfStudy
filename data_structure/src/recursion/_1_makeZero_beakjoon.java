package recursion;

import java.util.Scanner;

// 7490번
public class _1_makeZero_beakjoon {
	// 방정식, 가장 최근 부호, 가장 최근 숫자, 현재 숫자, 최종 숫자, 연산 결과 
	public static String makeeq(String eq, int q) {
		// 1~q까지 부호 사용해서 방정식 만든다. 
		if(q<1) {
			return eq;
		}
		// +, -, 공백
		makeeq(eq+' '+q, q-1);
		makeeq(eq+'+'+q, q-1);
		makeeq(eq+'-'+q, q-1);
		
		 
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		String eq="";
		char lc='a';
		int ln = 0;
		int result=0;
		
		for(int i=0; i<tc; i++) {
			int q = sc.nextInt();
			if(q>3) {
				makeeq(eq, q);
			}else if(q==3){
				System.out.println("1+2-3");
			}
		}
		
	}
}
