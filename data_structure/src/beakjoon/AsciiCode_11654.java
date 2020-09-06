package beakjoon;
//https://www.acmicpc.net/problem/11654

import java.util.Scanner;

// 알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
// 입력 : 알파벳 소문자, 대문자, 숫자 0-9 중 하나가 첫째 줄에 주어진다
// 출력 : 입력으로 주어진 글자의 아스키 코드 값을 출력한다.

public class AsciiCode_11654 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int num = s.charAt(0);		// string에서 0번째 인덱스에 해당하는 문자  -> int 형으로 변환해서 저장
		
		System.out.println(num);
		
	}
}
