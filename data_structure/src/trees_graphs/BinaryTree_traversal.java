package trees_graphs;

/*
			(1)
		      ↙	         ↘
		(2)		(3)
	       ↙	         ↘
	 (4)	(5)

Inorder (Left, Root, Right): 4 2 5 1 3
Preorder (Root, Left, Right): 1 2 4 5 3
Postorder (Left, Right, Root): 4 5 2 3 1
*/
// 재귀 호출에 대한 이해 필요 
	 
// 이진 트리의 노드는 data와 left, right 두개의 child node를 가진다
class Node{
	int data;
	Node left;
	Node right;
}

class Tree{
	// tree의 시작점 : root
	public Node root; 	
	
	// getter, setter
	public void setRoot(Node node) {
		this.root = node;
	}
	
	public Node getRoot() {
		return root;
	}
	
	// 노드 생성시 data와 왼쪽, 오른쪽 노드를 받아서 할당한다.
	public Node makeNode(Node left, int data, Node right) {
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;
		return node;
	}
	
	// left -> root -> right 순으로 출력
	public void inorder(Node node) {
		// node != null  일때까지 재귀호출 반복
		if(node!=null) {
			inorder(node.left);	// 왼쪽 재귀 호출을 다 돌고 오면 
			System.out.print(node.data);	// 나 자신을 출력
			inorder(node.right); 	// 오른쪽 재귀 호출을 돌린다. 
		}
	} 
	
	// root -> left -> right
	public void preorder(Node node) {
		if(node != null) {
			System.out.print(node.data);	// 자기 자신을 먼저 출력
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	// left -> right -> root
	public void postorder(Node node) {
		if(node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data);
		}
	}
}

public class BinaryTree_traversal {
	public static void main(String[] args) {
		Tree t = new Tree();
		
		// 마지막 노드부터 생성한다.  (맨 위의 그림을 참고한다. )
		Node n4 = t.makeNode(null, 4, null);
		Node n5 = t.makeNode(null, 5, null);
		Node n2 = t.makeNode(n4, 2, n5);
		Node n3 = t.makeNode(null, 3, null);
		Node n1 = t.makeNode(n2, 1, n3);	
		t.setRoot(n1);		// n1 노드를 root로 지정
		
		System.out.print("Inorder >> ");
		t.inorder(t.getRoot());
		
		System.out.println();
		System.out.print("Preorder >> ");
		t.preorder(t.getRoot());
		
		System.out.println();
		System.out.print("Postorder >> ");
		t.postorder(t.getRoot());
		
	}
}
