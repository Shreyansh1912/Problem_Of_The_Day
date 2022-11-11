//{ Driver Code Starts
//Initial Template for Java
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isSumOfTwo(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String isSumOfTwo(int N){
    //     for(int i=2; i<=N/2; i++){
    //         if(isPrime(i) && isPrime(N-i))     //x=i, y=N-i
    //         return "Yes";
    //     }
    //     return "No";
    // }
    // static boolean isPrime(int n){
    //     for(int i=2; i<=Math.sqrt(n); i++){
    //         if(n % i == 0) return false;
    //     }
    //     return true;
    // }
    
    // Using Sieve of Eratosthenes--> Time Complexity: O(n*log(log(n))) Auxiliary Space: O(n)
    boolean primes[] = new boolean[N];
    Arrays.fill(primes, true);
    
    for(int i=2; i*i<=N; i++){           // i <= Math.sqrt(N) equals (i*i) <= N
        if(primes[i]){
            for(int j=i*i; j<N; j += i){
              primes[j] = false;
            }
        }
    }
    for(int i=2; i<=N/2; i++){
        if(primes[i] && primes[N-i]){
            return "Yes";
        }
    }
    return "No";
   }
}
