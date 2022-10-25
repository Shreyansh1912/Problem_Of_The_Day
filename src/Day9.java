//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<String> ans = ob.pattern(n);
            for(int i = 0;i < n;i++)
                System.out.println(ans.get(i));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<String> pattern(int n){
      int num=1;
        List<String> ans=new ArrayList<>();
        for(int row=0;row<n;row++){
            StringBuilder sb=new StringBuilder();

            //print -
            for(int times=0;times<row;times++){
                sb.append("--");
            }

            //printing nums
            for(int times=0;times<n-row;times++){
                sb.append(num+"*");
                num++;
            }
            ans.add(sb.toString());
        }

        for(int row=n-1;row>=0;row--){
            StringBuilder sb=new StringBuilder(ans.get(row));
            for(int times=0;times<n-row;times++){
                sb.append(num+"*");
                num++;
            }
            sb.deleteCharAt(sb.length()-1);
            ans.set(row,sb.toString());
        }
        return ans;
    }
} 
