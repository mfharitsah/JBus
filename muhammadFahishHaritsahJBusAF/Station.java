package muhammadFahishHaritsahJBusAF;


/**
 * Write a description of class Station here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Station extends Serializable
{
    //fields
    public City city;
    public String stationName;
    
    public Station(int id, String stationName, City city){
        super(id);
        this.stationName = stationName;
        this.city = city;
    }
    
    public String print(){
        String print = "ID : " + id + "\nStation Name : " + stationName + "\n" + "City : " + city.toString();
        return print;
    }
}
