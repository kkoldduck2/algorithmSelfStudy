package programmers;


import java.util.*;

public class _2018_wintercoding_skilltree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String [] sk = skill.split("");
        HashMap<Integer,String> h = new HashMap<Integer,String>();
        
        for(int i=0; i<sk.length; i++){
            h.put(i,sk[i]);
        }
        
        for(int i=0; i<skill_trees.length; i++){
            boolean check_order = true;
            String[] check = skill_trees[i].split("");
            int key =0;
            for(int j=0; j<check.length; j++){
                if(h.containsValue(check[j])){
                    if(h.get(key).equals(check[j])){
                        key++;
                    }else{
                        check_order=false;
                        break;
                    }
                }
            }
            
            if(check_order==true){
                answer++;
            }
        }
        
        return answer;
     }
}