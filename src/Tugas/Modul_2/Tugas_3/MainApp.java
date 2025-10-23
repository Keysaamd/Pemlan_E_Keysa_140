package Tugas.Modul_2.Tugas_3;

public class MainApp {
    //Move member
    public static void main(String[] args) {
        TrainTicket ticket = new TrainTicket(new TicketData("Gambir", "Alice", "Surabaya", 150000, "08:00", "Economy", 15));
        ticket.detailedInfo();
        ticket.checkStatus();
        ticket.displyRoute();
        ticket.displayDepartureTime();

        ticket.changeSeat(20);
        ticket.upgradeClass("Executive");

        System.out.println("\n=== After Changes ===");
        ticket.detailedInfo();
    }
}
