package study_beakjoon;

import java.util.*;

// https://www.acmicpc.net/problem/2022
// 해설) https://jennylee4517.github.io/ps/2022-%EC%82%AC%EB%8B%A4%EB%A6%AC/
public class _200820_2022_BinarySearch {
	static double getC(double x, double y, double d) {
		double h1 = Math.sqrt(x*x-d*d);
		double h2 = Math.sqrt(y*y-d*d);
		
		return h1*h2/(h1+h2);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		double c = sc.nextDouble();
		double d; 	// 우리가 구해야할 값
		
		// 입력값 중 더 큰 값을 x에 저장하겠다.
		if(y>x) {
			double temp = x;
			x=y;
			y=temp;
		}
		
		double l=0;			// d의 최소값
		double r=y;			// d의 최대값
		double newC;
		
		// 이분탐색을 통해 주어진 C와 가장 근사한 newC륾 만드는 d를 찾는다. 
		while(true) {
			d = (l+r)/2;	// d의 값을 l과 r의 중간 값으로 잡는다.
			newC = getC(x,y,d);
			
			// c-newC가 0.001미만이면 종료한다. 
			if(Math.abs(c-newC)<0.001) {
				System.out.println(d);
				break;
			}
			
			// 폭이 실제보다 좁다. --> d 증가 시켜야
			if(newC >c) {
				l=d;
			}else {
				r=d;
			}
			
		}
		
	}
}
