package math_1;

import java.util.Stack;

// 진법 변환 

/* 10진법 수 N을 B진법으로 바꾸려면 N이 0이 될 때 까지 나머지를 계속해서 구하면 된다. 
 * */
public class BaseConversion {
	// B진법 수 N을 다시 10진법 수로 변환 
	public static double reverse(String n, int b) {
		// n = 102
		// return -> b^2 *1 + b^1 *0 + b*2
		double ans = 0;
		for(int i=0; i<n.length(); i++) {
			int square = n.length()-1-i;
			ans += Math.pow(b, square) * (n.charAt(i)-'0');		// -'0'안해주면 ascii 코드값으로 나와서 숫자 이상해짐
		}
		return ans;
	}
	
	// B진법 수 N을 다시 10진법 수로 변환  2번째 방법
	// 3진법 수 102를 변환한다고 할때
	// 1 -> 1
	// 10 -> 1*3+0 
	// 102 -> (1*3+0)*3 +2 = 1* 3^2 + 0*3 + 2
	public static int reverse2(String n, int b) {
		int ans=n.charAt(0)-'0';
		for(int i=1; i<n.length(); i++) {
			ans = ans*b + (n.charAt(i)-'0');
			System.out.println(i+1+"차 : "+ ans);
		}
		return ans;
	}
	public static void main(String[] args) {
		int n = 11;	//10진 법 수 N
		int b = 3;	// b진법 
		
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
