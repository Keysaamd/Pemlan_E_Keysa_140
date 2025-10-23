package Tugas.Modul_2.Tugas_3;

//Rename Method/Variable
//Extract Interface dan Superclass
public class TrainTicket extends TransportationTicket implements TicketOperations {
    public static final int EXECTIVE_UPGRADE_FEE = 50000;
    public static final int BUSINESS_UPGRADE_FEE = 25000;
    public static final double TAX_RATE = 0.11;
    //Encapsulation Field
    private String time;
    private String checkStatus;
    private int seat;

    private static final int MAX_SEATS = 200;
    private static final int MIN_SEATS = 1;

    //Refactoring Introduce Parameter Object
    public TrainTicket(TicketData ticketData) {
        super(ticketData.passengerName(), ticketData.startLoc(), ticketData.destination(), ticketData.price());
        this.time = ticketData.time();
        this.checkStatus = ticketData.checkStatus();
        this.seat = ticketData.seat();
    }

    @Override
    public void checkStatus() {
        System.out.println("Your train is scheduled to " + destination);
    }

    @Override
    public void displayDepartureTime() {
        System.out.println("Departure Time: " + time);
    }

    @Override
    public void displyRoute() {
        System.out.println("Route: " + startLocation + " -> " + destination);
    }

    //Refactoring Extract Method
    public void changeSeat(int newSeat) {
        if (isValidSeat(newSeat)) {
            seat = newSeat;
            System.out.println("Seat changed to: " + seat);
        } else {
            System.out.println("Invalid seat number!");
        }
    }

    private static boolean isValidSeat(int newSeat) {
        return newSeat >= MIN_SEATS && newSeat <= MAX_SEATS;
    }

    public void upgradeClass(String newClass) {
        checkStatus = newClass;
        double upgradeFee = 0;

        if (newClass.equals("Executive")) {
            upgradeFee = EXECTIVE_UPGRADE_FEE;
        } else if (newClass.equals("Business")) {
            upgradeFee = BUSINESS_UPGRADE_FEE;
        }

        price += upgradeFee;
        System.out.println("Class upgraded to: " + checkStatus + ", Additional fee: Rp " + upgradeFee);
    }

    @Override
    public void displayBasicInfo() {
        System.out.println("Passenger Name : " + passengerName);
        System.out.println("Start Station : " + startLocation);
        System.out.println("Destination : " + destination);
        System.out.println("Price : " + price);
        System.out.println("Final Price : " + (price + (price * calculateFinalPrice()))); // Price including 11% tax
    }

    //Extract Method
    private static double calculateFinalPrice() {
        return TAX_RATE;
    }

    @Override
    public void detailedInfo() {
        displayBasicInfo();
        System.out.println("Departure Time : " + time);
        System.out.println("Class : " + checkStatus);
        System.out.println("Seat Number : " + seat);
    }

}
