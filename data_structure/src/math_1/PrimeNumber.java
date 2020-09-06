package math_1;

import java.util.Scanner;

/* �Ҽ� : ����� 1�� �ڱ� �ڽ� �ۿ� ���� �� 
 * N�� �Ҽ��� �Ǵ��� Ȯ�� �ϴ� ��� 
 * 1) 2~N-1���� �����鼭 Ȯ��
 * 2) 2~ N/2���� �����鼭 Ȯ�� (N�� ��� �߿��� ���� ū ���� N/2���� �۰ų� ���� ����) 
 * 		N = a * b,   a�� Ŭ���� b�� �۴�. a �߿��� ���� ���� ���� 2�̹Ƿ� b�� N/2���� �۰ų� ����
 * 3) 2~ ��Ʈ N���� �����鼭 Ȯ�� 
 * N = a * b �϶� (a<=b), �� �� a, b �� ��� �ϳ��� ��Ʈ N���� �۴�.
 * (���� a b ��� ��Ʈ N��� ũ�ٸ� a*b�� N���� Ŭ �� �ۿ� ����.)
 * ���� a�� 2���� ��Ʈ N���� �ۿ� ���� ���̴�. 
 * �׷��� 2 ~��Ʈ N������ Ȯ���غ��� ��� N�� �Ҽ����� �ƴ��� �Ǻ� ������ ���̴�. 
 * */
public class PrimeNumber {
	
	public static boolean isPrime(int n) {
		
		if(n<2) {
			return false;
		}
		
		for(int i=2; i*i<n; i++) {
			if(n%i==0) {
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("is prime? "+isPrime(n));
	}
}
