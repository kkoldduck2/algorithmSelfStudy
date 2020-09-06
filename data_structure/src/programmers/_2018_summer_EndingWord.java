package programmers;

import java.util.Arrays;
import java.util.HashMap;
//import java.util.Map;

////////문제좀 똑바로 읽자~~~~~~~~//////////
/*
  반례 array 4 
 break 문을 제대로 써줘야 한다. 
  
 */ 


public class _2018_summer_EndingWord {
	
	
	public static int[] solution(int n, String[] words) {
        int[] answer = {};
        // word를 돌면서 hashMap에 담고 
        // containsKey 혹은 containsValue를 쓴다
        // 0: 1번쨰 사람 , 1: 2번쨰 사람
        // 정답은 [ 번호, 차례 ] 형태로 return
         
        // key = 단어 , value = 사람 번호
        int cnt=0;
        int rightcnt=0;
        HashMap <String, Integer> hm = new HashMap<String, Integer>();
        // 맨 첫번째는 일단 넣는다
        hm.put(words[0],0);
        
        for(int i=1; i<words.length; i++) {
        	// case 1) 앞의 단어의 끝말잇기가 안되는 경우
        	if(words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0)) {	
        		for(String key : hm.keySet()) {
        			if(hm.get(key)==i%n) {
        				cnt++;
        			}
        		}
        		
        		answer= new int[] {i%n+1, cnt+1};
        		break;
        		
        	}
        	// case 2) 끝말잇기가 되는 경우 
        	else {
        		// case 2-1) 이전에 등장하지 않은 경우
	        	if(!hm.containsKey(words[i])){
	        		// i%n 즉 0,1,2  중 한사람이 말한 단어를 그사람 번호와 함께 담는다
	        		hm.put(words[i],i%n);
	        		rightcnt++;
	        	}
	        	// case 2-2) 이전에 등장했던 단어인 경우
	        	else {
	        		// words[i]와 
	        		// value가 i%n 인 사람이 몇번 나왔는지 +1 해서 리턴한다.
	        		 
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
