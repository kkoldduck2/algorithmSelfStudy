package beakjoon;
//https://www.acmicpc.net/problem/11654

import java.util.Scanner;

// ���ĺ� �ҹ���, �빮��, ���� 0-9�� �ϳ��� �־����� ��, �־��� ������ �ƽ�Ű �ڵ尪�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
// �Է� : ���ĺ� �ҹ���, �빮��, ���� 0-9 �� �ϳ��� ù° �ٿ� �־�����
// ��� : �Է����� �־��� ������ �ƽ�Ű �ڵ� ���� ����Ѵ�.

public class AsciiCode_11654 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int num = s.charAt(0);		// string���� 0��° �ε����� �ش��ϴ� ����  -> int ������ ��ȯ�ؼ� ����
		
		System.out.println(num);
		
	}
}
