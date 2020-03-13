package leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 */

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};

        System.out.println(new MajorityElement().majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);

        int t,v;
        for (int i = 0; i < len; i++) {
            t = nums[i];
            v = map.getOrDefault(t, 0);
            v = v + 1;
            if (v > (len >> 1)) {
                return t;
            }
            map.put(t, v);
        }
        return 0;
    }

}
