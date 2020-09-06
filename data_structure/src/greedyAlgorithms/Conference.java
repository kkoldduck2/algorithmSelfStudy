package greedyAlgorithms;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1931

// https://ju-nam2.tistory.com/44			(�ؼ� 1)
// https://zoonvivor.tistory.com/52			(�ؼ� 2)
// https://code0xff.tistory.com/18    <- comparator�� ���� ����
public class Conference {
	public static void main(String[] args)throws Exception {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
			 
		int n = sc.nextInt();// ȸ�� ����
		int [][] arr = new int[n][2]; // ȸ�� ���� 
		
		for(int i=0; i<n; i++) {
			arr[i][0] = sc.nextInt(); 	// ȸ�� ���� �ð�
			arr[i][1] = sc.nextInt();   // ȸ�� ���� �ð� 
		}
		
		
		// �迭 ���� (ȸ�ǽ� ������ ���Ѵ�. ���� ������ ȸ�ǰ� �տ��´�. )
		Arrays.sort(arr, new Comparator<int[]>() {
			// conference1�� conference 2 �� ���� ������ �Ÿ� �տ� ������ ���̴�.
			// conference1[0] : conference1�� ���۽ð�,   conference2[0] : conference2�� ���۽ð�
			// conference1[1] : conference1�� ������ �ð�,   conference2[1] : conference2�� ������ �ð� 
			
			@Override
			public int compare(int[] conference1, int[] conference2) {
				// ���� ����ð��� ���� ���, ���� �ð��� �������� �����Ѵ�. 
				if(conference1[1]== conference2[1]) {
					return Integer.compare(conference1[0], conference2[0]);
				}
				// (�⺻������) ����ð��� ���� �����Ѵ�. 
				return Integer.compare(conference1[1], conference2[1]);
			}
			
			/*
			 * Integer.compare(int x, int y)
			 * x == y �� ��� 0 ����
			 * x < y �� ��� ���� ����
			 * x > y �� ��� ��� ����
			 */			
		});
		
		int cnt =0;			// �ִ� (ans)
		int endTime = -1; 	// ������ �ð� 
		for(int i=0; i<n ;i++) {
			
			// ������ �ð����� ȸ�� ���� �ð��� �� �ڿ� ���� ��� -> �� ȸ�Ǹ� ���������� �д�
			if(endTime <= arr[i][0]) {
				endTime = arr[i][0];
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
	}
}
