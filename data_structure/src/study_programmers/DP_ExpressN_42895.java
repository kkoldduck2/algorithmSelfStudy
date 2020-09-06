package study_programmers;

import java.util.HashMap;
import java.util.Scanner;
// https://programmers.co.kr/learn/courses/30/lessons/42895
// N�� 1�̻� 9����
// number�� 1 �̻� 32,000 ����
// ����Ե� ������ ����. �����ϴٰ� ���� ������ �κ��� �������̴�. 
public class DP_ExpressN_42895 {
	static final  HashMap<Integer, Integer> k = new HashMap<>();
	static int N;
	static int number;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("N�� �Է��ϼ���");
		N = sc.nextInt();
		
		System.out.println("number�� �Է��ϼ��� ");
		number = sc.nextInt();
		int[] d = new int[number*number];		// d[i] : N�� ����ؼ� i�� ���� �ּ� Ƚ��
		
		// �ʱ�ȭ : ���� (N/N) 1�� ���� ���Ѵٰ� ������ �� 
		for(int i=0; i<number*number; i++) {
			d[i] = i*2;
		}
		
		// ������ K ��� HashMap�� ��� 
		k.put(N, 1);
		int temp = N;
		insertK(temp, 2);
		/* d[num] = + k : d[num-k] + k�� ����� ���� ����� N Ƚ�� 
		 * 		  = - k : d[num+k] 
		 * 		  = * k : d[num/k] 
		 * 		  = / k : d[num*k] 
		 * 1<= k < num, N���� ���� �� �ִ� ��� ���� 
		 * d[num] > 8 �̸� -1�� �����Ѵ�. 
		 * */
//		System.out.println("keySet�� �˾ƺ��� ");
//		for(int key : k.keySet()) {
//			System.out.println("key : "+key+", "+"value : "+k.get(key));
//		}
		
		
		
		
		
		if(d[number]>8) {
			System.out.println(-1);
		}else {
			System.out.println(d[number]);
		}

		
	}
	
	
	/* ������ K�� ���
	 * N��
	 * 1�� ��� : N     1��
	 * 2�� ��� : N/N, N+N, N*10+N (=NN), N-N (0�̶� ������, ����)		// 4��
	 * 3�� ��� : 2�� ��뿡   +N , -N, *10+N (=NNN), /N, *N			// 5��
	 * 4�� ��� : 3�� ��뿡  ... 										// 5��
	 * 8�� ��� : 
	 * */
	static void insertK(int temp, int cnt) {
		if(temp <=0 || cnt > 8 || temp > number*number) {
			return;
		}
		
		// ������
		if(temp/N >0 &&!k.containsKey(temp/N)) {
			 k.put(temp/N, cnt);
			 insertK(temp/N,cnt++);
		}
		// ���ϱ�
		if(!k.containsKey(temp+N)) {
			 k.put(temp+N, cnt);
			 insertK(temp+N,cnt++);
		}
		// ���� 
		if(temp-N>0 && !k.containsKey(temp-N)) {
			 k.put(temp-N, cnt);
			 insertK(temp-N,cnt++);
		}
		
		// ���ϱ� 
		if(temp*N < number*3 && !k.containsKey(temp*N)) {
			 k.put(temp*N, cnt);
			 insertK(temp*N,cnt++);
		}
		
		// 
		if(temp*10+N < number*3 && !k.containsKey(temp*10+N)) {
			 k.put(temp*10+N, cnt);
			 insertK(temp*10+N,cnt++); 
		}
		
	}
}
