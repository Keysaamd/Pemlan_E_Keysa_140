package Tugas.Modul_2.Tugas_2;

public class TaxiTicket extends Ticket implements Operational {
    public static final double TAX_RATE = 0.1;
    private double speed;

    private static final double MIN_SPEED = 5;
    private static final double MAX_SPEED = 100;

    public TaxiTicket(TicketInfo ticketInfo) {
        super(ticketInfo.passengerName(), ticketInfo.startLocation(), ticketInfo.destination(), ticketInfo.price(), ticketInfo.duration());
        this.setSpeed(ticketInfo.speed());
    }

    // Method to check taxi status
    @Override
    public void checkStatus() {
        System.out.println("Your taxi is heading to " + destination);
    }

    // Method to display estimated travel duration
    @Override
    public void displayEstimatedDuration() {
        System.out.println("Estimated travel duration: " + duration + " minutes");
    }

    // Method to display the route
    @Override
    public void displayRoute() {
        System.out.println("Route: " + startLocation + " -> " + destination);
    }

    // Method to slow down the taxi
    public void slowDown(double speedReduction) {
        setSpeed(getSpeed() - speedReduction);
        if (getSpeed() < MIN_SPEED)
            setSpeed(MIN_SPEED);
        duration += speedReduction * 0.5;
        System.out.println("Taxi slowed down! Current speed: " + getSpeed() + " km/h");
    }

    // Method to speed up the taxi
    public void speedUp(double speedIncrease) {
        setSpeed(getSpeed() + speedIncrease);
        if (getSpeed() > MAX_SPEED)
            setSpeed(MAX_SPEED);
        System.out.println("Taxi sped up! Current speed: " + getSpeed() + " km/h");
    }

    // Method to display basic info passenger and trip
    @Override
    public void displayInfo() {
        System.out.println("Passenger Name : " + passangerName);
        System.out.println("Start Location : " + startLocation);
        System.out.println("Destination : " + destination);
        System.out.println("Price : " + price);
        System.out.println("Final Price : " + (price + (price * calculateFinalPrice()))); // Price including 10% tax
    }

    private static double calculateFinalPrice() {
        return TAX_RATE;
    }

    // Method to display full info including duration and speed
    public void detailedInfo() {
        displayInfo();
        System.out.println("Duration : " + duration + " minutes");
        System.out.println("Speed : " + getSpeed() + " km/h");
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}