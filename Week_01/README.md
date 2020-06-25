## 学习笔记
### 职业训练
    拆分知识点
    刻意练习
    反馈
### 切题四件套
    1、Clarification:反复确认题意
    2、Possible solution:尽可能多的解题思路，写出尽可能多的解法，进行分析，时间、空间复杂度分析
    3、Coding:多写
    4、Test cases:把测试样例多列举几个
### 五毒神掌
    1、刷题第一遍
       5分钟：读题+思考；
       有思路-直接做，写代码；没思路-直接看解法，比较不同解法的优劣；
       背诵默写好这些解法。
    2、刷题第二遍
       马上自己写，leetcode提交，有问题-->debug修改-->debug修改-->正确；
       多种解法进行比较，体会-->优化！ 时间复杂度！！！
    3、过了一天，再重复做题
       不同解法的熟练程度-->专项练习！！
    4、过了一周，反复回来练习相同的题目
    5、面试前一周恢复性训练
### 用add first或add last这套新的API改写Deque的代码
    public void newDeque() {
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size()>0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }
### Queue和Priority Queue的源码分析
    Queue：1、java.util包下的接口，扩展了Collection接口；
           2、队列通常是FIFO(先进先出),队列的头部都是通过remove()或poll()来删除元素，所有的新元素都插入队列的尾部；
           3、常用方法：boolean add(E e)： 如果可以在不违反容量限制的情况下立即执行此操作，则将指定的元素插入此队列，成功时返回true，如果当前没有可用空间则抛出IllegalStateException。
                        boolean offer(E e)： 如果可以在不违反容量限制的情况下立即执行此操作，则将指定的元素插入此队列，成功时返回true，如果当前没有可用空间则返回 false。
                        E remove()：检索并删除此队列的头部元素。 此方法与poll的不同之处仅在于，如果此队列为空，则抛出异常 NoSuchElementException。
                        E poll()： 检索并删除此队列的头部，如果此队列为空，则返回null。
                        E element()：检索但不删除此队列的头部。 此方法与peek的不同之处仅在于，如果此队列为空，则抛出异常 NoSuchElementException。
                        E peek()：检索但不移除此队列的头部，如果此队列为空，则返回null。
    Priority Queue：1、java.util包下的类，是Queue接口的一个实现类；
                    2、它是优先级队列，取出元素时会根据元素的优先级进行排序；
                    3、其内部是一个用数组实现的小顶堆，小顶堆删除堆顶元素后用最后一个元素替补，然后从上往下调整，插入一个元素时，先放到最后的位置，然后再从下往上调整；
                    4、小顶堆是用二叉树实现的，用数组表示时，父节点n的左孩子为2n+1，右孩子的序号为2n+2；
                    5、适用于动态插入元素，且元素有优先级顺序的场景。
                    
