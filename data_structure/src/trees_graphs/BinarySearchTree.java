package trees_graphs;
// �迭�� �����˻�Ʈ���� �����
// https://www.youtube.com/watch?v=9ZZbA2iPjtM&list=PLjSkJdbr_gFY8VgactUs6_Jc9Ke8cPzZP&index=8

class Tree1{
	class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data =data;
		}
	}
	Node root;
	// �迭 ������ �޾Ƽ� tree ����� ���� "����"���ִ� �޼��� 
	// -> ��� ȣ�⿡ �ʿ��� �����͸� ó������ �����ִ� ������ �Ѵ�.
	public void makeTree(int[] a) {
		root = makeTreeR(a,0,a.length-1); //��Ͱ� ������ ���� ����⿡ �ִ� root ����� �ּҸ� �޾Ƽ� ��������� �����Ѵ�.
	}
	
	// ���� : �迭, ���� �ε���, �� �ε���
	public Node makeTreeR(int[] a, int start, int end) {
		// <��� ȣ�� ��ħ ����>
		if(start > end) return null;
		
		int mid = (start + end)/2;
		Node node = new Node(a[mid]);
		node.left = makeTreeR(a, start, mid-1);
		node.right = makeTreeR(a, mid+1,end);
		
		// root ��带 ��ȯ
		return node;
		
	}
	
	// ���� : �˻��� �� ���� ���(n), ã�� ������ (find)
	public void searchBTree(Node n, int find) {
		if(find < n.data) {
			System.out.println("Data is smaller than "+n.data);
			// �� �����ϱ� ���� ��� �ּ�, find�� ��� ȣ�� �Ѵ�.
			searchBTree(n.left, find);
		}
		else if(find >n.data) {
			System.out.println("Data is bigger than "+n.data);
			searchBTree(n.right, find);
		}
		else {
			System.out.println("Data found!!");
		}
		
	}
	
}


public class BinarySearchTree {
	public static void main(String[] args) {
		int[] a = new int[10];
		for(int i=0; i<a.length; i++) {
			a[i]=i;
		}
		
		Tree1 t = new Tree1();
		t.makeTree(a);
		t.searchBTree(t.root, 2);
	}
}
