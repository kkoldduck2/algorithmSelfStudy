package study_programmers;

import java.util.*;
// 이거는 시간 부족해서 제출 못했어요 ㅠㅠㅠ 그냥 시험 끝난 후에 따로 풀었습니당..
public class Naver04 {
	static class Transaction{
		String id;
		String type;
		String account;
		String money;
		
		Transaction (String id, String type, String account, String money) {
			this.id = id;
			this.type = type;
			this.account = account;
			this.money = money;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (super.equals(obj)) {
				return true;
			}

			if (obj instanceof Transaction) {
				if (this.id == ((Transaction)obj).id) {
					return true;
				}
			}

			return false;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Transaction> list = new ArrayList<>();		// transaction
		HashMap<String, String> map = new HashMap<>();	// account가 key, money가 value
		String[][] snapshots = {{"ACCOUNT1", "100"}, 
				{"ACCOUNT2", "150"}};
		
		String[][] transactions= {{"1", "SAVE", "ACCOUNT2", "100"},
				{"2", "WITHDRAW", "ACCOUNT1", "50"}, 
				{"1", "SAVE", "ACCOUNT2", "100"}, 
				{"4", "SAVE", "ACCOUNT3", "500"}, 
				{"3", "WITHDRAW", "ACCOUNT2", "30"}};
		
		
		// transaction 담기
        for(int i=0; i<transactions.length; i++){
        	Transaction nts = new Transaction(transactions[i][0],transactions[i][1],transactions[i][2], transactions[i][3]);
            // 내부적으로 contains 함수의 경우 비교하려는 객체의 equals 함수를 이용해 같은지 확인
        	// 따라서 Transaction 클래스 내에 equals 함수를 override 해줘야한다. 
        	if(!list.contains(nts)) {
            	list.add(nts);
            }
        }
        
//        HashSet<Transaction> hs = new HashSet<>(list);	// custom class는 중복 제거 안됨....
        /* HashSet이 내부적으로 해당 객체의 hashCode()와 equals()를 실행해보기 때문
         * 만약 hashCode가 같으면 equals 메소드를 실행해보고 같은지 판별한다.
         * 만약 같지 않으면, 두 객체는 같지 않은것이므로 equals메소드를 실행하지 않는다.
         * Wrapper class 인 Integer.class의 메소드를 보면 override해서 value를 리턴한다.*/
        
     
        // snapshot 담기 
        for(int i=0; i<snapshots.length; i++) {
        	map.put(snapshots[i][0], snapshots[i][1]);
        }
		
        for(Transaction ts : list) {
        	// account가 이미 있는 경우 
        	if(map.containsKey(ts.account)) {
        		if(ts.type.equals("SAVE")) {
        			int money = Integer.parseInt(map.get(ts.account)) + Integer.parseInt(ts.money);
        			map.put(ts.account, Integer.toString(money));
        		} else if(ts.type.equals("WITHDRAW")) {
        			int money = Integer.parseInt(map.get(ts.account)) - Integer.parseInt(ts.money);
        			map.put(ts.account, Integer.toString(money));
        		}
        	}
        	// 없는 경우 
        	else {
        		if(ts.type.equals("SAVE")) {
        			int money = Integer.parseInt(ts.money);
        			map.put(ts.account, Integer.toString(money));
        		} 
        	}
        }
        
        String[][] answer = new String[map.size()][2];
        int k=0;
        for(String key : map.keySet()) {
        	answer[k][0] = key;
        	answer[k][1] = map.get(key);
        	k++;
        }
        
        // 2차원 배열 정렬
        Arrays.sort(answer, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				String s1 = o1[0];
				String s2 = o2[0];
				return s1.compareTo(s2);
			}
        });
        
        for(int i=0; i<answer.length; i++) {
        	System.out.println(answer[i][0]+", "+ answer[i][1]);
        }
        
	}
}
