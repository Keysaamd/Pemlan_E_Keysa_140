package Tugas.Modul_2.Tugas_3;

public abstract class TransportationTicket {
    //Rename Method/Varible
    public String passengerName;
    public String startLocation;
    public String destination;
    public double price;

    public TransportationTicket(String passengerName, String startLoc, String destination, double price) {
        this.passengerName = passengerName;
        this.startLocation = startLoc;
        this.destination = destination;
        this.price = price;
    }

    // Method to display basic info passenger and trip
    public abstract void displayBasicInfo();
}
