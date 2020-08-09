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
