package linked_list;
// 단방향 LinkedList

// Node 클래스로 구현
// Node 클래스는 취약하다
// header가 첫번째 값이면서 이 linkedlist의 대표이기도함
// 따라서 header를 삭제하고, 어떤 object가 아직 이 header의 포인터를 갖고 있는 경우 문제가 생김
// => Node클래스를 LinkedList라는 클래스로 감싸서 
//	  LinkedList의 header를 data가 아닌, list의 시작을 알려주는 용도로만 저장
//	   그안에 노드 클래스를 만드는것
class ListNode{
	int data;  	// 일반적으로 object 여기선 편하게 int형으로 한다
	ListNode next = null;
	ListNode(int d){
		this.data = d;
	}
	
	// 1) 추가
	void append(int data) {
		// 새로운 노드를 생성 (맨마지막에 넣을거니까 end라고 명명한다)
		ListNode end = new ListNode(data);
		
		// 포인터 생성 (첫번째 노드를 가리키는)
		ListNode n = this;
		
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
		ListNode n = this;
		
		while(n.next !=null) {
			// 덧) n.next== null이 되는 순간 while문 빠져나옴
			// 마지막 노드 이전까지만 실행한다. (마지막에서 두번째 노드)
			// 그래서 n.data가 아니라 n.next.data 이렇게 찾는거임
			// 질문) 찾고자하는 노드가 첫번째이면 어떻게됨?
			// 대답) 헤더는 값을 가진 노드이기 전에 이 LinkedList를 대표하는 첫번째 노드이기 때문에
			// 		만약 그냥 지우면 다른 Object가 삭제된 헤더를 갖고 있는 경우 문제가 발생한다.
			//		그래서 현재는 첫번째 노드는 삭제를 못하게 만들어 놓고 다음시간에 이에 대해 다루겠다.
			if(n.next.data == data) {
				n.next= n.next.next; // 해당 data를 갖고 있는 노드를 건너 뛰고 그 다음 노드와 연결
			}else {
				n = n.next; // 찾는 노드가 아니면 그 다음 노드로 이동
			}
		}
	}
	
	// 3) 현재 LinkedList에 어떤 값들이 있는지 나열해서 확인
	void retrieve() {
		ListNode n = this; // 포인터 
		while(n.next!=null) {
			System.out.print(n.data+" => ");
			n = n.next; // 마지막 노드를 출력 안하고 while문 빠져나옴
		}
		// 그래서 마지막 노드 출력을 따로 해준다.
		System.out.println(n.data);
	}
}


public class SinglyLinkedList {
	
	public static void main(String[] args) {
		// head Node 생성 
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
