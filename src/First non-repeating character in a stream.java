//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        int freq[]=new int[26];
        StringBuilder str=new StringBuilder();
        Queue<Character> q=new LinkedList<>();
        for(int i=0;i<A.length();i++){
            char c=A.charAt(i);
            int val=c-'a';
            freq[val]++;
            if(freq[val]<=1) q.add(c);
            else q.remove(c);
            if(q.isEmpty()) str.append('#');
            else str.append(q.peek());
        }
        return str.toString();
    }
}
