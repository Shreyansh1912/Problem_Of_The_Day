//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int characterReplacement(String s, int k)
    {
        int n = s.length();
        
        char ch[] = s.toCharArray();
        
        int freq[] = new int[26];
         
        int st = 0; int max_freq = 0; int ans = 0;
        
        for(int end = 0; end < n; end++){
            max_freq = Math.max(max_freq, ++freq[ch[end]-'A']);
            
            while(end-st+1 - max_freq > k){
                //reduce the window size and increase st++;
                freq[ch[st]-'A']--;
                st++;
            }
            // process the ans
            ans = Math.max(ans, end-st+1);
        }
        return ans;
    }
}
