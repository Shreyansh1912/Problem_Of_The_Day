//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends

class jobComparator implements Comparator<Job>
{
    public int compare(Job j1, Job j2){
        return j2.profit - j1.profit;
    }
}
class Solution
{
    int[] JobScheduling(Job arr[], int n)
    {
       //TC: O(NLOGN) + O(N*M)
        Arrays.sort(arr, new jobComparator());
        int res = 0, tot_job = 0;
        
        boolean[] slot = new boolean[n];
        
        for(int i=0; i<n; i++){
            for(int j=arr[i].deadline-1; j>=0; j--){
                if(slot[j] == false){
                    res += arr[i].profit;
                    tot_job++;
                    slot[j] = true;
                    break;
                }
            }
        }
        int[] ans = {tot_job, res};
        return ans;
    }
}
