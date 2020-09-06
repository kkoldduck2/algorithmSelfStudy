package programmers;

import java.util.Arrays;
import java.util.HashMap;
//import java.util.Map;

////////������ �ȹٷ� ����~~~~~~~~//////////
/*
  �ݷ� array 4 
 break ���� ����� ����� �Ѵ�. 
  
 */ 


public class _2018_summer_EndingWord {
	
	
	public static int[] solution(int n, String[] words) {
        int[] answer = {};
        // word�� ���鼭 hashMap�� ��� 
        // containsKey Ȥ�� containsValue�� ����
        // 0: 1���� ��� , 1: 2���� ���
        // ������ [ ��ȣ, ���� ] ���·� return
         
        // key = �ܾ� , value = ��� ��ȣ
        int cnt=0;
        int rightcnt=0;
        HashMap <String, Integer> hm = new HashMap<String, Integer>();
        // �� ù��°�� �ϴ� �ִ´�
        hm.put(words[0],0);
        
        for(int i=1; i<words.length; i++) {
        	// case 1) ���� �ܾ��� �����ձⰡ �ȵǴ� ���
        	if(words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0)) {	
        		for(String key : hm.keySet()) {
        			if(hm.get(key)==i%n) {
        				cnt++;
        			}
        		}
        		
        		answer= new int[] {i%n+1, cnt+1};
        		break;
        		
        	}
        	// case 2) �����ձⰡ �Ǵ� ��� 
        	else {
        		// case 2-1) ������ �������� ���� ���
	        	if(!hm.containsKey(words[i])){
	        		// i%n �� 0,1,2  �� �ѻ���� ���� �ܾ �׻�� ��ȣ�� �Բ� ��´�
	        		hm.put(words[i],i%n);
	        		rightcnt++;
	        	}
	        	// case 2-2) ������ �����ߴ� �ܾ��� ���
	        	else {
	        		// words[i]�� 
	        		// value�� i%n �� ����� ��� ���Դ��� +1 �ؼ� �����Ѵ�.
	        		 
	        		for(String key : hm.keySet()) {
	        			if(hm.get(key)==i%n) {
	        				cnt++;
	        			}
	        		}
	        		answer= new int[] {i%n+1, cnt+1};
	        		break;
	        	}
        	}
        }
        

        if(rightcnt==words.length-1) {
        	answer= new int[] {0,0};
        }

        return answer;
    }
	
	
	public static void main(String[] args) {
		String[] array1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		String[] array2 = {"hello", "observe", "effect", "take", "either", "recognize", 
		                    "encourage", "ensure", "establish", "hang", "gather", "refer", 
		                    "reference", "estimate", "executive"};
		String[] array3 = {"hello", "one", "even", "never", "now", "world", "draw"};
		String[] array4= {"land", "dream", "mom", "mom", "ror"};
		//int[] answer=solution(3, array1);
		//int[] answer=solution(5, array2);
		int[] answer=solution(2, array4);
		System.out.println(Arrays.toString(answer));
	}
}
