//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String s[] = new String[N];
            for (int i = 0; i < N; i++) s[i] = read.readLine();
            Solution ob = new Solution();
            alphanumeric ans[] = ob.sortedStrings(N, s);
            for (int i = 0; i < ans.length; i++)
                System.out.println(ans[i].name + " " + ans[i].count);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class alphanumeric {
    public String name;
    public int count;
    alphanumeric(String name, int count) {
        this.name = name;
        this.count = count;
    }
};
class Solution {
    alphanumeric[] sortedStrings(int N, String A[]) {
        Map<String, Integer> hm = new TreeMap<>(); //Space:O(N) 
        //TC:O(nlogn)
        for(int i=0; i<N; i++){ //O(n)        
            hm.put(A[i], hm.getOrDefault(A[i],0) + 1); //O(logn)
        }
        int n = hm.size();
        
        alphanumeric arr[] = new alphanumeric[n];
        int idx = 0;
        
        for(Map.Entry<String, Integer> entry:hm.entrySet()){
            arr[idx++] = new alphanumeric(entry.getKey(), entry.getValue());
        }
        return arr;
    }
};
