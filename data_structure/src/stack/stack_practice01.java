package stack;

import java.util.EmptyStackException;
//
//class Stack<T> {
//	class Node<T> {
//		private T data;
//		private Node<T> next; 	// 다음 node의 주소 
//		
//		// node 생성자 (생성시 인자로 data 받는다)
//		public Node(T data){
//			this.data = data;
//		}
//	}
//	
//	// 멤버변수 : stack은 맨 위에 있는 주소만 알고 있으면 된다.
//	private Node<T> top;
//	
//	// 함수 구현
//	// 가장 위에있는 노드(의 데이터)를 가져오는 함수
//	public T pop() {
//		if(top == null) {
//			throw new EmptyStackException();
//		}
//		
//		// step 0. 현재 top에 있는 data 백업
//		T item = top.data;
//		
//		// step 1. top에 있는 data 백업 후, top 다음에 있는 노드를 top으로 바꾼다.
//		top = top.next;
//		
//		// step 2. item 리턴
//		return item;
//	}
//	
//	// 데이터 추가 함수
//	public void push(T item) {
//		//step 1.  받아온 아이템 -> 노드 생성
//		Node<T> t = new Node<T>(item);
//		
//		//step 2. 기존 top 앞에 새로운 노드를 위치시킨다. 이제 새로운 노드가 top이다 
//		t.next = top;
//		top = t;
//	}
//	
//	// 데이터 엿보기 함수 
//	public T peek() {
//		// null 체크
//		if(top == null) {
//			throw new EmptyStackException();
//		}
//		
//		return top.data;
//	}
//	
//	public boolean isEmpty() {
//		// top이 널인지를 보내면 된다.
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
