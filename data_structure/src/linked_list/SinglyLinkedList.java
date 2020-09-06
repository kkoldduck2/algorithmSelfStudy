package linked_list;
// �ܹ��� LinkedList

// Node Ŭ������ ����
// Node Ŭ������ ����ϴ�
// header�� ù��° ���̸鼭 �� linkedlist�� ��ǥ�̱⵵��
// ���� header�� �����ϰ�, � object�� ���� �� header�� �����͸� ���� �ִ� ��� ������ ����
// => NodeŬ������ LinkedList��� Ŭ������ ���μ� 
//	  LinkedList�� header�� data�� �ƴ�, list�� ������ �˷��ִ� �뵵�θ� ����
//	   �׾ȿ� ��� Ŭ������ ����°�
class ListNode{
	int data;  	// �Ϲ������� object ���⼱ ���ϰ� int������ �Ѵ�
	ListNode next = null;
	ListNode(int d){
		this.data = d;
	}
	
	// 1) �߰�
	void append(int data) {
		// ���ο� ��带 ���� (�Ǹ������� �����Ŵϱ� end��� ����Ѵ�)
		ListNode end = new ListNode(data);
		
		// ������ ���� (ù��° ��带 ����Ű��)
		ListNode n = this;
		
		// ������ ��带 ã�� 
		while(n.next!=null) {
			n=n.next;
		}
		
		//while���� ���� ������ ����, n= ������ ��尡 ��
		//���� n.next �� ���� ������ ���(end)�� �־��ָ� �ȴ�.
		n.next= end;
	}
	
	// 2) ���� (������ ���� �Ű������� �޴´�)
	void delete(int data){
		// ������ ������ ���� (�� ó�� ��带 ����Ű��)
		// -> �̰� ���������� ������ ���鼭 '������ ���'�� ã�´�
		ListNode n = this;
		
		while(n.next !=null) {
			// ��) n.next== null�� �Ǵ� ���� while�� ��������
			// ������ ��� ���������� �����Ѵ�. (���������� �ι�° ���)
			// �׷��� n.data�� �ƴ϶� n.next.data �̷��� ã�°���
			// ����) ã�����ϴ� ��尡 ù��°�̸� ��Ե�?
			// ���) ����� ���� ���� ����̱� ���� �� LinkedList�� ��ǥ�ϴ� ù��° ����̱� ������
			// 		���� �׳� ����� �ٸ� Object�� ������ ����� ���� �ִ� ��� ������ �߻��Ѵ�.
			//		�׷��� ����� ù��° ���� ������ ���ϰ� ����� ���� �����ð��� �̿� ���� �ٷ�ڴ�.
			if(n.next.data == data) {
				n.next= n.next.next; // �ش� data�� ���� �ִ� ��带 �ǳ� �ٰ� �� ���� ���� ����
			}else {
				n = n.next; // ã�� ��尡 �ƴϸ� �� ���� ���� �̵�
			}
		}
	}
	
	// 3) ���� LinkedList�� � ������ �ִ��� �����ؼ� Ȯ��
	void retrieve() {
		ListNode n = this; // ������ 
		while(n.next!=null) {
			System.out.print(n.data+" => ");
			n = n.next; // ������ ��带 ��� ���ϰ� while�� ��������
		}
		// �׷��� ������ ��� ����� ���� ���ش�.
		System.out.println(n.data);
	}
}


public class SinglyLinkedList {
	
	public static void main(String[] args) {
		// head Node ���� 
		ListNode head = new ListNode(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.retrieve();
		head.delete(2);
		head.delete(3);
		head.retrieve();
		
		
	}
}
