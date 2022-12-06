//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n=grid.length; int m=grid[0].length;

        int visited[][]=new int[n][m];

        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++){
                 if(grid[i][j]==1){
                q.add(new int[]{i,j,0});
                }
            }
        }

        int ans[][]=new int[n][m];

        int dir[][]={{1,0},{0,1},{-1,0},{0,-1}};

        while(q.size()>0){
             int size=q.size();

            while(size-->0){

                int nd[]=q.remove();

                int i=nd[0]; int j=nd[1]; int k=nd[2];

                if(visited[i][j]==1) continue;

                visited[i][j]=1;

                ans[i][j]=k;

                for(int l=0;l<4;l++)

                {
                    int x=i+dir[l][0];
                    int y=j+dir[l][1];

                   if(x<0||y<0||x>=grid.length||y>=grid[0].length||visited[x][y]==1) continue;

                    q.add(new int[]{x,y,k+1});
                 }

            }

        }

        return ans;
    }
}
