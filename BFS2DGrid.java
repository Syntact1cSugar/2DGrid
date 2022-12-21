import java.lang.*;
import java.util.Queue;
import java.util.LinkedList;


///Breadth First Traversal Theory:
///Every cell at distance k from the source cell is visited before visiting any cell at a 
///distance k+1
public class BFS2DGrid
{
    
    public static class Pair
    {
        public int row,col;
        public Pair(int row,int col)
        {
            this.row = row;
            this.col = col;
        }
    }
    public static void BFS(int[][] A,int row,int col,boolean[][] visited)
    {
        int[][] direction = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,1},{1,-1},{-1,1}};
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(row,col));
        int currentDistance = 0;
        visited[row][col] = true;
        while(!q.isEmpty())
        {
            System.out.println(currentDistance);
            int qsize = q.size();
            for(int i=0;i<qsize;i++)
            {
                Pair current = q.poll();
                System.out.println(current.row+":"+current.col);
                for(int k=0;k<8;k++)
                {
                    int x = direction[k][0] + current.row;
                    int y = direction[k][1] + current.col;
                    if(x >= 0 && x < A.length && y >= 0 && y < A.length && A[x][y] == 1 &&  visited[x][y] == false)
                    {
                        q.add(new Pair(x,y));
                        visited[x][y] = true;
                    }
                }
            }
            currentDistance++;
        }
        
    }
    public static void main(String[] args)
    {
        int[][] A = new int[][]{{1,1,1},{0,1,1},{0,0,1}};
        boolean[][] visited = new boolean[3][3];
        BFS(A,0,0,visited);
        A = null;
        return;
    }
}
