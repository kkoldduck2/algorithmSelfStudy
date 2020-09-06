package dinamicProgramming;

// https://www.acmicpc.net/problem/2156

/* 효주는 포도주 시식회에 갔다. 그 곳에 갔더니, 테이블 위에 다양한 포도주가 들어있는 포도주 잔이 일렬로 놓여 있었다. 
 * 효주는 포도주 시식을 하려고 하는데, 여기에는 다음과 같은 두 가지 규칙이 있다.

포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
효주는 될 수 있는 대로 많은 양의 포도주를 맛보기 위해서 어떤 포도주 잔을 선택해야 할지 고민하고 있다. 
1부터 n까지의 번호가 붙어 있는 n개의 포도주 잔이 순서대로 테이블 위에 놓여 있고, 각 포도주 잔에 들어있는 포도주의 양이 주어졌을 때, 
효주를 도와 가장 많은 양의 포도주를 마실 수 있도록 하는 프로그램을 작성하시오.
 * 
 * 
 * */
public class DrinkingWine {
	public static void main(String[] args) {
		int[] A = new int[] {6, 10, 13, 9, 8, 1};
		int n= 6;
		int[] D = new int[n+1];
		
		
		D[1] = A[0];
		D[2] = A[0]+A[1];
		
		for(int i=3; i<=n; i++) {
			D[i] = A[i-1]+ A[i-2] + D[i-3];
			
			int temp = A[i-1] + D[i-2];
			if (temp > D[i]) D[i] = temp;
			
			int temp2 = D[i-1];
			if(temp2 >D[i]) D[i] = temp2;
		}
		
		System.out.println(D[n]);
	}
}
