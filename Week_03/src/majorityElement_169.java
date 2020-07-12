public class majorityElement_169 {
    /**
     *  解题思路：方法1
     *            1、使用map集合的特点key-value，key是唯一的
     *            2、遍历数组，将存在于集合中的key的value值+1，不存在的添加到集合中
     *            3、遍历集合找出其key对应的value>n/2的数据
     *            4、输出key
     */
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int n:nums) {
            if (map.containsKey(n)) {
                map.put(n,map.get(n)+1);
            }else{
                map.put(n,1);
            }
        }
        for (Integer key:map.keySet()) {
            if (map.get(key)>nums.length/2) return key;
        }
        return -1;
    }

    /**
     * 解题思路：方法2
     *            1、认真读题，多数元素的定义：指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素，并且数组中一定存在多数元素
     *            2、将数组进行排序
     *            3、此时可以找到，数组下标  数组长度/2  对应的数据就是我们要找的值
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
