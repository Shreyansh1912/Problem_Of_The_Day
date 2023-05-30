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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
    int len=word.length();
        int n=board.length;
        int m=board[0].length;
        
        int vis[][]=new int[n][m];
        
        boolean[] flag=new boolean[]{false};
        
        int negihbours[][]={{1,0},{-1,0},{0,-1},{0,1}};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dfs(0,len,i,j,n,m,vis,board,word,flag,negihbours);
                if(flag[0]==true)return true;   
            }
        }
        return flag[0];
    }
    
    public void dfs(int idx, int len,int i,int j,int n,int m,int vis[][],char board[][],String word,boolean[] flag,int negihbours[][]){
        if(idx==len){
            flag[0]=true;
            return;
        }
        if(flag[0]==true)
            return;
        if(i==n || j==m)
            return;
        
        if(word.charAt(idx) == board[i][j]){
            vis[i][j]=1;
        
            for(int[] neg:negihbours){
                int ni=i+neg[0];
                int nj=j+neg[1];
            
                if(ni>=0 && ni<n && nj>=0 && nj<m && vis[ni][nj]==0){
                    dfs(idx+1,len,ni,nj,n,m,vis,board,word,flag,negihbours);
                }
            }
        
            vis[i][j]=0;
        }
    }
}


