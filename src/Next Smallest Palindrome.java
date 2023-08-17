//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    Vector<Integer> generateNextPalindrome(int num[], int n) {
        Vector<Integer> v = new Vector<>();
        if(isnine(num)){//check whether all the numbers in the given digit are 9
            for(int i=0;i<n+1;i++){
                if(i==0||i==n) v.add(1);//add 1 at start and end as it will be the smallest palindrome
                else v.add(0);
            }
            return v;
        }
    
        
        
        boolean flag=isRight(num,n);
        
        int i=(n-1)/2;
        int j=n/2;
        while(i>=0){
            if(flag){
                if(num[i]==9){
                    num[i]=0;
                }else{
                    num[i]++;
                    flag=false;
                }
            }
            num[j++]=num[i--];
            
        }
        
        for(i=0;i<n;i++){
            v.add(num[i]);
        }
        
        return v;
    }
    
    //check whether the right half is greater than the left half
    boolean isRight(int[] num,int n){
        int i=(n-1)/2;
        int j=n/2;
        
        while(i>=0&&j<n){
            if(num[i]<num[j]) return true; 
            else if(num[i]>num[j]) return false;
            
            i--;
            j++;
        }
        return true;
    }
    
    //function to check whether all the numbers in the given digit are 9
    boolean isnine(int[] num){
        for(int i=0;i<num.length;i++){
            if(num[i]!=9) return false;
        }
        
        return true;
    }
}
