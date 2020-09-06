package dinamicProgramming;
/*
 * �����̴� � ���� N�� ������ ���� ���� �� �ϳ��� �� �� �ִ�.
 * 1. N�� 3���� ������ �������� 3���� ������
 * 2. N�� 2�� ������ �������� 2�� ������
 * 3. 1�� ����.
 * 
 * �����̴� � ���� N�� ���� ���� ������ �����ؼ� 1�� ������� �Ѵ�. ������ ����ϴ� Ƚ���� �ּڰ��� ����ϼ��� 
 * 
 * */

// D(N) : N�� �� �� �ϳ��� ������ �����ؼ� 1�� �����. 
// D(N) = MIN(D(N/3),D(N/2),D(N-1)) +1
public class Make1 {
	 
	
	// topDown -> ����� ����
	public static int Make1TopDown(int[] d, int n) {
		
		if(n==1) return 0; // 1->1. ���� �ʿ� ����. ��Ϳ����� base case
		if(d[n]>0) return d[n];	// memorization (�̹� ���� ���� ���� ��� ����� ���� ��ȯ)
		
		d[n]=Make1TopDown(d,n-1)+1;
		if(n%2==0) {
			int temp = Make1TopDown(d,n/2)+1;
			if(d[n]>temp) {
				d[n]=temp;
			}
		}
		
		if(n%3==0) {
			int temp = Make1TopDown(d,n/3)+1;
			if(d[n]>temp) {
				d[n] = temp;
			}
		}
		return d[n];
	}
	
	// BottomUP -> for �ݺ����� ���� 
	public static int Make1Bottomup(int[] d,int n) {
		d[1]=0;
		for(int i=2; i<=n; i++) {
			d[i]=d[i-1]+1;
			if(i%2==0 && d[i]>d[i/2]+1) {
				d[i]= d[i/2]+1;
			}
			if(i%3==0 && d[i]>d[i/3]+1) {
				d[i]= d[i/3]+1;
			}
		}
		return d[n];
	}
	
	public static void main(String[] args) {
		int n =10;
		int [] d = new int[n+1];
		for(int i=0; i<d.length;i++) {
			d[i]=0;
		}
		int ans = Make1TopDown(d,n);
		
		int ans2= Make1Bottomup(d,n);
		System.out.println(ans+", "+ans2);
	}
}
