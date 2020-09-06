package recursion;

import java.util.Scanner;

public class Backjoon_4811 {
	
	public static int multipleCases(int half, int whole) {
		
		if(half==0 && whole==0) {
			return 1 ; // ���� ����
		}
		else if(half==0 && whole !=0) {
			return multipleCases(half+1, whole-1); 
		}
		else if (half != 0 && whole ==0) {
			return multipleCases(half-1, whole);
		}
		else { //(half !=0 && whole !=0)
			return multipleCases(half+1, whole-1) + multipleCases(half-1, whole); // ����� �� 2���� x2
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// �Է� : �� ����(N) <= 30
		// �ݺ� : 2*N  -> until �����ִ� ���� ���� =0 && ���� ����=0
		
		Scanner sc = new Scanner(System.in);
//		System.out.println("�˾��� ������ �Է��ϼ��� : ");
		int N=sc.nextInt();
		int half=0;
		
//		System.out.println("����� ������ �����ϴ�. >> "+multipleCases(0,N));
		System.out.println(multipleCases(0,N));
		
	}
}
