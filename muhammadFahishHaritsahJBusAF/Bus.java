package muhammadFahishHaritsahJBusAF;


public class Bus extends Serializable{
    
    //field
    public String name;
    public Facility facility;
    public Price price;
    public int capacity;
    public Station departure;
    public Station arrival;
    public BusType busType;
    public City city;
    
    
    public Bus(int id, String name, Facility facility, Price price, int capacity, BusType busType, City city, Station departure, Station arrival){
        super(id);
        this.name = name;
        this.facility = facility;
        this.price = price;
        this.capacity = capacity;
        this.busType = busType;
        this.city = city;
        this.departure = departure;
        this.arrival = arrival;
    }
    
    public String toString(){
        String print = "\nBus :\n" + "Name : " + name + "\nFacility : " + facility.toString() + "" + price.toString() + "\nCapacity : " + capacity + "\n\nDeparture : " + departure.toString() + "\n\nArrival : " + arrival.toString() + "\n\nBus Type : " + busType.toString() + "\nCity : " + city.toString();
        return print;
    }
}
