package Tugas.Modul_2.Tugas_2;

public abstract class Ticket {
    public String passangerName;
    public String startLocation;
    public String destination;
    public double price;
    protected double duration;

    public Ticket(String passengerName, String startLocation, String destination, double price, double duration) {
        this.passangerName = passengerName;
        this.startLocation = startLocation;
        this.destination = destination;
        this.price = price;
        this.duration = duration;
    }

    // Method to display basic info passenger and trip
    public abstract void displayInfo();
}
