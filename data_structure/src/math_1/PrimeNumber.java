package math_1;

import java.util.Scanner;

/* 소수 : 약수가 1과 자기 자신 밖에 없는 수 
 * N이 소수가 되는지 확인 하는 방법 
 * 1) 2~N-1까지 나누면서 확인
 * 2) 2~ N/2까지 나누면서 확인 (N의 약수 중에서 가장 큰 것은 N/2보다 작거나 같기 때문) 
 * 		N = a * b,   a가 클수록 b는 작다. a 중에서 가장 작은 값은 2이므로 b는 N/2보다 작거나 같다
 * 3) 2~ 루트 N까지 나누면서 확인 
 * N = a * b 일때 (a<=b), 두 수 a, b 중 적어도 하나는 루트 N보다 작다.
 * (만약 a b 모두 루트 N모다 크다면 a*b는 N보다 클 수 밖에 없다.)
 * 따라서 a는 2부터 루트 N까지 밖에 없을 것이다. 
 * 그래서 2 ~루트 N까지만 확인해보면 어떤수 N이 소수인지 아닌지 판별 가능할 것이다. 
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
