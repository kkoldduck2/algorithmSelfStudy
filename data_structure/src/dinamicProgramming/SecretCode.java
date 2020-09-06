package dinamicProgramming;
// https://www.acmicpc.net/problem/2011

/*� ��ȣ�� �־����� ��, �� ��ȣ�� �ؼ��� �� ������ ���� �� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.*/
// A�� 1�̶�� �ϰ�, B�� 2��, �׸��� Z�� 26���� �ϴ°ž�.
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
		
		// d[i] : i��° ���ڱ��� �ؼ�������, ���� �� �ִ� �ؼ��� ������ 
		// i��° ���ڿ��� ������ ��� 
		// 1�ڸ� ��ȣ -> 0 �ƴϾ��
		// 2�ڸ� ��ȣ -> 10<=x<=26
		d[0] =1;

		
		for(int i=1; i<=n ; i++) {
			int x = s.charAt(i)-'0'; // ascii ���� -> '0'�� �������ν� ���ڷ� ��ȯ,  s[i] = s.charAt(i)
			// ??? �� �����ָ� s.charAt(i-1)�� �ٲ���Ѵ�. ������ 0���� �����ؼ� i-1��° �ε����� �����ϱ� 
			// ���⼭ i�� d[] �����̴�. 
			
			// 1) �� �ڸ��� ��� 
			if(x>=1 && x<=9) {
				d[i] = d[i-1];
				d[i] %=mod;
			}
			
			if(i==1) continue;	 // ù��° ���� -> �� �տ� �ƹ� ���� ���� -> ���ڸ� (���ڸ� �Ұ� )
			if(s.charAt(i-1)=='0') continue;  // ���� ������ ���ڸ��� 0 -> ���ڸ� �Ұ� 
			
			// 2) �� �ڸ��� ���
			x = (s.charAt(i-1)-'0')*10+ (s.charAt(i)-'0');
			if(x>=10 && x<=26) {
				d[i] += d[i-2];
				d[i] %= mod;
			}
		}
		
		System.out.println(d[n]);
		
		
	}
}
