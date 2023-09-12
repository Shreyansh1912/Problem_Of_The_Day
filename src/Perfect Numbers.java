  long sum=1;
        long sq=(long)Math.sqrt(N);
        
        for(long i=2;i<=sq;i++){
            if(N%i==0){
                sum+=i+N/i;
            }
        }
        if(sq*sq==N){
            sum-=sq;
        }
        if(sum==N)
        return 1;
        return 0;
    }
};
