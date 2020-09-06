package programmers;

import java.util.ArrayList;
import java.util.Arrays;


class SolutionBrute {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] as1 = new int[answers.length];
        int[] as2 = new int[answers.length];
        int[] as3 = new int[answers.length];
        
        // ������ ��Ĵ�� �迭�� ����
        // ������ 1�� ����sheet(5���� �ݺ�)
        for(int i=0; i<answers.length; i++){
            int n = (i+1)%6;
            as1[i]=n;
        }
        // ������ 2�� ����sheet (8���� �ݺ�)
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
        // ������ 3�� ����sheet  (10���� �ݺ�)
        for(int i =0; i<answers.length; i++){
            int k = (i%10);
            int[] select = {3,1,2,4,5};
            
            if(k<2) as3[i] = select[0];
            else if(k<4) as3[i] = select[1];
            else if(k<6) as3[i] = select[2];
            else if(k<8) as3[i] = select[3];
            else if(k<10) as3[i] = select[4];
            
        }
        
        // ä�� -> �� -> 
        // 1) ���� ���� ���� ��� ��ȯ (1���� ���)
        // 2) ������ ���� �� ��� ���� ������ ����� ��� ��ȯ
        
        int[][] result = {
        				  {1, checkAnswer(answers, as1)},
        				  {2, checkAnswer(answers, as2)},
        				  {3, checkAnswer(answers, as3)}
        				  };
        

        // ���� ������ ���� ��� ��ȯ
        Arrays.sort(bestScore(result));
        answer = bestScore(result);
        return answer;
    }
    
    // ���� ���� ��ȯ
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
    	
    	// �ִ밪 ���ϱ� (best score ���ϱ� )
    	for(int i=1; i<3; i++) {
    		if(result[best][1]<result[i][1]) {
    			best= i;
    		} 
    	}
    	System.out.println("���� best��?"+best+", ���ھ�: "+result[best][1]);
    	
    	
    	// �� ������ best�� ������ �� ���� �̰Ŷ� ���� ��鸸 ã���� �ȴ�. 
    	for(int i=0; i<3; i++) {
    		if(result[i][1]==result[best][1]) {
    			li.add(i);
    		}
    	}
    	
    	// arraylist�� array�� ��ȯ
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
		System.out.println("1�� ����: "+Arrays.toString(sb.solution(answers1)));
		System.out.println("2�� ����: "+Arrays.toString(sb.solution(answers2)));
	}
}
