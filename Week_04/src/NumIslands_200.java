public class NumIslands_200 {
    /**
     * 岛屿数量:给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *          岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
     *          此外，你可以假设该网格的四条边均被水包围。
     *      示例:
     *          输入:
                 [
                 ['1','1','1','1','0'],
                 ['1','1','0','1','0'],
                 ['1','1','0','0','0'],
                 ['0','0','0','0','0']
                 ]
                输出: 1
     *          解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
     *  解题思路：方法1
     *          深度优先搜索
     */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int nr = grid.length;
        int nc = grid[0].length;
        int index = 0;
        for (int r=0;r<nr;++r) {
            for (int c=0;c<nc;++c) {
                if (grid[r][c]=='1'){
                    ++index;
                    dfs(grid,r,c);
                }
            }
        }
        return index;
    }
    public void dfs(char[][] grid,int r,int c){
        int nr = grid.length;
        int nc = grid[0].length;
        if (r<0||c<0||r>=nr||c>=nc||grid[r][c]=='0') return;
        grid[r][c] = '0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }

    /**
     *  广度优先搜索
     */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int nr = grid.length;
        int nc = grid[0].length;
        int index = 0;
        for (int r=0;r<nr;++r) {
            for (int c=0;c<nc;++c){
                if(grid[r][c]=='1'){
                    ++index;
                    grid[r][c]='0';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(r*nc+c);
                    while (!queue.isEmpty()) {
                        int id = queue.remove();
                        int row = id/nc;
                        int col = id%nc;
                        if (row-1>=0&&grid[row-1][col]=='1'){
                            queue.add((row-1)*nc+col);
                            grid[row-1][col]='0';
                        }
                        if (row+1<nr&&grid[row+1][col]=='1'){
                            queue.add((row+1)*nc+col);
                            grid[row+1][col]='0';
                        }
                        if (col-1>=0&&grid[row][col-1]=='1'){
                            queue.add(row*nc+col-1);
                            grid[row][col-1]='0';
                        }
                        if (col-1<nc&&grid[row][col+1]=='1'){
                            queue.add(row*nc+col+1);
                            grid[row][col+1]='0';
                        }
                    }
                }
            }
        }
        return index;
    }

}
