//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            int[] ptr = ob.satisfyEqn(A,N);
            
            System.out.println(ptr[0] + " " + ptr[1] + " " + ptr[2] + " " + ptr[3]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Pair{
    int i;
    int j;
    
    Pair(int a, int b){
        i = a;
        j = b;
    }
     
}
class Solution {
    static int[] satisfyEqn(int[] A, int N) {
        int[] ans = new int[4];
        Arrays.fill(ans, Integer.MAX_VALUE);
        
        Map<Integer, Pair> hm = new HashMap<>();
        
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                int sum = A[i] + A[j];
                
                if(!hm.containsKey(sum)){
                    hm.put(sum,new Pair(i,j));
                    continue;
                }
                Pair p = hm.get(sum);
                if(p.i != i && p.j != j && p.i != j && p.j != i){
                    int[] curr = new int[4];
                    curr[0] = p.i;
                    curr[1] = p.j;
                    curr[2] = i;
                    curr[3] = j;
                    
                    if(ans[0] == Integer.MAX_VALUE){
                        for(int idx=0; idx<4; idx++){
                                ans[idx] = curr[idx];
                        }
                    } else{
                        boolean replace = false;
                        for(int idx=0; idx<4; idx++){
                            if(ans[idx] > curr){
                                replace = true;
                                break;
                            } else if(ans[idx] < curr[idx]){
                                break;
                            }
                        }
                        if(replace){
                            for(int idx=0; idx<4; idx++){
                                ans[idx] = curr[idx];
                            }
                        }
                    }
                }
            }
        }
        
        if(ans[0] = Integer.MAX_VALUE){
            Arrays.fill(ans,-1);
        }
        return ans;
    }
};
