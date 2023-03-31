//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			Solution obj = new Solution();
			int [] b = obj.lexicographicallyLargest(arr, n);
			for(int x: b) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
    void reverse(int[] a,int i,int j)
    {
        while(i<j)
        {
            j--;
            
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            
            
            i++;
        }
    }
	int [] lexicographicallyLargest(int [] a, int n) {
	
	    int i=0;
	    
	    while(i<n)
	    {
	        int j=i+1;
	        
	        while(j<n && (a[j]+a[j-1])%2==0)
	        {
	            j++;
	        }
	        
	        
	        Arrays.sort(a,i,j);
	        reverse(a,i,j);
	        
	        i=j;
	    }
	    
	   return a;
	}
}
