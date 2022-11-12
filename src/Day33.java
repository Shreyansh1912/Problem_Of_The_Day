// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            String S1 = br.readLine().trim();
            String S2 = br.readLine().trim();
            String S3 = br.readLine().trim();
            
            Solution soln = new Solution();
            if(soln.solve(n, S1, S2, S3))
                ot.println(1);
            else
                ot.println(0);
        }

        ot.close();
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    public boolean solve(int N, String S1, String S2, String S3){
        
      char[] ch = S1.toCharArray();
      char[] ch1 = S2.toCharArray();
      char[] ch2 = S3.toCharArray();
      
      
      Arrays.sort(ch);
      Arrays.sort(ch1);
      Arrays.sort(ch2);
      
      
      String new_S1 = new String(ch);
      String new_S2 = new String(ch1);
      String new_S3 = new String(ch2);
      
      if(new_S1.equals(new_S2) || new_S2.equals(new_S3) || new_S3.equals(new_S1)){
        return true;
      }
     return false;    
    }
}
