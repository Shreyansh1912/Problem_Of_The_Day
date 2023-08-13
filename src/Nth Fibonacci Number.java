//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int nthFibonacci(int n){
        // code here
        if (n<=1)
        {
            return n; 
        }
        int[] fibArr = new int[n + 1];
        
        fibArr[0] = 0;
        fibArr[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            fibArr[i] = (fibArr[i - 1] + fibArr[i - 2]) % 1000000007;
        }
        
        return fibArr[n];
    }
}
