public class GroupAnagrams_49 {
    /**
     * 字母异位词分组:给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *      示例:
     *          输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     *          输出:
     *              [ ["ate","eat","tea"],["nat","tan"],["bat"]]
     *       说明：所有输入均为小写字母。不考虑答案输出的顺序。
     *  解题思路：方法1
     *          1、首先让我想到的是242题：有效的字母异位词 的解法
     *          2、将字母异位词组合在一起，可以想到 key，value 格式的集合
     *          3、根据字母异位词的特点可以通过排序或者其他方式，可以得到其唯一的key
     *          4、根据key来将字母异位词组合在一起
     */
    public static List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList();
        Map<String,List> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key))
                map.put(key,new ArrayList());
            map.get(key).add(strs[i]);
        }
        return new ArrayList(map.values());
    }

    /**
     *  方法2
     */
    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList();
        Map<String,List> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] nums = new int[26];
            for (char c:strs[i].toCharArray()) nums[c-'a'] ++;
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                str.append("#");
                str.append(nums[j]);
            }
            String key = str.toString();
            if (!map.containsKey(key)) map.put(key,new ArrayList());
            map.get(key).add(strs[i]);
        }
        return new ArrayList(map.values());
    }

}
