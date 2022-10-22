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

            Day1 ob = new Day1();
            System.out.println(ob.fillingBucket(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Day1{
    static int fillingBucket(int N) {

        if(N <= 2) return N;

        int arr[] = new int[N+1];

        arr[0] = 1;
        arr[1] = 2;

        for(int i=2; i<N; i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 100000000;
        }
        return arr[N-1];
    }
};