//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            Solution ob = new Solution();
            System.out.println(ob.minLength(s, n));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution { 
    public int minLength(String s, int n) { 
     
     String arr[] = {"12", "21", "34", "43", "56", "65", "78", "87", "09", "90"};
     
     for(int i=0; i<=s.length()-2; i++){
            String a = s.substring(i,i+2);

            for(String b:arr){
                if(a.equals(b)){
                    s=s.replace(a,"");
                    i=-1;
                    break;
                }
            }
        } 
        return s.length();
    }
}
