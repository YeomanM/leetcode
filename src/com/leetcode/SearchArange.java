package com.leetcode;

/**
 * @Description :
 * ---------------------------------
 * @Author : Yeoman
 * @Date : Create in 2019/8/14
 */
public class SearchArange {

    public static void main(String[] args) {
        int[] p = new SearchArange().searchRange(new int[]{1,1,1,1,1,1,2,3,4,4,5,5,5,6,7,8,8,8,8},8);

        for (int i = 0;i < p.length; i++){
            System.out.println(p[i]);
        }
    }


    public int[] searchRange(int[] nums, int target) {
        //获取目标字符是否存在数组中，若存在，直接返回目标字符存在的区间[left,right]，减少第二次遍历的次数
        int[] mids = this.getMiddle(nums,target,0,nums.length-1);
        //不存在，直接返回[-1,-1]
        if (mids[0] == -1){
            return new int[]{-1, -1};
        }
        //获取左边界，左边界targetLeft的必在范围[left,mid]中
        int left = this.getBorder(nums,target,mids[1],mids[0],true);
        //获取右边界，左边界targetRight的必在范围[mid,right]中
        int right = this.getBorder(nums,target,mids[0],mids[2],false);
        return new int[]{left,right};
    }

    /**
     * 二分查找，判断目标元素是否在数组中
     * @param nums 需要查找的数组
     * @param target 目标元素
     * @param low 需要查找的左边界
     * @param high 需要查找的右边界
     * @return int数组，下标为0的表示是否存在，-1未不存在，>=0为存在的下标，下标为1的表示下次查找的左边界，下标为2的表示下次查找的右边界
     */
    private int[] getMiddle(int[] nums,int target,int low,int high){
        int mid;
        while (low <= high){
            //防止溢出
            mid = low + ((high - low) >> 1);
            //存在，立即返回
            if (target == nums[mid]){
                return new int[]{mid,low,high};
            } else if (target > nums[mid]){
                //比目标节点小
                low = mid + 1;
            } else {
                //比目标节点大
                high = mid - 1;
            }
        }
        //不存在，返回-1
        return new int[]{-1,-1,-1};
    }

    /**
     * 获取左右边界
     * @param nums 需要查找的数组
     * @param target 目标元素
     * @param low 查找的左边界
     * @param high 查找的右边界
     * @param left 是否查找目标元素的左边界
     * @return -1代表不存在(此处不可能返回-1，可在主函数判断)，其它为边界的下标
     */
    private int getBorder(int[] nums,int target,int low,int high,boolean left){
        int mid,lastMid = -1;
        while (low <= high){
            //防止溢出
            mid = (low + high)>>1;
            //相等，则记录下标
            if (target == nums[mid]){
                lastMid = mid;
                if (left){
                    //当查找的为左边界时，需要往左方向查找
                    high = mid - 1;
                } else {
                    //当查找的为右边界时，需要往右方向查找
                    low = mid + 1;
                }
            } else if (target > nums[mid]){
                //当目标元素较大，需要往元素较大的方向查找
                low = mid + 1;
            } else {
                //当目标元素较小，需要往元素较小的方向查找
                high = mid - 1;
            }
        }
        return lastMid;
    }

}
