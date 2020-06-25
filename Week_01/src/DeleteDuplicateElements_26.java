public class DeleteDuplicateElements_26 {
    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *示例 1: 给定数组 nums = [1,1,2],
     *       函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     *       你不需要考虑数组中超出新长度后面的元素。
     *示例 2:给定 nums = [0,0,1,1,1,2,2,3,3,4],
     *       函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     *       你不需要考虑数组中超出新长度后面的元素。
     * 思路：思路和283道的移动零类似
     *      1、定义一个标志 j = 0
     *      2、从第二个元素开始遍历数组，若满足nums[j] != nums[j]，则将nums[i]值赋给nums[++j]
     *      3、数组遍历结束 ++即为新数组长度。
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i])
                nums[++j] = nums[i];
        }
        return ++j;
    }
}
