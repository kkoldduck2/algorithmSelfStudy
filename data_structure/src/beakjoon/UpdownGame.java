package beakjoon;

import java.util.Scanner;

public class UpdownGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int x = (int)(Math.random()*100) +1;
		int k = 0;
		
		int cnt=0;
		for(int i=0; i<6; i++) {
			cnt++;
			int l= 6-i;
			System.out.println("���� Ƚ���� "+l+"ȸ �Դϴ�");
			System.out.println("���ڸ� �Է��ϼ���");
			k = sc.nextInt();
			if(k==x) {
				System.out.println("�����Դϴ�! : "+ x);
				break;
			}else {
				if(k>x) {
					System.out.println("�ٿ�");
				}else {
					System.out.println("��");
				}
			}
		}
		
		if(cnt==10) {
			System.out.println("����!");
		}
		
	}
}
