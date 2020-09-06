package study_beakjoon;

import java.util.*;

// https://www.acmicpc.net/problem/2022
// �ؼ�) https://jennylee4517.github.io/ps/2022-%EC%82%AC%EB%8B%A4%EB%A6%AC/
public class _200820_2022_BinarySearch {
	static double getC(double x, double y, double d) {
		double h1 = Math.sqrt(x*x-d*d);
		double h2 = Math.sqrt(y*y-d*d);
		
		return h1*h2/(h1+h2);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		double c = sc.nextDouble();
		double d; 	// �츮�� ���ؾ��� ��
		
		// �Է°� �� �� ū ���� x�� �����ϰڴ�.
		if(y>x) {
			double temp = x;
			x=y;
			y=temp;
		}
		
		double l=0;			// d�� �ּҰ�
		double r=y;			// d�� �ִ밪
		double newC;
		
		// �̺�Ž���� ���� �־��� C�� ���� �ٻ��� newC�a ����� d�� ã�´�. 
		while(true) {
			d = (l+r)/2;	// d�� ���� l�� r�� �߰� ������ ��´�.
			newC = getC(x,y,d);
			
			// c-newC�� 0.001�̸��̸� �����Ѵ�. 
			if(Math.abs(c-newC)<0.001) {
				System.out.println(d);
				break;
			}
			
			// ���� �������� ����. --> d ���� ���Ѿ�
			if(newC >c) {
				l=d;
			}else {
				r=d;
			}
			
		}
		
	}
}
