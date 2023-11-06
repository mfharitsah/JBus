package muhammadFahishHaritsahJBusAF;

import java.sql.Timestamp;

public class BookingThread extends Thread{
    private Bus bus;
    private Timestamp timestamp;

    public BookingThread(String name, Bus bus, Timestamp timestamp) {
        super(name);
        this.bus = bus;
        this.timestamp = timestamp;
        this.start();
    }

    @Override
    public void run() {
        for(Schedule s : bus.schedules) {
            if(s.departureSchedule.equals(timestamp)) {
                //ID dan nama Thread saat pembuatan
                System.out.println("\nID : " + getId() + " || Name : " + getName());
                String res = Payment.makeBooking(timestamp, "AF01", bus) ? "Berhasil" : "Gagal";
                System.out.println("\nID : " + getId() + " || Name : " + getName() + res);
            }
        }
    }
}

