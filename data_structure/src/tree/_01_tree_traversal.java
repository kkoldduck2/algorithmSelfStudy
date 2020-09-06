package tree;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1991
// 이진 트리 순회 --> 순서대로 출력하시오 
/*
 * A[i][0] : i의 왼쪽 자식
 * A[i][1] : i의 오른쪽 자식
 * 
 * */

public class _01_tree_traversal {
	public static void preorder(int[][] a, int x) {
		if(x==-1) return;
		System.out.println((char)(x+'A'));	// 노드(부모) 먼저 출력
		preorder(a, a[x][0]); 	// 그 후 왼쪽 자식 서브트리 프리오더
		preorder(a, a[x][1]);	// 그 후 오른쪽 자식 서브트리 프리오더 
	}
	
	public static void inorder(int[][] a, int x) {
		if(x==-1) return;
		
		inorder(a, a[x][0]); 
		System.out.println((char)(x+'A'));
		inorder(a, a[x][1]);
	}
	
	public static void postorder(int[][] a, int x) {
		if(x==-1) return;
		
		postorder(a, a[x][0]); // 왼쪽 자식 서브트리 프리오더
		postorder(a, a[x][1]);
		System.out.println((char)(x+'A'));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		// 이진 트리 노드의 개수  (1<= n <=26)
		int[][] a = new int[26][2];	// 트리를 배열 형태로 저장 할 거임 
		
		sc.nextLine();	// 엔터 제거 
		
		// 트리에 저장 
		for(int i=0; i<n ;i++) {
			String line  = sc.nextLine();
			int x = line.charAt(0) -'A';	// 부모 노드가 . 일리 없으므로
			char y = line.charAt(2);		// 자식노드는 . 일 수 있음
			char z = line.charAt(4);
			
			if(y=='.') {
				a[x][0] = -1;	// 자식이 없으면 -1 저장
			} else {
				a[x][0] = y-'A';
			}
			if(z=='.') {
				a[x][1] = -1;
			} else {
				a[x][1]= z-'A';
			}
		}
		
		preorder(a,0); // 루트(0) 부터 시작
		System.out.println();
		inorder(a,0);
		System.out.println();
		postorder(a,0);
		System.out.println();
		
	}
}
