package com.muhammadFahishHaritsahJBusAF;

public class Rating{
    
    //field
    private long count;
    private long total;
    
    public Rating(){
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
            System.out.println("Cannot division by zero :(");
            res = 0;   
        }
        
        return res;
    }
    
    public long getTotal() {
        return this.total;
    }
    
    public long getCount() {
        return this.count;
    }
    
    public String toString(){
        String print = "\nRating : " + "\nCount : " + count + "\nTotal : " + total;
        return print;
    }
}