public class hammingWeight_191 {
    /**
     * 位1的个数:编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
     *      示例 1：
     *          输入：00000000000000000000000000001011
     *          输出：3
     *          解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     *          示例 2：
     *          输入：00000000000000000000000010000000
     *          输出：1
     *          解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
     */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return n == 0 ? 0 : 1 + hammingWeight(n & (n - 1));
    }

}
