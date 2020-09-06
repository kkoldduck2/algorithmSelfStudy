package beakjoon;

import java.util.Scanner;

/*영어 대소문자와 띄어쓰기만으로 이루어진 문자열이 주어진다. 
이 문자열에는 몇 개의 단어가 있을까? 
이를 구하는 프로그램을 작성하시오. 
단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.*/


public class String_1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자를 입력하세요");
		String s = sc.nextLine();		// nextLine과 next의 차이??
		String[] sArr = s.split(" ");
			
		int cnt =0;
		
//		for(int i=0; i<sArr.length;i++) {
//			System.out.println(sArr[i]);
//		}
		
		for(String a : sArr) {
			cnt++;
		}
		
		System.out.println(cnt);
		sc.close();
	}
}
