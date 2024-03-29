//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution{
    static String maxSum(String w,char x[],int b[], int n){
        HashMap<Character, Integer> hm = new HashMap<>();   //SC:O(N)
        
        for(int i=0; i<n; i++){
            hm.put(x[i], b[i]);           //O(1) becz value of x is fixes compared to w length
        }
        
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        
        for(char ch:w.toCharArray()){        //TC:O(|W|)
            currSum += hm.containsKey(ch)?hm.get(ch):ch;
            temp.append(ch);
            
            if(currSum > maxSum){
                maxSum = currSum;
                ans = new StringBuilder(temp);
            } 
            if(currSum < 0){
                currSum = 0;
                temp = new StringBuilder();
            }
        }
        return ans.toString();
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String w = read.readLine();
            int n = Integer.parseInt(read.readLine());
            String TE[] = read.readLine().trim().split(" ");
            char x[] = new char[n];
            for(int i = 0;i<n;i++)
            {
                x[i] = TE[i].charAt(0);
            }
            
            String TR[] = read.readLine().trim().split(" ");
            int b[] = new int[n];
            for(int i = 0;i<n;i++)
            {
                b[i] = Integer.parseInt(TR[i]);
            }
           
            Solution ob = new Solution();
            System.out.println(ob.maxSum(w,x,b,n));
        }
    }
}
// } Driver Code Ends
