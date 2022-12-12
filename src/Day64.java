//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    class Graph{
        private int V;
    	private int time;
    	private List<ArrayList<Integer>> adj;
    	public Graph(int v, ArrayList<ArrayList<Integer>> adj) {
    		this.time = 0;
    		this.V = v;
    		this.adj = adj;
    	}
    
    	public void APUtil(int u, boolean visited[], int discoverTime[], int lowTime[], int parent[], boolean isAP[]) {
    		int childCount = 0;
    		visited[u] = true;
    		discoverTime[u] = lowTime[u] = ++time;
    		for (int v : adj.get(u)) {
    			if (!visited[v]) {
    				childCount++;
    				parent[v] = u;
    				APUtil(v, visited, discoverTime, lowTime, parent, isAP);
    				lowTime[u] = Math.min(lowTime[u], lowTime[v]);
    				if (parent[u] == -1 && childCount > 1) {
    					isAP[u] = true;
    				}
    				if (parent[u] != -1 && discoverTime[u] <= lowTime[v]) {
    					isAP[u] = true;
    				}
    			} else if (v != parent[u]) {
    				lowTime[u] = Math.min(lowTime[u], discoverTime[v]);
    			}
    		}
    		if (parent[u] == -1 && childCount > 1) {
    			isAP[u] = true;
    		}
    	}
    
    	public ArrayList<Integer> AP() {
    		boolean[] visited = new boolean[this.V];
    		int[] discoverTime = new int[this.V];
    		int[] lowTime = new int[this.V];
    		boolean[] isAP = new boolean[this.V];
    		int[] parent = new int[this.V];
    		Arrays.fill(parent, -1);
    		for (int u = 0; u < this.V; u++){
    		    if (visited[u] == false){
    		        APUtil(u, visited, discoverTime, lowTime, parent, isAP);
    		    }
    		}
    		ArrayList<Integer> ans = new ArrayList<Integer>();
    		for (int u = 0; u < this.V; u++){
    			if (isAP[u] == true){
    			    ans.add(u);
    			}
    	    }
    	    if(ans.size() == 0){
    	        ans.add(-1);
    	    }
    	    return ans;
    	}
    }
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        Graph graph = new Graph(V, adj);
        return graph.AP();
    }
}
