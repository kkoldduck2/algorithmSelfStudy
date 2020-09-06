package divideNconquer;

import java.util.Scanner;

public class _1_BinarySearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt(); // ã������ ��
		int [] arr = new int [100];
		for(int i=0 ; i<arr.length; i++) {
			arr[i] = i;
		}
		
		int left = arr[0];
		int right = arr[arr.length-1];
		
		int position=-1;	//ans
		
		
		while(left<=right) {
			int mid = (left+right)/2;		// �����÷ο� �߻� ���� -> left+ (right-left)/2 �̷��� �ٲٴ� ��쵵 �����ִ�.
			if(arr[mid]==x) {
				position = mid;
				break;
			}
			
			else if(arr[mid] < x) {
				left = mid+1;	// �������� ������ left> right ������ ������Ű�� ���ؼ��� �̷��� ������Ѵ�. 
			}else {
				right = mid-1;
			}
		}
		
		if(position>=0) {
			System.out.println("ã�Ҵ�~! "+ position);
		}else {
			System.out.println("�������� �ʴ´�. ");
		}
	}
}
