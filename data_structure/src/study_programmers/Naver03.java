package study_programmers;

public class Naver03 {
	static int MaxAns=0;
	public static void main(String[] args) {
		// 3���� ��ġ�� ����� �� (����) 0 ���� x�̶� �ϸ� xC3
		// �������� ���� �� ���α����� ���� 0�� 0 ���� 1�� ���� �߿� ���� ��� 
		// test case 1
		String road = "111011110011111011111100011111";
		int n = 3;
		
		// test case 2
//		String road = "001100";
//		int n = 5;
		
		repair(road, n);
		System.out.println(MaxAns);
	}
	
	static void repair(String road, int n) {
		if(n==0) {	// n�� �� ��ħ 
			// �� �� ���� �� ���� ������ ���� ���ϱ� 
			int max = findMaxLength(road);
			MaxAns = MaxAns < max ? max :  MaxAns;
			return;
			
		}
		
		// n�� ��� ��ġ�� �ʾ����� �̹� road�� �� ������ ��� 
		if(allFixed(road)) {
			int max = road.length();
			MaxAns = MaxAns < max ? max :  MaxAns;
			return;
		}
		
		for(int i=0; i<road.length(); i++) {
			String road2;
			if(road.charAt(i)=='0') {
				if(i==0) {
					road2 = '1'+road.substring(1,road.length());
				}else if(i==road.length()){
					road2 = road.substring(0,road.length()-1)+'1';
				}else {
					road2 = road.substring(0,i)+'1'+road.substring(i+1,road.length());
				}
				
				repair(road2, n-1);
			}
			
		}
	}
	
	static int findMaxLength(String road) {
		int max =0;
		int length=0;
		for(int i=0; i<road.length(); i++) {
			if(road.charAt(i)=='1') {
				length++;
				max = max < length ? length : max;
			}else {
				length=0;
			}
		}
		return max;
	}
	
	static boolean allFixed(String road) {
		
		for(int i=0; i< road.length(); i++) {
			if(road.charAt(i)=='0') {
				return false;
			}
		}
		return true;
	}
}
