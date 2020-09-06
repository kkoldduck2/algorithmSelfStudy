package programmers;

//import java.util.Comparator;
//import java.util.PriorityQueue;

// 왜 우선순위 큐를 써야하는가

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
 
    //공급량이 많을수록 공급 날짜가 빠를수록 더 우선순위를 줌
    @Override
    public int compareTo(Supply o) {
        if (this.supply > o.supply) {
            return -1;	// 우선순위 더 높음
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
        
        //우선순위 큐를 이용하여 Supply 정렬
        for (int i = 0; i < supplies.length; i++) {
            pq.add(new Supply(dates[i], supplies[i]));
        }
        
        //List에 우선순위 순으로 삽입
        for (int i = 0; i < supplies.length; i++) {
            list.add(pq.poll());
        }
        
        int cnt = 0;
        //stock이 k일까지 버틸 수 있을때까지 반복
        while (stock < k) {
            //우선순위 순으로 List를 순회하며 supply 공급받음
            for (int i = 0; i < list.size(); i++) {
                //date가 stock보다 작거나 같다면 현재 stock만으로 수령 가능
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

PriorityQueue를 이용할 것이기 때문에 Supply라는 class를 생성하여 date, supply를 하나로 묶어줍니다.

compareTo 메소드를 이용하여 공급량이 많을수록 날짜가 빠를수록 더 우선순위를 줍니다.



(line 32 ~ 33)

PriorityQueue를 이용해 Supply를 정렬합니다.



(line 37 ~ 39)

정렬된 Supply를 순차적으로 ArrayList에 담습니다.



(line 41 ~ 53)

Stock이 K이면 K일까지 버틸 수 있으므로 그 전까지는 while문을 돌며 공급을 받아야합니다.

많이 공급을 받을 수 있는 우선순위 순으로 list에 담겨있기 때문에 첫번째 요소부터 순회하며 공급이 가능하다면 (date가 stock보다 작거나 같다면)
 공급을 받습니다. 공급을 받을 때마다 count를 늘려주고 count를 return 해줍니다.


6. 배운 점 / 느낀 점
- 함께 생각할 요소는 Class로 묶고 우선순위는 CompareTo로 정리하는 것을 연습하기 좋은 예제였습니다.



- PriorityQueue는 공급이 불가능한 date를 건너뛰는 순회를 할 수 없기 때문에 pq의 값을 list로 옮기는 작업이 필요하였습니다. 
이때 index 접근이 용이한 ArrayList로 구현하여 효율성을 높일 수 있었습니다.


 * */


//
//class Solution {
//    public int solution(int stock, int[] dates, int[] supplies, int k) {
//    	
//    	// 우선 순위 큐에 Comparator 생성 -> 지정된 Comparator의 정렬 방법에 따라 우선 순위를 할당
//        PriorityQueue<Integer> pqSupplies = new PriorityQueue<>(new Comparator<Integer>() {
//
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;				// 공급량이 많을 수록 우선순위 높다.
//            }
//        });
//
//        int spIdx = 0;
//        int cnt = 0;
//        for (int day=0; day<k; day++) {
//        	// 뭔소리야...
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
