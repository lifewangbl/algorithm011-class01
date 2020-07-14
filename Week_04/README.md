## 学习笔记
### 深度优先搜索 DFS 和  广度优先搜索 BFS
    深度优先搜索 Depth-First-Search
        递归写法：
        void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            dfs(root.right);
        }
        非递归写法：
        def DFS(self, tree):
            if tree.root is None:
        		return []
            visited, stack = [], [tree.root]
        	while stack:
        		node = stack.pop()
        		visited .add(node)
        		process (node)
        		nodes = generate_related_nodes(node)
        		stack .push(nodes)
        	# other processing work
        	...
     
    广度优先搜索  breadth ﬁrst search  
        void bfs(TreeNode root) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
### 分治代码模板
        
                    
