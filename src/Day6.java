//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            out.println(ob.decodedString(s));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String decodedString(String s){
        Stack<Integer> nums = new Stack<>();
        Stack<String> st = new Stack<>();
        
        int i=0;
        while(i < s.length()){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                int n=0;
                while(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    n = n*10 + (s.charAt(i)-'0');
                    i++;
                }
                nums.push(n);
            } else{
                if(s.charAt(i) == ']'){
                    int n = nums.pop();
                    StringBuilder sb = new StringBuilder();
                    while(!st.peek().equals("[")){
                        sb.append(st.pop());
                    }
                    st.pop();  //for bracket
                    StringBuilder newStr = new StringBuilder();
                    
                    while(n>0){
                        newStr.append(sb);
                        n--;
                    }
                    st.push(newStr.toString());
                } else{
                    st.push(""+s.charAt(i));
                }
                i++; //reach to the last bracket
            }
        }
        
        StringBuilder inner = new StringBuilder();
        while(st.size() > 0){
            inner.append(st.pop());
        }
        return inner.reverse().toString();
    }
}
