package recursion;
/* <���ȣ��� ���� Ž��>
 ����Լ��� �ڽ��� ������ �۾��� ������ ������ ���� �������� �ɰ� ��
 �� �� �� ������ �����ϰ�, �������� �ڱ� �ڽ��� ȣ���� �����ϴ� �Լ��� ����Ų��.
 ������ ���� �ڵ带 �ݺ��� �����ϴ� for���� �� �뵵�� ����ϴ�.
 */



public class APSS_Sum_p147 {
	
	// �ʼ� ���� : n>=1
	// ��� : 1���� n������ ���� ��ȯ�Ѵ�.
	
	// 1) for���� �̿��� solution
	public static int sum(int n) {
		int sum=0;
		for(int i=1; i<=n; i++) {
			sum+=i;
		}
		return sum;
	}


	// 2) ��͸� �̿��� solution

	public static int reculsiveSum(int n) {
		// ��������  (�� �̻� �ɰ����� ���� �� )
		if(n==1) return 1;
		
		// �ݺ�
		else {
			return n+reculsiveSum(n-1);
		}
		
	}
	
	
	public static void main(String[] args) {
		int n= 10;
		System.out.println("for���� �̿��� ��� : "+sum(n));
		System.out.println("��͸� �̿��� ��� : "+sum(n));
	}
}
