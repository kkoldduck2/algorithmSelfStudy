package beakjoon;

import java.util.Scanner;

/*���� ��ҹ��ڿ� ���⸸���� �̷���� ���ڿ��� �־�����. 
�� ���ڿ����� �� ���� �ܾ ������? 
�̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. 
��, �� �ܾ ���� �� �����ϸ� ������ Ƚ����ŭ ��� ����� �Ѵ�.*/


public class String_1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �Է��ϼ���");
		String s = sc.nextLine();		// nextLine�� next�� ����??
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
