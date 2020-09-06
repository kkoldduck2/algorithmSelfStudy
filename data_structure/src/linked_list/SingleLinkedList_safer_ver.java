package linked_list;

class LinkedList{
	ListNode header;
	
	static class ListNode{
		int data;
		ListNode next = null;
	}
	
	LinkedList(){
		header = new ListNode();
	}
	
	void append(int data) {
		// ���ο� ��带 ���� (�Ǹ������� �����Ŵϱ� end��� ����Ѵ�)
		ListNode end = new ListNode();
		end.data = data;
		
		// ������ ���� (ù��° ��带 ����Ű��)
		ListNode n = header;
		
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
		ListNode n = header;
		
		while(n.next !=null) {
			// ��) n.next== null�� �Ǵ� ���� while�� ��������
			// ������ ��� ���������� �����Ѵ�. (���������� �ι�° ���)
			// �׷��� n.data�� �ƴ϶� n.next.data �̷��� ã�°���
			// ����) ã�����ϴ� ��尡 ù��°�̸� ��Ե�?
			// ���) ����� ���� ���� ����̱� ���� �� LinkedList�� ��ǥ�ϴ� ù��° ����̱� ������
			// 		���� �׳� ����� �ٸ� Object�� ������ ����� ���� �ִ� ��� ������ �߻��Ѵ�.
			//		�׷��� ����� ù��° ���� ������ ���ϰ� ����� ���� �����ð��� �̿� ���� �ٷ�ڴ�.
			//		=> ���� header�� �����Ͱ� ���� �ش� linkedlist�� ����Ű�� �뵵�̱� ������ �� ���� ���ص� �ȴ�.
			if(n.next.data == data) {
				n.next= n.next.next; // �ش� data�� ���� �ִ� ��带 �ǳ� �ٰ� �� ���� ���� ����
			}else {
				n = n.next; // ã�� ��尡 �ƴϸ� �� ���� ���� �̵�
			}
		}
	}
	
	// 3) ���� LinkedList�� � ������ �ִ��� �����ؼ� Ȯ��
	void retrieve() {
		ListNode n = header.next; // ������ 
		while(n.next!=null) {
			System.out.print(n.data+" => ");
			n = n.next; // ������ ��带 ��� ���ϰ� while�� ��������
		}
		// �׷��� ������ ��� ����� ���� ���ش�.
		System.out.println(n.data);
	}
}


public class SingleLinkedList_safer_ver {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.retrieve();
		ll.delete(1);	// ���� ù��° �����͸� �����غ� (������ �ߴ��ŷδ� �Ұ���, ����� ����)
		ll.retrieve();
	}
}
