package dinamicProgramming;
/*
 * 세준이는 어떤 정수 N에 다음과 같은 연산 중 하나를 할 수 있다.
 * 1. N이 3으로 나누어 떨어지면 3으로 나눈다
 * 2. N이 2로 나누어 떨어지면 2로 나눈다
 * 3. 1을 뺀다.
 * 
 * 세준이는 어떤 정수 N에 위와 같은 연산을 선택해서 1을 만드려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하세요 
 * 
 * */

// D(N) : N에 셋 중 하나의 연산을 선택해서 1을 만든다. 
// D(N) = MIN(D(N/3),D(N/2),D(N-1)) +1
public class Make1 {
	 
	
	// topDown -> 재귀의 형태
	public static int Make1TopDown(int[] d, int n) {
		
		if(n==1) return 0; // 1->1. 연산 필요 없음. 재귀에서는 base case
		if(d[n]>0) return d[n];	// memorization (이미 계산된 값이 있을 경우 저장된 값을 반환)
		
		d[n]=Make1TopDown(d,n-1)+1;
		if(n%2==0) {
			int temp = Make1TopDown(d,n/2)+1;
			if(d[n]>temp) {
				d[n]=temp;
			}
		}
		
		if(n%3==0) {
			int temp = Make1TopDown(d,n/3)+1;
			if(d[n]>temp) {
				d[n] = temp;
			}
		}
		return d[n];
	}
	
	// BottomUP -> for 반복문의 형태 
	public static int Make1Bottomup(int[] d,int n) {
		d[1]=0;
		for(int i=2; i<=n; i++) {
			d[i]=d[i-1]+1;
			if(i%2==0 && d[i]>d[i/2]+1) {
				d[i]= d[i/2]+1;
			}
			if(i%3==0 && d[i]>d[i/3]+1) {
				d[i]= d[i/3]+1;
			}
		}
		return d[n];
	}
	
	public static void main(String[] args) {
		int n =10;
		int [] d = new int[n+1];
		for(int i=0; i<d.length;i++) {
			d[i]=0;
		}
		int ans = Make1TopDown(d,n);
		
		int ans2= Make1Bottomup(d,n);
		System.out.println(ans+", "+ans2);
	}
}
