//{ Driver Code Starts
//Initial Template for Java

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
            int N = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            long ans = obj.NoOfChicks(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


//User function Template for Java

class Solution
{
    public long NoOfChicks(int n)
    {
     long arr[] = new long[n+1];
     long sum = 1;
     int idx = 1;
    
    
     arr[1] = 1;
    
     for(int i = 2 ; i <= n ; i++){
        
        if(i > 6){
            
            sum -= arr[idx++];
            
        }
        arr[i] = sum*2;
        sum += arr[i];
     }
    return sum;
    }
}
