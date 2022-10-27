ArrayList<Integer> al= new ArrayList<>();
        Stack<Integer> st = new Stack<>();
       
        for(int i =0,j=1; j<N ;i++,j++)
        {
             boolean flag = false;
             
            if(arr[i]>arr[j])
            st.push(arr[i]);
            
            else
            {
                while(!st.isEmpty())
                {
                    if(arr[j] > st.peek())
                    {
                        st.pop();
                        flag = true;
                    }
                    else break;
                }
            }
            
            if(flag)
            {
                al.add(arr[i]);
            }
        }
        al.add(arr[N-1]);
        
        int ans[] = new int[al.size()];
        for(int i =0; i<al.size(); i++)
        {
            ans[i] = al.get(i);
        }
        return ans;
    }
}
