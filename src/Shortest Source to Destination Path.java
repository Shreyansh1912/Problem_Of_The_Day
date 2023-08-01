//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        if(A[0][0]==0) return -1;
        boolean[][] vis=new boolean[N][M];
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{0,0,0});
        vis[0][0]=true;
        int[] x={1, -1, 0, 0};
        int[] y={0, 0, 1, -1};
        while(!q.isEmpty()){
            int n=q.size();
            while(n-- > 0){
               int[] temp=q.poll();    
               int nrow=temp[0];
               int ncol=temp[1];
               int dis=temp[2];
               if(nrow==X && ncol==Y) return dis;
               for(int i=0; i<4; i++){
                 int a= nrow+x[i];
                 int b= ncol+y[i];
                 if(a>=0 && a<N && b>=0 && b<M && !vis[a][b] && A[a][b]!=0){
                     q.add(new int[]{a, b, dis+1});
                     vis[a][b]=true;
                 }
               }
            }
        }
        return -1;
    }
};
