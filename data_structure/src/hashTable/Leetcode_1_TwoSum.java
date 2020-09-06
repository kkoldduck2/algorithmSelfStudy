package hashTable;

import java.util.HashMap;

class Solution{
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// �ؽ� �ʿ� ���  key: nums[i]  ,value: index
		for(int i=0; i<nums.length; i++) {
			map.put(nums[i], i);
		}
		
		// target-nums[i]�� �ش��ϴ� �� hashmap���� ã��
		for(int i1=0; i1<nums.length; i1++) {
			Integer i2 = map.get(target-nums[i1]);
			// null �� �ƴϰ� i1�� �ε����� ���� �ʴ� (�ڱ� �ڽ��� �ƴϴ�.)
			if(i2 !=null && i2!=i1) return new int[] {i1, i2};
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}

public class Leetcode_1_TwoSum {
 public static void main(String[] args) {
	int[] nums = {6,4,3,8,7,5,2};
	
	// solution Ŭ���� ��ü �����
	Solution sol = new Solution();
	int[] result = sol.twoSum(nums, 5);
	System.out.println(result[0]+", "+result[1]);
 }
}
