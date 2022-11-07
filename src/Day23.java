class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int V = matrix.length;
        int[][] costs = new int[V][V];
        
        for(int i=0; i<V; i++)
            for(int j=0; j<V; j++){
                if(matrix[i][j] == -1)
                    costs[i][j] = Integer.MAX_VALUE;
                else
                    costs[i][j] = matrix[i][j];
                
            }
        
             for(int intermediate=0; intermediate<V; intermediate++) 
                for(int source=0; source<V; source++)
                    for(int destination=0; destination<V; destination++){
                    if(costs[source][intermediate] != Integer.MAX_VALUE && costs[intermediate][destination] != Integer.MAX_VALUE)
                       costs[source][destination] = Math.min(costs[source][destination], costs[source][intermediate] + costs[intermediate][destination]);
                }
            
        
        for(int i=0; i<V; i++)
            for(int j=0; j<V; j++){
                if(costs[i][j] == Integer.MAX_VALUE)
                      matrix[i][j] = -1;
                 else
                    matrix[i][j] = costs[i][j];
                
            }
         return;
        
    }
}
