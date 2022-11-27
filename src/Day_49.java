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
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            String b = input[1];
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String addBinary(String A, String B) {
        // return new java.math.BigInteger(A, 2).add(new java.math.BigInteger(B, 2)).toString(2);
        int i = A.length()-1;
        int j = B.length()-1;
       
        StringBuilder ans = new StringBuilder();    // String ans = "" it not taken becz it take O(N) also
        int carry = 0;
        while(i >=0 || j >= 0){
            int sum = ((i>=0) ? A.charAt(i)-'0': 0) + ((j >= 0) ? B.charAt(j)-'0': 0) + carry;
            carry = sum/2;
            ans.append(sum%2);
            
            i--; j--;
        }
        if(carry != 0){
            ans.append(carry);
        }
        int idx =0;
        for(idx = ans.length()-1; idx >= 0; idx--){
            if(ans.charAt(idx) != '0')
              break;
        }
        ans.delete(idx+1, ans.length()); //delete leading zeroes from ans;
        return ans.reverse().toString();
    }
}
