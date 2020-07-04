## 学习笔记
### 知识点总结
    Hashtable:哈希表也叫散列表，是根据关键码值（Key value）而直接进行访问的数据结构。
              它通过把关键码值映射到表中一个位置来访问记录，以加快查找的 速度。 
    Map：key-value对，key不重复；Set：不重复元素的集合
    Set：不重复元素的集合。
    二叉树遍历：前序遍历：根-左-右
                    List<Integer> list = new ArrayList<Integer>();
                    public List<Integer> preorderTraversal(TreeNode root) {
                    	if (root == null)  return new ArrayList();
                    	pre(root);
                    	return list;
                    }
                    private void pre(TreeNode node) {
                    	if(node!=null){
                    		list.add(node.val);
                    		this.pre(node.left);
                    		this.pre(node.right);
                    	}
                    }
               中序遍历：左-根-右
                    public List<Integer> inorderTraversal(TreeNode root) {
                    	if (root == null) return new ArrayList();
                    	preInorder(root);
                    	return list;
                    }
                    public void preInorder(TreeNode root){
                    	if (root != null){
                    		preInorder(root.left);
                    		list.add(root.val);
                    		preInorder(root.right);
                    	} 
                    }
               后序遍历：左-右-根
                    List<Integer> list = new ArrayList<Integer>();
                    public List<Integer> postorderTraversal(TreeNode root) {
                    	if (root == null) return new ArrayList();
                    	pre(root);
                    	return list;
                    }
                    public void pre(TreeNode root){
                    	if (root != null) {
                    		pre(root.left);
                    		pre(root.right);
                    		list.add(root.val);
                    	}
                    }
    二叉搜索树(Binary Search Tree):
        二叉搜索树，也称有序二叉树（Ordered Binary Tree）、 排序二叉树（Sorted Binary Tree），是指一棵空树或者具有下列性质的 二叉树：
            1. 左子树上所有结点的值均小于它的根结点的值； 
            2. 右子树上所有结点的值均大于它的根结点的值； 
            3. 以此类推：左、右子树也分别为二叉查找树。 （这就是 重复性！）
            中序遍历：升序排列
    堆(Heap):
        Heap:可以迅速找到一堆树中的最大或最小值的数据结构。
        将根节点最大的堆叫做大顶堆或大根堆，根节点最小的叫做小顶堆或小根堆。
    二叉堆：
        通过完全二叉树来实现(不是二叉搜索树);
        二叉堆(大顶)满足以下性质：
            1、是一颗完全树；
            2、树中任意节点的值总是>=其子节点的值
        实现细节：
            1、二叉堆一般通过“数组”来实现；
            2、假设“第一个元素”在数组中的索引为0的话，则父节点和子节点的位置关系如下：
                1>索引为i的左孩子的索引是：2*i+1;
                2>索引为i的右孩子的索引是：2*i+2;
                3>索引为i的父节点的索引是：floor((i-1)/2);
        插入操作：
            1、新元素一律先插入到堆的尾部
            2、依次向上调整整个堆的结构(一直到根即可)
        删除堆顶操作(Delete Max)：
            1、将堆尾元素替换到顶部(即堆顶被替代删除掉)
            2、依次从根部向下调整整个堆的结构(一直到堆尾即可)
    这周学习的东西还挺多的，也有一定的难度了，个人对于树相关的算法还是很陌生的，所以在学习和
    实践的过程中也是有些艰辛的，但是在这其中却真的体验到了老师交给我们的五毒神掌的重要性，通
    过不断地记忆和重复的刷题，让我对树这类的算法也有了越来越深的理解。一路荆棘丛生，贵在坚持！
    加油！！
### HashMap分析总结
    1、存储结构
       JDK1.8之前 HashMap = 数组(O(1)）+ 单向链表（O(n)）
       JDK1.8之后 HashMap = 数组(O(1)）+ 单向链表（O(n)）+ 红黑树(O(log n)
    2、原理
        HashMap是基于hashing的原理，我们使用put(key,value)存储对象到HashMap中，使用get(key)从HashMap
        中获取对象。当我们给put()方法传递键和值时，我们先对键调用hashCode()方法，返回的hashCode用于
        找到bucket位置来存储Entry对象。(关键点：HashMap是在bucket中存储键对象和值对象，作为Map.Entry)
    3、hash碰撞(两个对象的hashCode相同)
        因为hashCode相同，所以它们的bucket位置相同，会发生'碰撞'；因为HashMap使用链表存储对象，这个Entry
        对象会存储在链表中。
        
    4、两个键的hashCode相同，如何获取值对象
        当调用get()方法时，HashMap会使用键对象的hashCode找到bucket位置，然后调用keys.equals()方法去找到
        链表中正确的节点，最终找到值对象。
        
    5、如果HashMap的大小超过了负载因子定义的容量，怎么办？
        默认的负载因子大小为0.75，也就是说，当一个map填满了75%的bucket的时候，将会创建原来HashMap大小的两倍
        的bucket数组，来调整map的大小，并将原来的对象放入新的bucket数组。
        (HashMap默认的初始化大小是16，扩容至原来的2倍；ArrayList默认的初始化大小是10，扩容为原来的1.5倍)
        
    注意：重新调整HashMap大小可能产生条件竞争；另外使用String，Integer这样的final修饰的对象作为键是非常合适
        的，因为它是不可变的，并且重写了equals()和hashCode()方法。
                    
