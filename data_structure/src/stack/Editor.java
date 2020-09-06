package stack;

import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/1406
public class Editor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack s1 = new Stack();
		Stack s2 = new Stack();
		
		System.out.println("�ʱ⿡ �����⿡ �ԷµǾ� �ִ� ���ڿ�");
		String o = sc.nextLine();
		// sc.nextLine(); 	// ���� ���� 
		for(int i=0; i<o.length(); i++) {
			s1.push(o.charAt(i));
		}
		
		
		System.out.println("��� Ƚ���� �Է��ϼ��� ");
		int n = sc.nextInt();
		sc.nextLine(); 	// ���� ���� 
		
		while (n!=0) {
			System.out.println("����� �Է��ϼ���");
			String order = sc.nextLine();
			n--;
			char type = order.charAt(0);
			switch(type) {
				case 'P':
					s1.push(order.charAt(order.length()-1));
					break;
				case 'B':
					if(!s1.isEmpty()) {
						s1.pop();
					}else {
						continue;
					}
					break;
				case 'L':
					if(!s1.isEmpty()) {
						s2.push(s1.pop());
					}
					else {
						continue;
					}
					break;
				case 'D':
					if(!s1.isEmpty()) {
						s1.push(s2.pop());
					}
					else {
						continue;
					}
					break;
					
				default:
					break;
			}
		}
		
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		
		String ans ="";
		while(!s2.isEmpty()) {
			ans+=s2.pop();
		}
		
		System.out.println(ans);
	}
}
