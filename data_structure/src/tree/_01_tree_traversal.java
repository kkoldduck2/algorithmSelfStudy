package tree;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1991
// ���� Ʈ�� ��ȸ --> ������� ����Ͻÿ� 
/*
 * A[i][0] : i�� ���� �ڽ�
 * A[i][1] : i�� ������ �ڽ�
 * 
 * */

public class _01_tree_traversal {
	public static void preorder(int[][] a, int x) {
		if(x==-1) return;
		System.out.println((char)(x+'A'));	// ���(�θ�) ���� ���
		preorder(a, a[x][0]); 	// �� �� ���� �ڽ� ����Ʈ�� ��������
		preorder(a, a[x][1]);	// �� �� ������ �ڽ� ����Ʈ�� �������� 
	}
	
	public static void inorder(int[][] a, int x) {
		if(x==-1) return;
		
		inorder(a, a[x][0]); 
		System.out.println((char)(x+'A'));
		inorder(a, a[x][1]);
	}
	
	public static void postorder(int[][] a, int x) {
		if(x==-1) return;
		
		postorder(a, a[x][0]); // ���� �ڽ� ����Ʈ�� ��������
		postorder(a, a[x][1]);
		System.out.println((char)(x+'A'));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		// ���� Ʈ�� ����� ����  (1<= n <=26)
		int[][] a = new int[26][2];	// Ʈ���� �迭 ���·� ���� �� ���� 
		
		sc.nextLine();	// ���� ���� 
		
		// Ʈ���� ���� 
		for(int i=0; i<n ;i++) {
			String line  = sc.nextLine();
			int x = line.charAt(0) -'A';	// �θ� ��尡 . �ϸ� �����Ƿ�
			char y = line.charAt(2);		// �ڽĳ��� . �� �� ����
			char z = line.charAt(4);
			
			if(y=='.') {
				a[x][0] = -1;	// �ڽ��� ������ -1 ����
			} else {
				a[x][0] = y-'A';
			}
			if(z=='.') {
				a[x][1] = -1;
			} else {
				a[x][1]= z-'A';
			}
		}
		
		preorder(a,0); // ��Ʈ(0) ���� ����
		System.out.println();
		inorder(a,0);
		System.out.println();
		postorder(a,0);
		System.out.println();
		
	}
}
