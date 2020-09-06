package programmers;

//import java.util.Comparator;
//import java.util.PriorityQueue;

// �� �켱���� ť�� ����ϴ°�

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
 
class Supply implements Comparable<Supply> {
    int date;
    int supply;
    
    public Supply(int date, int supply) {
        this.date = date;
        this.supply = supply;
    }
 
    //���޷��� �������� ���� ��¥�� �������� �� �켱������ ��
    @Override
    public int compareTo(Supply o) {
        if (this.supply > o.supply) {
            return -1;	// �켱���� �� ����
        } else if (this.supply == o.supply) {
            if (this.date < o.date) return -1;
            else return 1;
        } else return 1;
    }
}
 
class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        PriorityQueue<Supply> pq = new PriorityQueue<>();
        List<Supply> list = new ArrayList<>();
        
        //�켱���� ť�� �̿��Ͽ� Supply ����
        for (int i = 0; i < supplies.length; i++) {
            pq.add(new Supply(dates[i], supplies[i]));
        }
        
        //List�� �켱���� ������ ����
        for (int i = 0; i < supplies.length; i++) {
            list.add(pq.poll());
        }
        
        int cnt = 0;
        //stock�� k�ϱ��� ��ƿ �� ���������� �ݺ�
        while (stock < k) {
            //�켱���� ������ List�� ��ȸ�ϸ� supply ���޹���
            for (int i = 0; i < list.size(); i++) {
                //date�� stock���� �۰ų� ���ٸ� ���� stock������ ���� ����
                if (stock >= list.get(i).date) {
                    stock += list.get(i).supply;
                    list.remove(i);
                    cnt++;
                    break;
                }
            }
        }
        
        return cnt;
    }
}

/*

(line 5 ~ 24)

PriorityQueue�� �̿��� ���̱� ������ Supply��� class�� �����Ͽ� date, supply�� �ϳ��� �����ݴϴ�.

compareTo �޼ҵ带 �̿��Ͽ� ���޷��� �������� ��¥�� �������� �� �켱������ �ݴϴ�.



(line 32 ~ 33)

PriorityQueue�� �̿��� Supply�� �����մϴ�.



(line 37 ~ 39)

���ĵ� Supply�� ���������� ArrayList�� ����ϴ�.



(line 41 ~ 53)

Stock�� K�̸� K�ϱ��� ��ƿ �� �����Ƿ� �� �������� while���� ���� ������ �޾ƾ��մϴ�.

���� ������ ���� �� �ִ� �켱���� ������ list�� ����ֱ� ������ ù��° ��Һ��� ��ȸ�ϸ� ������ �����ϴٸ� (date�� stock���� �۰ų� ���ٸ�)
 ������ �޽��ϴ�. ������ ���� ������ count�� �÷��ְ� count�� return ���ݴϴ�.


6. ��� �� / ���� ��
- �Բ� ������ ��Ҵ� Class�� ���� �켱������ CompareTo�� �����ϴ� ���� �����ϱ� ���� ���������ϴ�.



- PriorityQueue�� ������ �Ұ����� date�� �ǳʶٴ� ��ȸ�� �� �� ���� ������ pq�� ���� list�� �ű�� �۾��� �ʿ��Ͽ����ϴ�. 
�̶� index ������ ������ ArrayList�� �����Ͽ� ȿ������ ���� �� �־����ϴ�.


 * */


//
//class Solution {
//    public int solution(int stock, int[] dates, int[] supplies, int k) {
//    	
//    	// �켱 ���� ť�� Comparator ���� -> ������ Comparator�� ���� ����� ���� �켱 ������ �Ҵ�
//        PriorityQueue<Integer> pqSupplies = new PriorityQueue<>(new Comparator<Integer>() {
//
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;				// ���޷��� ���� ���� �켱���� ����.
//            }
//        });
//
//        int spIdx = 0;
//        int cnt = 0;
//        for (int day=0; day<k; day++) {
//        	// ���Ҹ���...
//            if (spIdx < dates.length && day >= dates[spIdx]) {
//                pqSupplies.add(supplies[spIdx]);
//                spIdx++;
//            }
//            if (stock <= 0) {
//                stock += pqSupplies.remove();
//                cnt++;
//            }
//
//            stock--;
//        }
//
//        return cnt;
//    }
//}
public class Heap_NoodleStore {

}
