package stack;

import java.util.EmptyStackException;
//
//class Stack<T> {
//	class Node<T> {
//		private T data;
//		private Node<T> next; 	// ���� node�� �ּ� 
//		
//		// node ������ (������ ���ڷ� data �޴´�)
//		public Node(T data){
//			this.data = data;
//		}
//	}
//	
//	// ������� : stack�� �� ���� �ִ� �ּҸ� �˰� ������ �ȴ�.
//	private Node<T> top;
//	
//	// �Լ� ����
//	// ���� �����ִ� ���(�� ������)�� �������� �Լ�
//	public T pop() {
//		if(top == null) {
//			throw new EmptyStackException();
//		}
//		
//		// step 0. ���� top�� �ִ� data ���
//		T item = top.data;
//		
//		// step 1. top�� �ִ� data ��� ��, top ������ �ִ� ��带 top���� �ٲ۴�.
//		top = top.next;
//		
//		// step 2. item ����
//		return item;
//	}
//	
//	// ������ �߰� �Լ�
//	public void push(T item) {
//		//step 1.  �޾ƿ� ������ -> ��� ����
//		Node<T> t = new Node<T>(item);
//		
//		//step 2. ���� top �տ� ���ο� ��带 ��ġ��Ų��. ���� ���ο� ��尡 top�̴� 
//		t.next = top;
//		top = t;
//	}
//	
//	// ������ ������ �Լ� 
//	public T peek() {
//		// null üũ
//		if(top == null) {
//			throw new EmptyStackException();
//		}
//		
//		return top.data;
//	}
//	
//	public boolean isEmpty() {
//		// top�� �������� ������ �ȴ�.
//		return top == null;
//	}
//	
//	
//}
//
//
//public class stack_practice01 {
// public static void main(String[] args) {
//	Stack<Integer> s = new Stack<Integer>();
//	s.push(1);
//	s.push(2);
//	s.push(3);
//	s.push(4);
//	System.out.println(s.pop());
//	System.out.println(s.pop());
//	System.out.println(s.peek());
//	System.out.println(s.pop());
//	System.out.println(s.isEmpty());
//	System.out.println(s.pop());
//	System.out.println(s.isEmpty());
//	
//}
//}
