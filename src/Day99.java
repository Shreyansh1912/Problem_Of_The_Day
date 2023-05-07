//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String str;
            str = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.stringMirror(str);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String stringMirror(String str) {
        int i = 1;
        while(i < str.length() && str.charAt(i) <= str.charAt(i-1)){
            if(str.charAt(i) == str.charAt(i-1) &&  i == 1) break;
            i++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0,i));
        StringBuilder sb1 = new StringBuilder(sb);
        sb.reverse();
        sb1.append(sb);
        return sb1.reverse().toString();
    }
}
        
