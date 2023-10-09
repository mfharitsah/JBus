package muhammadFahishHaritsahJBusAF;


/**
 * Write a description of class Review here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Review extends Serializable
{
    //field
    public String date;
    public String desc;
    
    //constructor
    public Review(String date, String desc){
        super();
        this.date = date;
        this.desc = desc;
    }
    
    public String toString(){
        String print = "Review :\n" + "ID : " + id + "\nDate : " + date + "\nDesc : " + desc;
        return print;
    }
}
