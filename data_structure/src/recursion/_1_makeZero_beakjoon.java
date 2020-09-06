package recursion;

import java.util.Scanner;

// 7490��
public class _1_makeZero_beakjoon {
	// ������, ���� �ֱ� ��ȣ, ���� �ֱ� ����, ���� ����, ���� ����, ���� ��� 
	public static String makeeq(String eq, int q) {
		// 1~q���� ��ȣ ����ؼ� ������ �����. 
		if(q<1) {
			return eq;
		}
		// +, -, ����
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
