public class MoveZeroes {
    /**
     * 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 示例:  输入: [0,1,0,3,12]
     *       输出: [1,3,12,0,0]
     * 说明:  1.必须在原数组上操作，不能拷贝额外的数组。
     *       2.尽量减少操作次数。
     * 思路：1、定义一个标志 j
     *      2、遍历数组，若满足nums[i] != 0，则 nums[j] = nums[i] 并且 j++
     *      3、此时已经将不为零的数据移动到数组前面，
     *        只需要将下标为：j到nums.length-1的数组中的值置为0即可。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        while (j<nums.length) {
            nums[j++] = 0;
        }
    }
}
