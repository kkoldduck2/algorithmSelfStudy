package dinamicProgramming;

import java.util.Scanner;

// 권오흠 강의 
/* 여러 행렬을 곱할때 어떻게 결합 법칙을 적용해서 최적의 순서를 정할 것인가?
 * 최소 곱셈 횟수를 구하세요 
 * 동적 계획법 
 * 1) 순환식 구하기 (Optimal Stucture : 문제에 대한 최적해를 정의하고, 그것의 일부분이 그 부분해에 대한 최적해인지 확인한다.)
 * 		m[i,j] : Ai, Ai+1, Ai+2, ..., Aj를 곱하는 최소 곱셈 횟수
 * 		m[i,j] = 0 (i=j)
 * 			   = min (m[i,k] + m[k+1,j] + Pi-1 * Pk * Pj)  (i<j)		--> 결국 base case로 수렴해야 한다. 
 * 
 * 2) 순환식을  memoization 이나 bottom up 방식으로 어떻게 풀 것인가? 
 * 		bottom up : 순환식 오른쪽 인자가 왼쪽 인자보다 먼저 계산되도록 프로그램을 구성한다. 
 * 		-> m[i,j]를 저장할 2차원 배열을 그려보자
 * 		-> 우리가 최종적으로 구하고 싶은 값 m[1,n]를 리턴시킨다. 
 * */
public class _DP1_Matrix_chain_Multiplecation {
	static int[][] m;
	static int[] p;
	
	static int matrixChain(int n) {
		for(int i=1; i<=n; i++) {	
			m[i][i] = 0; 		// 대각선 (i, i)를 미리 0으로 채우기 
			p[i]=i+1;		// 걍 아무값이나 넣은거 별 의미 x (Ai 행렬 = pi-1 x pi)
		}
		
		// r번째 대각선에 대해서  (대각선의 개수는 총 n-1개)
		for(int r=1; r<=n-1; r++) {
			// r번째 대각선의 i번째 행의 값 (인덱스 j) (r번째 대각선에 존재하는 값들의 개수는 총 n-r개 )
			for(int i=1; i<=n-r; i++) {
				int j= i+r; // r번째 대각선 + i번째 행 = j열 (이차원 배열 그림 보면 이해가 갈 것)
				m[i][j] = m[i+1][j] + p[i-1]*p[i]*p[j];		// k=i일 때 (m[i,i]는 없어짐) -> default
				
				for(int k=i+1; k<=j-1; k++) {	// 최솟값 구하는 로직
					if(m[i][j] > m[i][k] + m[k+1][j] + p[i-1]*p[i]*p[j]) {
						m[i][j] = m[i][k] + m[k+1][j] + p[i-1]*p[i]*p[j];
					}
				}
			}
		}
		return m[1][n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		m = new int[n+1][n+1];
		matrixChain(n);
	}
}
