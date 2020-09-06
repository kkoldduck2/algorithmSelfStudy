package study_programmers;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42839
/* �� ���� ������ ���� ���ڰ� ���� ���ڿ� numbers�� �־����� ��, 
 * ���� �������� ���� �� �ִ� �Ҽ��� �� ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.*/
public class BruteForce_Find_PrimeNum {
	static String[] number;
	static boolean[] check;
	static StringBuilder sb;
	static ArrayList<Integer> arr = new ArrayList<>();
	static ArrayList<String> select = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String numbers = sc.next();
		number = numbers.split("");
		check = new boolean[number.length];
		
		
		for(int i=0; i<check.length; i++) {
			check[i] = false;
		}
		
		// ��� ���ձ��ϱ� -> select�� ����
		makecomb(0,0,0);
		
		// select�� ���ؼ� ���� ���� 
		for(int i=0; i< select.size(); i++) {
			String[] selected = select.get(i).split("");
			perm(selected,0);

		}
		System.out.println(arr.size());
	}
	
	// k-1 ��° ������ ������ 
	static void makecomb(int k, int dept, int checkcount) {
		if(dept==number.length) {
			sb = new StringBuilder();
			// check�� ���� -> sb�� �� �̾ �ϳ��� ���ڿ��� ����� select�� ����
			for(int i=0; i<number.length; i++) {
				if(check[i]==true) {
					sb.append(number[i]);
				}
			}
			
			if(!select.contains(sb.toString()) && !sb.toString().equals("")) {
				select.add(sb.toString());
			}

			return;
		}
		
		// k�� ������
		check[k] = true;
		makecomb(k+1, dept+1, checkcount+1);
		
		// k�� ���� ���� 
		check[k] = false;
		makecomb(k+1, dept+1, checkcount);
		
		
	}
	
	// ���� : k-1 ��°���� ���� ������ ��Ȳ
	static void perm(String[] select, int k) {
		
		// ��� ������ �� ������ -> �� ���ڰ� prime ���� Ȯ�� -> ������ �̹� �ִ� �������� Ȯ���ϰ� count++
		if(k==select.length-1) {
			sb = new StringBuilder();
			for(String s : select) {
				sb.append(s);
			}
			
			int makeNum = Integer.parseInt(sb.toString());
			if(isPrime(makeNum) && !arr.contains(makeNum) && makeNum!=0 && makeNum!=1) {
				arr.add(makeNum);
			}
			
			return;
		}
		
		for(int i=k; i<select.length; i++) {
			swap(select,k, i);
			perm(select, k+1);
			swap(select,k, i);
		}
		
		
	}
	
	// prime���� Ȯ���ϴ� �Լ� 
	static boolean isPrime(int num) {
		int primeCount=0;
		for(int i=2; i<num; i++) {
			if(num%i==0) {
				primeCount++;
			}
		}
		
		if(primeCount==0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	static void swap(String[] select,int a, int b) {
		String temp = select[a];
		select[a] = select[b];
		select[b] = temp;
	}
	
}
