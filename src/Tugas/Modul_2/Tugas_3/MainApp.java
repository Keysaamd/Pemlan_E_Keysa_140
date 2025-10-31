package Tugas.Modul_2.Tugas_3;

/**
 * Kelas utama untuk menjalankan aplikasi manajemen tiket kereta api.
 * Demonstrasi penggunaan semua fitur yang tersedia dalam sistem tiket.
 *
 * @author Keysa
 * */

public class MainApp {
    /**
     * Method main sebagai entry point aplikasi.
     * Membuat objek tiket, menampilkan informasi, dan melakukan modifikasi.
     *
     * @param args Argumen command line (tidak digunakan)
     * */
    public static void main(String[] args) {
        // Membuat objek tiket dengan data awal
        TrainTicket ticket = new TrainTicket(new TicketData("Gambir", "Alice", "Surabaya", 150000, "08:00", "Economy", 15));

        System.out.println("=== TIKET KERETA API ===");
        ticket.detailedInfo();
        System.out.println();

        //menampilkan informasi tiket awal
        ticket.checkStatus();
        ticket.displyRoute();
        ticket.displayDepartureTime();

        System.out.println("\n=== PERUBAHAN TIKET ===");
        //melakukan modifikasi tiket
        ticket.changeSeat(20);
        ticket.upgradeClass("Executive");

        System.out.println("\n=== SETELAH PERUBAHAN ===");
        // menampilkan informasi setelah modifikasi
        ticket.detailedInfo();
    }
}