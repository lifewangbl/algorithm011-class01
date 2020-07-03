public class InorderTraversal_94 {
    /**
     * 二叉树的中序遍历:给定一个二叉树，返回它的中序 遍历。
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
     *        左-根-右
     */
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList();
        pre(root);
        return list;
    }
    public void pre(TreeNode node) {
        if (node != null){
            pre(node.left);
            list.add(node.val);
            pre(node.right);
        }
    }

    /**
     *  方法2：迭代
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList();
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                curr = node.right;
            }
        }
        return list;
    }

}
