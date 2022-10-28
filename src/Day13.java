//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.io.*;
// Position this line where user code will be pasted.
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            String S = input[0];
            int k =  Integer.parseInt(input[1]);
            Solution ob = new Solution();

            System.out.println(ob.lexicographicallySmallest(S, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static String lexicographicallySmallest(String S, int k) {
        int l = S.length();
        
        if(isPower(l)){
            k/=2;
        }else{
            k*=2;
        }
        
     if(k >= l) return "-1";   
     
     int removed=0;
     Stack<Character> st = new Stack<>();
     for(int i=0; i<l; i++){
         char ch = S.charAt(i);
        while(!st.isEmpty() && removed < k && st.peek() > ch){
            st.pop();
            removed++;
        }
        st.push(ch);
     }
     while(removed < k){
        st.pop();
        removed++;
     }
     StringBuilder sb = new StringBuilder();
      while(st.size() > 0){
        sb.append(st.pop());
      }
       return sb.reverse().toString();
   }
   
    static boolean isPower(int n){
        int c=0;
        while(n>0){
            c+=(n&1);
            n>>=1;
        }
        return c>1?false:true;
    }
}
