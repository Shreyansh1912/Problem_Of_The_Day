//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long N;
            N = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.countBits(N);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long countBits(long n) {
       long count = 0, idx = 0;

		for (int i = 31; i >= 0; i--)
			count += ((n & (1 << i)) > 0) ? ((i * (1 << i) / 2 + (1 << i) * idx++) + 1) : 0;

		return count;
	}
}
