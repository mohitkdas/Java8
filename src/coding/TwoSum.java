package coding;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        System.out.println(Arrays.toString(ts.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value)) {
                return new int[] {map.get(value), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {0, 0};
    }
}
