package study_programmers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Queue01_bridgeTruck {
	static class Truck {
		int weight;
		int count;
		
		public Truck(int weight, int count){
			this.weight = weight;
			this.count = count;
		}
	}
	
	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		
//		int bridge_length = 2;
//		int weight = 10;
//		int[] truck_weights = {7,4,5,6};
		
//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck_weights = {10};
		
		Queue<Truck> complete = new LinkedList<>();
		Queue<Truck> bridge = new LinkedList<>();
		Queue<Truck> waiting = new LinkedList<>();
		
		int sec =0;
		int now_weight=0;
		
		// waiting ť�� ��ü Ʈ�� ��� 
		for(int w :truck_weights ) {
			Truck truck = new Truck(w, 1);
			waiting.add(truck);
		}
		
		// ��� Ʈ���� �긴�� �ǳʱ⸦ �Ϸ������� ���� (��������)
		while(complete.size()!=truck_weights.length) {
				
			// 1) waiting o , bridge x  --> waiting���� �߰� 
			if(!waiting.isEmpty() && bridge.isEmpty()) {
				Truck in = waiting.poll();
				if(now_weight + in.weight <= weight) {
					now_weight += in.weight;
					bridge.add(in);
				}
			}
			
			// 2-1) Ʈ���� ������ ���� : ���� �տ� �ִ� Ʈ���� count > bridge_length  && bridge not null
			if( !bridge.isEmpty() && bridge.peek().count > bridge_length) {
				Truck out = bridge.poll();
				now_weight-= out.weight;
				complete.add(out);
			}
			
			// 2-2) ���ο� �� ������ ���� : ���� �ٸ��� ���� + ���� ������ Ʈ���� ���� <= weight && waiting not null
			if(!waiting.isEmpty()) {
				Truck in = waiting.peek();
				if(now_weight + in.weight <= weight) {
					now_weight += in.weight;
					bridge.add(in);
					waiting.poll();
				}
			}
				
		
			// (����) �긴�� �� ��� Ʈ���� ���ؼ� count++, sec++
//			Iterator br = bridge.iterator();
//			while(br.hasNext()) {
//				Truck mem =(Truck)br.next();
//				mem.count++;
//			}
			
			// ���ͷ����� �Ⱦ��� �̷������ε� �� �� �ִ�. 
			for (Truck t : bridge) {
                t.count++;
            }
			
			sec++;
		}

		System.out.println(sec);
	}
}
