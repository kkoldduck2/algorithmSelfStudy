package dinamicProgramming;
// https://www.acmicpc.net/problem/2011

/*어떤 암호가 주어졌을 때, 그 암호의 해석이 몇 가지가 나올 수 있는지 구하는 프로그램을 작성하시오.*/
// A를 1이라고 하고, B는 2로, 그리고 Z는 26으로 하는거야.
import java.util.*;
import java.math.*;

public class SecretCode {
	public static int mod = 1000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine().trim();
		int n = s.length();
		s = " " + s; //???
		
		int[] d = new int[n+1];
		
		// d[i] : i번째 문자까지 해석했을때, 나올 수 있는 해석의 가짓수 
		// i번째 문자에게 가능한 경우 
		// 1자리 암호 -> 0 아니어야
		// 2자리 암호 -> 10<=x<=26
		d[0] =1;

		
		for(int i=1; i<=n ; i++) {
			int x = s.charAt(i)-'0'; // ascii 문자 -> '0'을 빼줌으로써 숫자로 변환,  s[i] = s.charAt(i)
			// ??? 를 안해주면 s.charAt(i-1)로 바꿔야한다. 실제로 0부터 시작해서 i-1번째 인덱스에 있으니까 
			// 여기서 i는 d[] 기준이다. 
			
			// 1) 한 자리일 경우 
			if(x>=1 && x<=9) {
				d[i] = d[i-1];
				d[i] %=mod;
			}
			
			if(i==1) continue;	 // 첫번째 문자 -> 그 앞에 아무 문자 없음 -> 한자리 (두자리 불가 )
			if(s.charAt(i-1)=='0') continue;  // 현재 문자의 앞자리가 0 -> 두자리 불가 
			
			// 2) 두 자리일 경우
			x = (s.charAt(i-1)-'0')*10+ (s.charAt(i)-'0');
			if(x>=10 && x<=26) {
				d[i] += d[i-2];
				d[i] %= mod;
			}
		}
		
		System.out.println(d[n]);
		
		
	}
}
