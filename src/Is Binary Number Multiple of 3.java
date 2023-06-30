//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine().trim());
            while(t-->0)
                {
                    String s = in.readLine().trim();
                    Solution ob = new Solution();
                    out.println(ob.isDivisible(s));
                }
                out.close();
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isDivisible(String s) {
        int cnt = 0 ;
        
        int n = s.length() ;
        
        int index = 0 ;
        
        for( int i = n-1 ; i >= 0 ; i-- )
        {
            if( s.charAt(i) == '1' )
            {
                if(index%2==0) cnt += 1 ;
                else cnt += 2 ;
            }
            index++ ;
        }
        
        return cnt%3 == 0 ? 1 : 0 ;
    }
}
