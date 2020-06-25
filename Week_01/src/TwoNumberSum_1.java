public class TwoNumberSum_1 {
    /**
     * 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * 示例:  给定 nums = [2, 7, 11, 15], target = 9
     *       因为 nums[0] + nums[1] = 2 + 7 = 9
     *       所以返回 [0, 1]
     * 思路：1、创建一个容器
     *      2、遍历数组，判断目标值与当前数组值的差是否存在于容器中
     *      3、如果存在，则返回容器中key对应的数组下标，否则将当前数组值和下标存入容器
     * @param nums   数组
     * @param target  目标值
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = {0,0};
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                result[0] = map.get(temp);
                result[1] = i;
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
