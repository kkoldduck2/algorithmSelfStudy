package divideNconquer;

import java.util.Scanner;

public class _1_BinarySearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt(); // 찾으려는 값
		int [] arr = new int [100];
		for(int i=0 ; i<arr.length; i++) {
			arr[i] = i;
		}
		
		int left = arr[0];
		int right = arr[arr.length-1];
		
		int position=-1;	//ans
		
		
		while(left<=right) {
			int mid = (left+right)/2;		// 오버플로우 발생 가능 -> left+ (right-left)/2 이렇게 바꾸는 경우도 종종있다.
			if(arr[mid]==x) {
				position = mid;
				break;
			}
			
			else if(arr[mid] < x) {
				left = mid+1;	// 존재하지 않을때 left> right 조건을 만족시키기 위해서는 이렇게 해줘야한다. 
			}else {
				right = mid-1;
			}
		}
		
		if(position>=0) {
			System.out.println("찾았다~! "+ position);
		}else {
			System.out.println("존재하지 않는다. ");
		}
	}
}
