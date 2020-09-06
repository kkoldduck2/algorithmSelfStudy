package recursion;

import java.util.Scanner;

public class Backjoon_1914 {
	public static int hanoi(int n) {
		if(n==1) {
			return 1;
		} else {
			return 2*hanoi(n-1)+1;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("개수를 입력 >");
		int number = sc.nextInt();
		System.out.println(hanoi(number));
	}
}
