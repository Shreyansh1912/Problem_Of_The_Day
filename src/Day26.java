//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.jumpingNums(X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long jumpingNums(long X) {
        Queue<Long> queue = new LinkedList<>();
        
        for(long i=1; i<=9; i++){
            queue.add(i);
        }
        long ans=0;
        while(!queue.isEmpty()){
            long num = queue.remove();
            
            if(num > X){
                continue;
            }
            int lastDigit = (int)num % 10;
             
            if(lastDigit != 0){
               long first = num*10 + (lastDigit-1);
               queue.add(first);
            }
            if(lastDigit != 9){
               long second = num*10 + (lastDigit+1);
               queue.add(second);
            }
            ans = Math.max(ans, num); 
        }
        return ans;
    }
};
