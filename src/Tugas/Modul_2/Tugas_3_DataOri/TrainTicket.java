package Tugas.Modul_2.Tugas_3_DataOri;

public class TrainTicket {
    public String pName;
    public String sLoc;
    public String dest;
    public double prc;
    private String time;
    private String cls;
    private int seat;

    private static final int MAX_SEATS = 200;
    private static final int MIN_SEATS = 1;

    public TrainTicket(String passengerName, String startLoc, String destination, double price, String time, String cls, int seat) {
        this.pName = passengerName;
        this.sLoc = startLoc;
        this.dest = destination;
        this.prc = price;
        this.time = time;
        this.cls = cls;
        this.seat = seat;
    }

    // Method to check train status
    public void cS() {
        System.out.println("Your train is scheduled to " + dest);
    }

    // Method to display departure time
    public void dT() {
        System.out.println("Departure Time: " + time);
    }

    // Method to display the route
    public void dR() {
        System.out.println("Route: " + sLoc + " -> " + dest);
    }

    // Method to change seat
    public void changeSeat(int newSeat) {
        if (newSeat >= MIN_SEATS && newSeat <= MAX_SEATS) {
            seat = newSeat;
            System.out.println("Seat changed to: " + seat);
        } else {
            System.out.println("Invalid seat number!");
        }
    }

    // Method to upgrade class
    public void upgradeClass(String newClass) {
        cls = newClass;
        double upgradeFee = 0;

        if (newClass.equals("Executive")) {
            upgradeFee = 50000;
        } else if (newClass.equals("Business")) {
            upgradeFee = 25000;
        }

        prc += upgradeFee;
        System.out.println("Class upgraded to: " + cls + ", Additional fee: Rp " + upgradeFee);
    }

    // Method to display basic info passenger and trip
    public void dI() {
        System.out.println("Passenger Name : " + pName);
        System.out.println("Start Station : " + sLoc);
        System.out.println("Destination : " + dest);
        System.out.println("Price : " + prc);
        System.out.println("Final Price : " + (prc + (prc * 0.11))); // Price including 11% tax
    }

    // Method to display full info including time and class
    public void detailedInfo() {
        dI();
        System.out.println("Departure Time : " + time);
        System.out.println("Class : " + cls);
        System.out.println("Seat Number : " + seat);
    }

    public static void main(String[] args) {
        TrainTicket ticket = new TrainTicket("Alice", "Gambir", "Surabaya", 150000, "08:00", "Economy", 15);

        ticket.detailedInfo(); // Display full info

        ticket.cS(); // Check train status

        // Display route and departure time
        ticket.dR();
        ticket.dT();

        // Simulate seat change and class upgrade
        ticket.changeSeat(20);
        ticket.upgradeClass("Executive");

        // Display updated info
        System.out.println("\n=== After Changes ===");
        ticket.detailedInfo();
    }
}
