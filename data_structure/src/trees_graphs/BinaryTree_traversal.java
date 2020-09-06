package trees_graphs;

/*
			(1)
		      ��	         ��
		(2)		(3)
	       ��	         ��
	 (4)	(5)

Inorder (Left, Root, Right): 4 2 5 1 3
Preorder (Root, Left, Right): 1 2 4 5 3
Postorder (Left, Right, Root): 4 5 2 3 1
*/
// ��� ȣ�⿡ ���� ���� �ʿ� 
	 
// ���� Ʈ���� ���� data�� left, right �ΰ��� child node�� ������
class Node{
	int data;
	Node left;
	Node right;
}

class Tree{
	// tree�� ������ : root
	public Node root; 	
	
	// getter, setter
	public void setRoot(Node node) {
		this.root = node;
	}
	
	public Node getRoot() {
		return root;
	}
	
	// ��� ������ data�� ����, ������ ��带 �޾Ƽ� �Ҵ��Ѵ�.
	public Node makeNode(Node left, int data, Node right) {
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;
		return node;
	}
	
	// left -> root -> right ������ ���
	public void inorder(Node node) {
		// node != null  �϶����� ���ȣ�� �ݺ�
		if(node!=null) {
			inorder(node.left);	// ���� ��� ȣ���� �� ���� ���� 
			System.out.print(node.data);	// �� �ڽ��� ���
			inorder(node.right); 	// ������ ��� ȣ���� ������. 
		}
	} 
	
	// root -> left -> right
	public void preorder(Node node) {
		if(node != null) {
			System.out.print(node.data);	// �ڱ� �ڽ��� ���� ���
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
		
		// ������ ������ �����Ѵ�.  (�� ���� �׸��� �����Ѵ�. )
		Node n4 = t.makeNode(null, 4, null);
		Node n5 = t.makeNode(null, 5, null);
		Node n2 = t.makeNode(n4, 2, n5);
		Node n3 = t.makeNode(null, 3, null);
		Node n1 = t.makeNode(n2, 1, n3);	
		t.setRoot(n1);		// n1 ��带 root�� ����
		
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
