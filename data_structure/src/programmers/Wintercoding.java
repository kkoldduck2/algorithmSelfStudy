package programmers;



public class Wintercoding {
	public int[] solution(int n) {
		int[] answer = {};
	      int[] temp = new int[(int) Math.pow(2, n-1)];
	      int next=0;
	      for(int i=0; i<answer.length; i++){
	          temp[i]=next;
	          if(next==0){
	              next=1;
	          }else if(next==1){
	              next=0;
	          }
	      }
	      
	      recur(n-1,answer.length, temp);
	     
	      return answer;
	  }
	
	public int[] recur(int n, double size2, int[] arr) {
		double size = size2 + Math.pow(2, n-1);
		int[] newArr= new int[(int) size];
		if(n==1) {
			//정 가운데에 0을 추가한다.
			for(int i=0; i<newArr.length; i++) {
				if(i==size/2) {
					newArr[i]=0;
				}
						
			}
			return newArr;
		}
		else {
			// new Arr에 무언가를 담는다
			// 기존 배열(arr)의 0과 1사이에 0,1을 순서대로 넣는다
			int next=0;
			for(int i=0; i<newArr.length; i++) {
				for(int j=0; j<arr.length; j++) {
					if(arr[j]==0) {
						newArr[j+1]=next;
						if(next==1) {
							next=0;
						}else if(next==0) {
							next=1;
						}
					}
					if(i==j) {
						newArr[j]=arr[i];
					}
				}
				
			}
			
			
			return recur(n-1, size, newArr);
		}
	}
	
	
	public static void main(String[] args) {
		
	}
}
