package math_1;
/*https://www.acmicpc.net/problem/2609
 * �ִ� ������� GCD��� ����.
 * �� �� A�� B�� �ִ� ����� G�� A�� B�� ����� ��� �߿��� ���� ū �����̴�.
 * �ִ� ������� ���ϴ� ���� ���� ����� 2���� min(A, B)���� ��� ������ ������ ���� ��� 
 * �ִ� ������� 1�� �� ���� ���μ� ��� �Ѵ�. 
 * 
 * */

/* �� ���� �ִ����� 
 * gcd(a,b,c) = gcd(gcd(a,b),c)
 * 
 * n���� ���ڵ� ���Ͱ��� ������� �ϸ� �ȴ�. 
 * 
 * */

public class GCD {
	public static int gcd(int a, int b) {
		int g = 1;
		for(int i=2; i<Math.min(a, b); i++) {
			if(a%i==0 && b%i ==0) {
				g = i;
			}
		}
		return g;
	}
	public static int euclideanGCD(int a, int b) {
		// gcd(a, b) = gcd(b, a%b)
		
		// a�� �׻� b���� Ŀ���Ѵ�. 
		if(a<b){
			int temp=a;
			a = b;
			b = temp;
		}		
		
		if (b==0) return a;
		
		else {
			return euclideanGCD(b, a%b);
		}
	}
	
	// �ּҰ���� 
	// Lcm * Gcd = A * B
	// Lcm = (A*B)/GCD
	public static int lcm(int a, int b, int g) {
		int lcm = (a*b)/g;
		return lcm;
	}
	
	public static void main(String[] args) {
		int a = 24;
		int b = 16;
		int g = gcd(a,b);
		int g1 = euclideanGCD(a,b);
		int l = lcm(a,b,g);
		System.out.println(g+", "+ g1);
		System.out.println(l);
	}
}
