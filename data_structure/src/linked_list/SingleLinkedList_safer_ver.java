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
		// 새로운 노드를 생성 (맨마지막에 넣을거니까 end라고 명명한다)
		ListNode end = new ListNode();
		end.data = data;
		
		// 포인터 생성 (첫번째 노드를 가리키는)
		ListNode n = header;
		
		// 마지막 노드를 찾기 
		while(n.next!=null) {
			n=n.next;
		}
		
		//while문을 빠져 나오는 순간, n= 마지막 노드가 됨
		//따라서 n.next 에 새로 생성한 노드(end)를 넣어주면 된다.
		n.next= end;
	}
	
	// 2) 삭제 (삭제할 값을 매개변수로 받는다)
	void delete(int data){
		// 임의의 포인터 생성 (젤 처음 노드를 가리키는)
		// -> 이걸 시작점으로 노드들을 돌면서 '삭제할 노드'를 찾는다
		ListNode n = header;
		
		while(n.next !=null) {
			// 덧) n.next== null이 되는 순간 while문 빠져나옴
			// 마지막 노드 이전까지만 실행한다. (마지막에서 두번째 노드)
			// 그래서 n.data가 아니라 n.next.data 이렇게 찾는거임
			// 질문) 찾고자하는 노드가 첫번째이면 어떻게됨?
			// 대답) 헤더는 값을 가진 노드이기 전에 이 LinkedList를 대표하는 첫번째 노드이기 때문에
			// 		만약 그냥 지우면 다른 Object가 삭제된 헤더를 갖고 있는 경우 문제가 발생한다.
			//		그래서 현재는 첫번째 노드는 삭제를 못하게 만들어 놓고 다음시간에 이에 대해 다루겠다.
			//		=> 이제 header는 데이터가 없고 해당 linkedlist를 가리키는 용도이기 떄문에 이 걱정 안해도 된다.
			if(n.next.data == data) {
				n.next= n.next.next; // 해당 data를 갖고 있는 노드를 건너 뛰고 그 다음 노드와 연결
			}else {
				n = n.next; // 찾는 노드가 아니면 그 다음 노드로 이동
			}
		}
	}
	
	// 3) 현재 LinkedList에 어떤 값들이 있는지 나열해서 확인
	void retrieve() {
		ListNode n = header.next; // 포인터 
		while(n.next!=null) {
			System.out.print(n.data+" => ");
			n = n.next; // 마지막 노드를 출력 안하고 while문 빠져나옴
		}
		// 그래서 마지막 노드 출력을 따로 해준다.
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
		ll.delete(1);	// 가장 첫번째 데이터를 삭제해봄 (이전에 했던거로는 불가능, 현재는 가능)
		ll.retrieve();
	}
}
