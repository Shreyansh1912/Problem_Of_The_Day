//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    int maxIndexDiff(int arr[], int n) {
        int[] mn = new int[n];
        int[] mx = new int[n];
        mn[0] = arr[0];
        mx[n - 1] = arr[n - 1];

        for (int i = 1; i < n; i++) {
            mn[i] = Math.min(mn[i - 1], arr[i]);
            mx[n - i - 1] = Math.max(mx[n - i], arr[n - i - 1]);
        }

        int i = 0;
        int j = 0;
        int ans = 0;

        while (i < n && j < n) {
            while (j < n && mn[i] <= mx[j]) {
                j++;
            }

            ans = Math.max(ans, j - i - 1);
            i++;
        }

        return ans;
    }
}
