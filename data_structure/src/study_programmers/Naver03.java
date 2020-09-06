package study_programmers;

public class Naver03 {
	static int MaxAns=0;
	public static void main(String[] args) {
		// 3곳을 고치는 경우의 수 (조합) 0 개수 x이라 하면 xC3
		// 고쳤을떄 가장 긴 도로구간의 길이 0과 0 사이 1의 개수 중에 가장 긴거 
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
		if(n==0) {	// n개 다 고침 
			// 이 때 가장 긴 도로 구간의 길이 구하기 
			int max = findMaxLength(road);
			MaxAns = MaxAns < max ? max :  MaxAns;
			return;
			
		}
		
		// n개 모두 고치지 않았지만 이미 road가 다 고쳐진 경우 
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
