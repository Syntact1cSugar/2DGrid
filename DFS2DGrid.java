import java.lang.*;
import java.util.Stack;

public class DFS2DGrid
{
    static public class Pair
    {
        public int row,col;
        public Pair(int row,int col)
        {
            this.row = row;
            this.col = col;
        }
    }
    public static void DFS(int[][] A,int row,int col)
    {
        int m = A.length,n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        byte[][] direction = {{1,0},{-1,0},{-1,-1},{1,1},{1,-1},{-1,1},{0,1},{0,-1}};
        Stack<Pair> s = new Stack<Pair>();
        s.push(new Pair(row,col));
        visited[row][col] = true;
        while(!s.isEmpty())
        {
            Pair current = s.pop();
            System.out.println(current.row+":"+current.col);
            for(int k=0;k<8;k++)
            {
                int x = current.row + direction[k][0];
                int y = current.col + direction[k][1];
                if(x >= 0 && x < m && y >= 0 && y < n && visited[x][y] == false && A[x][y] == 1)
                {
                    s.push(new Pair(x,y));
                    visited[x][y] = true;
                }
            }
            
        }
    }
    public static void main(String[] args)
    {
        int[][] A = new int[][]{{1,1,0},{0,1,0},{1,1,1},{0,1,1},{0,0,1},{0,0,1}};
        DFS(A,0,0);
        return;
    }
}
