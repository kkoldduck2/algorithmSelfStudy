package programmers;

import java.util.ArrayList;
import java.util.Arrays;


class SolutionBrute {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] as1 = new int[answers.length];
        int[] as2 = new int[answers.length];
        int[] as3 = new int[answers.length];
        
        // 각자의 방식대로 배열을 담음
        // 수포자 1의 정답sheet(5개씩 반복)
        for(int i=0; i<answers.length; i++){
            int n = (i+1)%6;
            as1[i]=n;
        }
        // 수포자 2의 정답sheet (8개씩 반복)
        for(int i=0; i<answers.length; i++){
            int[] select = {1,3,4,5};
            if((i+1)%2==1){
                as2[i]=2;
            }else{
                if(i%8==1) as2[i]=select[0];
                if(i%8==3) as2[i]=select[1];
                if(i%8==5) as2[i]=select[2];
                if(i%8==7) as2[i]=select[3];
            }
        }
        // 수포자 3의 정답sheet  (10개씩 반복)
        for(int i =0; i<answers.length; i++){
            int k = (i%10);
            int[] select = {3,1,2,4,5};
            
            if(k<2) as3[i] = select[0];
            else if(k<4) as3[i] = select[1];
            else if(k<6) as3[i] = select[2];
            else if(k<8) as3[i] = select[3];
            else if(k<10) as3[i] = select[4];
            
        }
        
        // 채점 -> 비교 -> 
        // 1) 가장 많이 맞춘 사람 반환 (1명일 경우)
        // 2) 점수가 동일 할 경우 동일 점수인 사람들 모두 반환
        
        int[][] result = {
        				  {1, checkAnswer(answers, as1)},
        				  {2, checkAnswer(answers, as2)},
        				  {3, checkAnswer(answers, as3)}
        				  };
        

        // 가장 점수가 높은 사람 반환
        Arrays.sort(bestScore(result));
        answer = bestScore(result);
        return answer;
    }
    
    // 맞은 개수 반환
    public int checkAnswer(int[] rightAns, int[] checking) {
    	int cnt=0;
    	for(int i=0; i<rightAns.length; i++) {
        	if(rightAns[i]==checking[i]) {
        		cnt++;
        	}
        }
    	return cnt;
    }
    
    public int[] bestScore(int[][] result) {
    	ArrayList<Integer> li = new ArrayList<Integer>();
    	int best=0;
    	
    	// 최대값 구하기 (best score 구하기 )
    	for(int i=1; i<3; i++) {
    		if(result[best][1]<result[i][1]) {
    			best= i;
    		} 
    	}
    	System.out.println("현재 best는?"+best+", 스코어: "+result[best][1]);
    	
    	
    	// 다 돌고나면 best가 뽑혔을 것 이제 이거랑 같은 얘들만 찾으면 된다. 
    	for(int i=0; i<3; i++) {
    		if(result[i][1]==result[best][1]) {
    			li.add(i);
    		}
    	}
    	
    	// arraylist를 array로 변환
    	int[] answer = new int[li.size()];
    	int size =0;
    	for(Integer temp : li) {
    		answer[size++]= temp+1;
    	}
    	
    	return answer;
    	
    }
    
}



public class BruteForceSearch_mockTest {
	public static void main(String[] args) {
		SolutionBrute sb = new SolutionBrute();
		
		int[] answers1 = {1,2,3,4,5};
		int[] answers2 = {1,3,2,4,2};
		System.out.println("1번 예제: "+Arrays.toString(sb.solution(answers1)));
		System.out.println("2번 예제: "+Arrays.toString(sb.solution(answers2)));
	}
}
