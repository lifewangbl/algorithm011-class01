## 学习笔记
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
                    
