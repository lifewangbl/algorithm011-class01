public class PreorderTraversal_144 {
    /**
     * 二叉树的前序遍历:给定一个二叉树，返回它的 前序 遍历。
     *      示例:
     *          输入: [1,null,2,3]
     *           1
     *            \
     *             2
     *             /
     *           3
     *           输出: [1,3,2]
     */
    /**
     * 方法1：递归
     *        根-左-右
     */
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList();
        pre(root);
        return list;
    }
    public void pre(TreeNode node) {
        if (node != null) {
            list.add(node.val);
            pre(node.left);
            pre(node.right);
        }
    }

    /**
     *  方法2：迭代
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList();
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return list;
    }

}
