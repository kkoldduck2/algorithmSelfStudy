package dinamicProgramming;
/*
 	�־��� �ڿ��� N�� ������ ���� ������ ǥ���� �� �� ���� �ּ� ������ ���Ͻÿ�
 	11 = 3^2 + 1^2 + 1^2
 	
 	__ + __ + __ + ... + i^2 = N
 	
 	min(D[N - i^2] +1) = D[N]
 	(i^2 <= N)
 	
 	min(D[i - j^2] +1) = D[i]			-> for���� ���鼭 D[i]�� ä�����ϹǷ� ���� ������ �̷��� ������
 	(j^2 <= i)
 	
 * */
public class SquareSum {
	public static void main(String[] args) {
		int n= 7;
		
		int[] d = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			d[i] = i; // 1+1+1+...+1 = (1�� i�� ���Ѱ�)�� ���̰� ���� ū ��. ���⼭ ���� ���� ��찡 ������ �װ� �����Ұ���
			
			for(int j=1; j*j<=i; j++) {
				if(d[i] > d[i - j*j]+1) {
					d[i] = d[i - j*j] +1;
				}
			}
		}
		
		System.out.println(d[n]);
	}
}
