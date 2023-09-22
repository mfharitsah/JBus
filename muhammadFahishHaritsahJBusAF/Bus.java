package muhammadFahishHaritsahJBusAF;


public class Bus extends Serializable{
    
    //field
    public String name;
    public Facility facility;
    public Price price;
    public int capacity;
    
    public Bus(int id, String name, Facility facility, Price price, int capacity){
        super(id);
        this.name = name;
        this.facility = facility;
        this.price = price;
        this.capacity = capacity;
    }
    
    
    
}
