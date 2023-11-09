package com.muhammadFahishHaritsahJBusAF;

public class Voucher extends Serializable {
    
    //field
    public String name;
    private boolean used;
    public double minimum;
    public double cut;
    public int code;
    public Type type;
    
    public Voucher(String name, int code, Type type, double minimun, double cut){
        super();
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimun;
        this.cut = cut;
        this.used = false;
    }
    
    public boolean isUsed(){
        return this.used;
    }
    
    public boolean canApply(Price price){
        if (price.price > minimum && !this.used){
            return true;
        } else { return false; }
    }
    
    public double apply(Price price){
        //activating the voucher
        this.used = true;
        
        if (this.type == Type.DISCOUNT){
            if(cut >= 100){ cut = 100; }
            
            double discSum = price.price * cut/100;
            
            return price.price - discSum;
        } else if (this.type == Type.REBATE){
            double rebatePrice;
            rebatePrice =  price.price - cut;
            
            if(rebatePrice < 0){ rebatePrice = 0; }
            
            return rebatePrice;
        } else return 0;
    }
    
    public boolean read(){
        return false;        
    }
    public Object write(){
        return null;
    }
}
