package divideNconquer;

import java.util.Scanner;
// ����: ��������(���)
// ��� ������ ����ϴ� ���� ���� ������
// �ּ� �̵� Ƚ���� ���̳������� Ǭ��.
public class _4_HanoiTower {
	
	// n���� ������ x��տ��� y������� �ű��. 
	// ����� 1,2,3�� ����� �ְ�,
	// ���� x+y+z = 6   (z�� �ű���� ����� �ƴ� �ٸ� ���)
	// solve (1~n���� ������, x���� , y�� ) �ű��. 
	public static void solve(int n, int x, int y) {
		if(n==0) return;
		solve(n-1, x, 6-x-y);		// 1) 1~n-1���� ������ x���� 6-x-y(�ӽ�)�� �ű��. 
		System.out.println(x+" "+y);		// 2) n�� ������ x���� y�� �ű��
		solve(n-1, 6-x-y, y);		// 3) 1~n-1���� ������ 6-x-y(�ӽ�)���� y(������)�� �ű��.
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		// �ּ� �̵� Ƚ��  by ���̳��� ���α׷���
		int[] d= new int[n+1];		//n���� ������ �ٸ� ���� �̵���Ű�� �ּ����� Ƚ��
		//  d[n] = 2*d[n-1]+1
		
		d[1]= 1;
		for(int i=2; i<n+1; i++) {
			d[i] = d[i-1]*2 +1;		// 1~n-1���� �����̴� �۾� �ι� + n�� ������ �ű�°� 1��
		}
		System.out.println(d[n]);
		
		//�� ������ �Ϲ�ȭ �ϸ� d[n] = 2^n-1�̴�. ���� 	
		//System.out.println((1<<n)-1);
		
		
		solve(n,1,3);	// n���� ������ 1��° ��տ��� 3��° ������� �ű�� ����?
	}
}
