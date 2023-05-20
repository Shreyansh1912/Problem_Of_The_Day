//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            boolean ans = obj.isStraightHand(n, k, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isStraightHand(int N, int groupSize, int hand[]) {
        TreeMap<Integer, Integer> mm = new TreeMap<>();
        for(int x: hand){
            mm.putIfAbsent(x, 0);
            mm.put(x, mm.get(x)+1);
        }
        int num=-1, c=0;
        while(true){
            num = mm.firstKey();
            c=0;
            while(c<groupSize){
                if(mm.get(num) == null) return false;
                mm.put(num, mm.get(num)-1);
                if(mm.get(num) == 0) mm.remove(num);
                num++;
                c++;
            }
            if(mm.size() == 0) break;
        }
        return true;
    }
}
