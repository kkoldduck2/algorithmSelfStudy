package trees_graphs;
// 배열을 이진검색트리로 만들기
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
	// 배열 정보를 받아서 tree 만드는 일을 "시작"해주는 메서드 
	// -> 재귀 호출에 필요한 데이터를 처음으로 던져주는 역할을 한다.
	public void makeTree(int[] a) {
		root = makeTreeR(a,0,a.length-1); //재귀가 끝나면 가장 꼭대기에 있는 root 노드의 주소를 받아서 멤버변수에 저장한다.
	}
	
	// 인자 : 배열, 시작 인덱스, 끝 인덱스
	public Node makeTreeR(int[] a, int start, int end) {
		// <재귀 호출 마침 조건>
		if(start > end) return null;
		
		int mid = (start + end)/2;
		Node node = new Node(a[mid]);
		node.left = makeTreeR(a, start, mid-1);
		node.right = makeTreeR(a, mid+1,end);
		
		// root 노드를 반환
		return node;
		
	}
	
	// 인자 : 검색을 할 시작 노드(n), 찾을 데이터 (find)
	public void searchBTree(Node n, int find) {
		if(find < n.data) {
			System.out.println("Data is smaller than "+n.data);
			// 더 작으니까 왼쪽 노드 주소, find로 재귀 호출 한다.
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
