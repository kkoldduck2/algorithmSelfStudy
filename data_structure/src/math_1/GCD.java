package math_1;
/*https://www.acmicpc.net/problem/2609
 * 최대 공약수는 GCD라고 쓴다.
 * 두 수 A와 B의 최대 공약수 G는 A와 B의 공통된 약수 중에서 가장 큰 정수이다.
 * 최대 공약수를 구하는 가장 쉬운 방법은 2부터 min(A, B)까지 모든 정수로 나누어 보는 방법 
 * 최대 공약수가 1인 두 수를 서로소 라고 한다. 
 * 
 * */

/* 세 수의 최대공약수 
 * gcd(a,b,c) = gcd(gcd(a,b),c)
 * 
 * n개의 숫자도 위와같은 방식으로 하면 된다. 
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
		
		// a가 항상 b보다 커야한다. 
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
	
	// 최소공배수 
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
