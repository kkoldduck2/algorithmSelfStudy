package math_1;

import java.util.Stack;

// ���� ��ȯ 

/* 10���� �� N�� B�������� �ٲٷ��� N�� 0�� �� �� ���� �������� ����ؼ� ���ϸ� �ȴ�. 
 * */
public class BaseConversion {
	// B���� �� N�� �ٽ� 10���� ���� ��ȯ 
	public static double reverse(String n, int b) {
		// n = 102
		// return -> b^2 *1 + b^1 *0 + b*2
		double ans = 0;
		for(int i=0; i<n.length(); i++) {
			int square = n.length()-1-i;
			ans += Math.pow(b, square) * (n.charAt(i)-'0');		// -'0'�����ָ� ascii �ڵ尪���� ���ͼ� ���� �̻�����
		}
		return ans;
	}
	
	// B���� �� N�� �ٽ� 10���� ���� ��ȯ  2��° ���
	// 3���� �� 102�� ��ȯ�Ѵٰ� �Ҷ�
	// 1 -> 1
	// 10 -> 1*3+0 
	// 102 -> (1*3+0)*3 +2 = 1* 3^2 + 0*3 + 2
	public static int reverse2(String n, int b) {
		int ans=n.charAt(0)-'0';
		for(int i=1; i<n.length(); i++) {
			ans = ans*b + (n.charAt(i)-'0');
			System.out.println(i+1+"�� : "+ ans);
		}
		return ans;
	}
	public static void main(String[] args) {
		int n = 11;	//10�� �� �� N
		int b = 3;	// b���� 
		
		Stack s = new Stack();
		int r =0;
		while(n!=0) {
			r = n%b;
			s.push(r);
			n= n/b;
		}
		String ans="";
		while(!s.isEmpty()) {
			ans+=s.pop();
		}
		System.out.println("ans: "+ans);
	
		double ans2 = reverse(ans, b);
		System.out.println("ans2: "+ans2);
		
		int ans3 = reverse2(ans, b);
		System.out.println("ans3: "+ans3);
		
	}
}
