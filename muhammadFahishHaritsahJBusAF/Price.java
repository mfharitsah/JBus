package muhammadFahishHaritsahJBusAF;

public class Price{
    
    //field
    public double price;
    public int discount;
    public double rebate;
    
    //constructor
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
        if (discount >= 100) {
            discount = 100;
        } 
        double discountSum = price * (double) discount / 100;
        return price - discountSum;
    }
    
    private double getRebatedPrice(){
        double rebatePrice;
        
        rebatePrice = price - rebate;
        if (rebatePrice < 0){
            rebatePrice = 0;
        }
        
        return rebatePrice;
    }

}