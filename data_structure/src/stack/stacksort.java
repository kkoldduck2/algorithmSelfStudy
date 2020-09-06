package stack;
import java.util.Stack;

// stack�� �����ϴ� �Լ��� ����ÿ�
// ��, �ϳ��� stack�� �߰��� ����� �� �ְ�, Array �� �ٸ� ������ ������ ����� �� ����
public class stacksort {
	public static void main(String[] args) {
		Stack<Integer> s1 = new Stack<Integer>();
		s1.push(3);
		s1.push(5);
		s1.push(1);
		s1.push(6);
		sort(s1);
		
		while(!s1.isEmpty()) {
			System.out.println(s1.pop());
		}
		
	}
	
	private static void sort(Stack<Integer> s1) {
		Stack<Integer> s2 = new Stack<Integer>();
		
		while(!s1.isEmpty()) {
			int temp = s1.pop();
			
			// s2���� temp���� ������ ���� ������ �ݺ�
			while(!s2.isEmpty() && s2.peek() > temp) {
				s1.push(s2.pop());
			}
			// ���� ������ ����!
			s2.push(temp);
		}
		
		// ù��° ������ �� ���� ������� 
		// ���� s2���� s1���� ��� �ű� ����
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	
	
	
}
