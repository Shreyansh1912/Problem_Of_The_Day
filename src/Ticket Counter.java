//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            Solution ob=new Solution();
            out.println(ob.distributeTicket(n,k));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public static int distributeTicket(int N,int K)
    {
        //TC: O(N) SC: O(1)
    //     int i=1, j=N, ans=0;
    //     boolean a = false;
    //     while(i <= j){
    //         if(a == false){
    //             i += K;
    //             ans = j;
    //         } else{
    //             j -= K;
    //             ans = i;
    //         }
    //         a = !a;
    //     }
    //     return ans;
    // }
     //TC: O(1) SC: O(1)
    int step = N/K;
    int left = step/2;
    int right =  left;
    
    if(step % 2 == 1) left++;
    
    int i = K*left;
    int j = (N+1)-(K*right);
    
    if(step%2 == 1){
        if(N%K == 0) return i;
        return i+1;
    }
    if(N%K == 0) return j;
    return j-1;
    }
}
