//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sc.next();
            }
            
            int k = Integer.parseInt(sc.next());
            
            String str = sc.next();
            
            Solution obj = new Solution();
            int ans = obj.klengthpref(arr,n,k,str);
            System.out.println(ans);
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int klengthpref(String[] arr, int n, int k, String str)
    {
        int n1 = str.length();
        if(k > n1) return 0;
        String prefix = "";
        
        for(int i=0; i<k; i++){
            prefix = prefix + str.charAt(i);
        }
        
        int ans = 0;
        for(String s: arr){
            if(s.length() < k) continue;
            if(prefixIsPresent(s, prefix)){
                ans++;
            }
        }
        return ans;
    }
    public boolean prefixIsPresent(String s, String prefix){
        for(int i=0; i<prefix.length(); i++){
            if(s.charAt(i) != prefix.charAt(i)) return false;
        }
        return true;
    }
}
