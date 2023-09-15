package muhammadFahishHaritsahJBusAF;

class Price{
    
    //field
    public double price;
    public int discount;
    public double rebate;
    
    public Price(double price){
        this.discount = 0;
        this.rebate = 0;
    }
    
    public Price(double price, int discount){
        this.price = price;
        this.discount = discount;
        this.rebate = 0;
    }
    
    public Price(double price, double rebate){
        this.price = price;
        this.rebate = rebate;
        this.discount = 0;
    }
    
    private double getDiscountedPrice(){
        if (this.discount >= 100.0) {
            this.discount = 100;
        } 
        
        this.price = (this.price - (this.price * ((double)this.discount/100))); 
        
        return this.price;
    }
    
    private double getRebatePrice(){
        this.price -= this.rebate;
        if (this.price < 0){
            this.price = 0;
        }
        
        return this.price;
    }

}