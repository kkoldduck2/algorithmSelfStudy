package recursion;
/* <재귀호출과 완전 탐색>
 재귀함수란 자신이 수행할 작업을 유사한 형태의 여러 조각으로 쪼갠 뒤
 그 중 한 조각을 수행하고, 나머지를 자기 자신을 호출해 실행하는 함수를 가리킨다.
 완전히 같은 코드를 반복해 실행하는 for문과 그 용도가 비슷하다.
 */



public class APSS_Sum_p147 {
	
	// 필수 조건 : n>=1
	// 결과 : 1부터 n까지의 합을 반환한다.
	
	// 1) for문을 이용한 solution
	public static int sum(int n) {
		int sum=0;
		for(int i=1; i<=n; i++) {
			sum+=i;
		}
		return sum;
	}


	// 2) 재귀를 이용한 solution

	public static int reculsiveSum(int n) {
		// 종료조건  (더 이상 쪼개지지 않을 때 )
		if(n==1) return 1;
		
		// 반복
		else {
			return n+reculsiveSum(n-1);
		}
		
	}
	
	
	public static void main(String[] args) {
		int n= 10;
		System.out.println("for문을 이용한 결과 : "+sum(n));
		System.out.println("재귀를 이용한 결과 : "+sum(n));
	}
}
