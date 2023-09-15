package muhammadFahishHaritsahJBusAF;

class Rating{
    
    //field
    private long count;
    private long total;
    
    public Rating(long count, long total){
        this.count = 0;
        this.total = 0;
    }
    
    public void insert(int rating){
        this.total += rating;
        
        this.count++;
    }
    
    public double getAverage(){
        double res;
        if(this.count != 0){
            res = this.total/this.count;
        } else{
            res = 0.0d;   
        }
        
        return res;
    }
    
    public long getCount(){
        return this.count;
    }
    
    public long getTotal(){
        return this.count;
    }
}