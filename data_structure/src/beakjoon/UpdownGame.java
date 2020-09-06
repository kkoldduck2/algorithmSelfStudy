package beakjoon;

import java.util.Scanner;

public class UpdownGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int x = (int)(Math.random()*100) +1;
		int k = 0;
		
		int cnt=0;
		for(int i=0; i<6; i++) {
			cnt++;
			int l= 6-i;
			System.out.println("남은 횟수는 "+l+"회 입니다");
			System.out.println("숫자를 입력하세요");
			k = sc.nextInt();
			if(k==x) {
				System.out.println("정답입니다! : "+ x);
				break;
			}else {
				if(k>x) {
					System.out.println("다운");
				}else {
					System.out.println("업");
				}
			}
		}
		
		if(cnt==10) {
			System.out.println("실패!");
		}
		
	}
}
