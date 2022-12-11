//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean canPair(int[] nums, int k) {

        // HashMap<Integer, Integer> map = new HashMap<>();

        // int count = 0;

        // for(int i=0; i< nums.length; i++){

        //     int firstMod = k - nums[i]%k;

        //     int secondMod = k + nums[i]%k;

        //     if(map.containsKey(firstMod) || map.containsKey(secondMod)){

        //         if(map.containsKey(firstMod)){

        //             if(map.get(firstMod) == 1) map.remove(firstMod);

        //             else map.put(firstMod, map.get(firstMod)-1);

        //             count++;

        //         }else{

        //             if(map.get(secondMod) == 1) map.remove(secondMod);

        //             else map.put(secondMod, map.get(secondMod)-1);

        //             count++;

        //         }

        //     }else{

        //         map.put(nums[i]%k, map.getOrDefault(nums[i]%k,0 )+1);

        //     }

        // }

        // if(count == nums.length/2) return true;

        // return false;

        

        int [] freq = new int[k];

        for(Integer data : nums) freq[data%k]++;

        if(freq[0]%2 == 1) return false;

        for(int i=1; i<= k/2; i++){

            if(freq[i]!= freq[k-i]) return false;

        }

        return true;

    }

}
