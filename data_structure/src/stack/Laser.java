package stack;

import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/10799
public class Laser {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String q = sc.nextLine();
		Stack stack = new Stack();
		int ans =0;

		for(int i=0; i<q.length(); i++) {
			if(q.charAt(i)=='(') {

				stack.push('(');
			}
			else if(q.charAt(i)==')') {
				if(q.charAt(i-1)=='(') {
					stack.pop();
					ans += stack.size();
				}else if(q.charAt(i-1)==')') {
					stack.pop();
					ans+=1;
				}
			}
			
		}
		
		System.out.println(ans);
		
	}
}
