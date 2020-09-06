package dinamicProgramming;
/*
 	주어진 자연수 N을 제곱수 들의 합으로 표현할 때 그 항의 최소 개수를 구하시오
 	11 = 3^2 + 1^2 + 1^2
 	
 	__ + __ + __ + ... + i^2 = N
 	
 	min(D[N - i^2] +1) = D[N]
 	(i^2 <= N)
 	
 	min(D[i - j^2] +1) = D[i]			-> for문을 돌면서 D[i]를 채워야하므로 식은 가급적 이렇게 써주자
 	(j^2 <= i)
 	
 * */
public class SquareSum {
	public static void main(String[] args) {
		int n= 7;
		
		int[] d = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			d[i] = i; // 1+1+1+...+1 = (1을 i번 더한거)이 길이가 가장 큰 값. 여기서 좀더 작은 경우가 있으면 그걸 대입할거임
			
			for(int j=1; j*j<=i; j++) {
				if(d[i] > d[i - j*j]+1) {
					d[i] = d[i - j*j] +1;
				}
			}
		}
		
		System.out.println(d[n]);
	}
}
