public class IsAnagram_242 {
    /**
     * 有效的字母异位词: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *      示例 1:
     *              输入: s = "anagram", t = "nagaram"
     *              输出: true
     *      示例 2:
     *              输入: s = "rat", t = "car"
     *              输出: false
     *      说明: 你可以假设字符串只包含小写字母。
     *  解题思路：方法1
     *            1、将字符串转换成字符数组
     *            2、将字符数组排序
     *            3、获取排序后的字符数组转换成字符串
     *            4、比较两个字符串即可
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        Boolean flag = String.valueOf(chars).equals(String.valueOf(chart));
        if (flag) return true;
        return false;
    }

    /**
     * 解题思路：方法2
     *            1、创建一个数组长度为26的数组nums
     *            2、遍历字符串，对于字符串s，遇到的字符对应的数组位置+1，字符串t，对应的数组位置-1
     *            3、最后遍历数组nums，如果每个值都为0，则s和t是字母异位词
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length()!=t.length()) return false;
        int[] nums = new int[26];
        for (int i=0;i<s.length();i++) {
            nums[s.charAt(i) - 'a'] ++;
            nums[t.charAt(i) - 'a'] --;
        }
        for (int i=0;i<nums.length;i++) {
            if (nums[i] != 0)
                return false;
        }
        return true;
    }
}
