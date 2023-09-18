package muhammadFahishHaritsahJBusAF;

class Price{
    
    //field
    public double price;
    public int discount;
    public double rebate;
    
    public Price(double price){
        this.price = price;
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
        if (this.discount >= 100) {
            this.discount = 100;
        } 
        double discountSum = this.price * (double) this.discount / 100;
        return this.price - discountSum;
    }
    
    private double getRebatePrice(){
        double price;
        
        price = this.price - this.rebate;
        if (price < 0){
            price = 0;
        }
        
        return price;
    }

}