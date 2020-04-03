package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/3/31
 * @desc
 */
public class SortArray {

    public static void main(String[] args) {
        int[] nums = {0};
        new SortArray().sortArray(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums) {
        buildHeap(nums);
        int len = nums.length, t;
        for (int i = len - 1; i >= 0; i--) {
            t = nums[0];
            nums[0] = nums[i];
            nums[i] = t;
            sinking(nums, 0, i);
        }
    }

    private void buildHeap(int[] nums) {
        int len = nums.length;
        int last = len - 1 >> 1, temp, i;
        while (last>=0) {
            temp = last;
            i = (last << 1) + 2;
            if (i < len && nums[i] > nums[temp]) {
                temp = i;
            }

            i--;

            if (i < len && nums[i] > nums[temp]) {
                temp = i;
            }

            if (temp == last) {
                last--;
                continue;
            }

            i = nums[temp];
            nums[temp] = nums[last];
            nums[last] = i;
            sinking(nums, temp, len);
            last--;
        }
    }

    private void sinking(int[] nums, int top, int len) {
        int i, last;
        while (true) {
            last = top;
            i = (top << 1) + 1;
            if (i >= len) {
                break;
            }

            if (nums[i] > nums[last]) {
                last = i;
            }

            i++;
            if (i < len && nums[i] > nums[last]) {
                last = i;
            }

            if (top == last) {
                break;
            }

            i = nums[top];
            nums[top] = nums[last];
            nums[last] = i;
            top = last;
        }
    }



}
