package stack;

import java.util.Scanner;
import java.util.*;

// https://www.acmicpc.net/problem/9012

public class Stack1 {
	
	public static String isValid(String s) {
		s= s.trim();
		Stack stack = new Stack();
		
		int size = s.length();
		
		for(int j=0; j<size; j++) {
			if(s.charAt(j)==')' && !stack.isEmpty()) {
				stack.pop();
				continue;
			}
			else if(s.charAt(j)=='(') {
				stack.push(s.charAt(j));
			}else if(s.charAt(j)==')' && stack.isEmpty()) {
				return "NO";
			}
			
		}
		
		if(stack.isEmpty()) return "YES";
		else return "NO";
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.out.println("n�� �Է��ϼ��� ");
		int n = sc.nextInt();
		sc.nextLine();		// ���� ����  
		
		while(n>0) {
			// System.out.println("s�� �Է��ϼ���");
			System.out.println(isValid(sc.nextLine()));
			n--;
		}
		
	}
}
