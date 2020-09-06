package study_programmers;

import java.util.*;
// �̰Ŵ� �ð� �����ؼ� ���� ���߾�� �ФФ� �׳� ���� ���� �Ŀ� ���� Ǯ�����ϴ�..
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
		HashMap<String, String> map = new HashMap<>();	// account�� key, money�� value
		String[][] snapshots = {{"ACCOUNT1", "100"}, 
				{"ACCOUNT2", "150"}};
		
		String[][] transactions= {{"1", "SAVE", "ACCOUNT2", "100"},
				{"2", "WITHDRAW", "ACCOUNT1", "50"}, 
				{"1", "SAVE", "ACCOUNT2", "100"}, 
				{"4", "SAVE", "ACCOUNT3", "500"}, 
				{"3", "WITHDRAW", "ACCOUNT2", "30"}};
		
		
		// transaction ���
        for(int i=0; i<transactions.length; i++){
        	Transaction nts = new Transaction(transactions[i][0],transactions[i][1],transactions[i][2], transactions[i][3]);
            // ���������� contains �Լ��� ��� ���Ϸ��� ��ü�� equals �Լ��� �̿��� ������ Ȯ��
        	// ���� Transaction Ŭ���� ���� equals �Լ��� override ������Ѵ�. 
        	if(!list.contains(nts)) {
            	list.add(nts);
            }
        }
        
//        HashSet<Transaction> hs = new HashSet<>(list);	// custom class�� �ߺ� ���� �ȵ�....
        /* HashSet�� ���������� �ش� ��ü�� hashCode()�� equals()�� �����غ��� ����
         * ���� hashCode�� ������ equals �޼ҵ带 �����غ��� ������ �Ǻ��Ѵ�.
         * ���� ���� ������, �� ��ü�� ���� �������̹Ƿ� equals�޼ҵ带 �������� �ʴ´�.
         * Wrapper class �� Integer.class�� �޼ҵ带 ���� override�ؼ� value�� �����Ѵ�.*/
        
     
        // snapshot ��� 
        for(int i=0; i<snapshots.length; i++) {
        	map.put(snapshots[i][0], snapshots[i][1]);
        }
		
        for(Transaction ts : list) {
        	// account�� �̹� �ִ� ��� 
        	if(map.containsKey(ts.account)) {
        		if(ts.type.equals("SAVE")) {
        			int money = Integer.parseInt(map.get(ts.account)) + Integer.parseInt(ts.money);
        			map.put(ts.account, Integer.toString(money));
        		} else if(ts.type.equals("WITHDRAW")) {
        			int money = Integer.parseInt(map.get(ts.account)) - Integer.parseInt(ts.money);
        			map.put(ts.account, Integer.toString(money));
        		}
        	}
        	// ���� ��� 
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
        
        // 2���� �迭 ����
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
