package divideNconquer;
// https://www.acmicpc.net/problem/10815
import java.util.*;
/* ���� �з��� ���� �����ΰɷ� ���� O(log n)�� �ð��� ����Ѱ� ������ ã�ƺ��� hash�� �ξ� �ð��� ª��.
 * hash�� �̿��ؼ� Ǯ��� �������� Ǯ�̵� �ѹ� ����غ��� 
 * */
// hashset�� hashmap ����?
// hash�� �̿��ϴ� ����?
public class _6_Numcard_Backjoon_10815 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//sol 1) using hashset  (take much shorter time than divide&conquer)
		
		 HashSet<Integer> card = new HashSet<>(); 
		 int n = sc.nextInt(); 
		 for(int i=0; i<n; i++) { 
			 int temp = sc.nextInt(); 
			 card.add(temp);
		 }
		 
		 int testcase = sc.nextInt(); 
		 for(int i=0; i<testcase; i++) { 
			 int testNum = sc.nextInt(); 
			 if(card.contains(testNum)) { 
				 System.out.print("1 "); 
			 }else {
				 System.out.print("0 "); 
			 } 
		 }
		 
		
		//sol 2) using binary_search
		
//		 int n = sc.nextInt(); 
//		 int[] cards = new int[n]; 
//		 for(int i=0; i<n; i++) {
//			 cards[i] = sc.nextInt(); 
//		 } 
//		 
//		 Arrays.sort(cards);
//		 
//		 int m = sc.nextInt(); 
//		 
//		 for(int i=0; i<m; i++) { 
//			 int testNum = sc.nextInt();
//			 boolean result = binary_search(testNum, cards); 
//			 if(result) {
//				 System.out.print("1 "); 
//			 }else { 
//				 System.out.print("0 "); 
//				 } 
//		}
		 
	}
	
	
	public static boolean binary_search(int testNum, int[] cards) {
		int n = cards.length;
		int l = 0;
		int r = n-1;
		
		while(l<=r) {
			int mid = (l+r)/2;
			if(cards[mid]==testNum) {
				return true;
			}else if(cards[mid] <testNum) {
				l = mid+1;
			}else {
				r = mid-1;
			}
		}
		return false;
	}
}
