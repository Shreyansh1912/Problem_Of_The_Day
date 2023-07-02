//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line[] = in.readLine().trim().split("\\s+");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int l = Integer.parseInt(line[2]);
            int r = Integer.parseInt(line[3]);
            
            Solution ob = new Solution();
            System.out.println(ob.setSetBit(x, y, l, r));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int setSetBit(int x, int y, int l, int r){
        // code here
    for(int i=l-1;i<r;i++)
        {
           if(get(i,y)) {
              x =  set(i,x);
           }
        }
        return x;
        
    }
    public static boolean get(int i,int n)
    {
        int bitmask = 1<<i;
         if((bitmask & n) == 0)
           return false;
         else
           return true;
    }
    public static int set(int i,int X){
        int bitmask = 1<<i;
         X =  bitmask | X;
         return X;
    }
}
