package Tugas.Modul_2.Tugas_3;

/**
* Class yang merepresentasikan tiket kereta api.
* Mengimplementasikan TicketOperations dan mewarisi TransportationTicket.
*
* @author Keysa
*/

public class TrainTicket extends TransportationTicket implements TicketOperations {
    /** Biaya upgrade ke kelas Executive */
    public static final int EXECTIVE_UPGRADE_FEE = 50000;
    /** Biaya upgrade ke kelas Business */
    public static final int BUSINESS_UPGRADE_FEE = 25000;
    /** Rate pajak untuk perhitungan harga final (11%) */
    public static final double TAX_RATE = 0.11;

    /** Waktu keberangkatan */
    private String time;
    /** Kelas tiket (Economy, Business, Executive) */
    private String checkStatus;
    /** Nomor kursi */
    private int seat;

    /** Batas maksimal nomor kursi */
    private static final int MAX_SEATS = 200;
    /** Batas minimal nomor kursi */
    private static final int MIN_SEATS = 1;

    /**
     * Constructor untuk membuat objek TrainTicket menggunakan TicketData.
     *
     * @param ticketData Objek TicketData yang berisi semua informasi tiket
     */
    public TrainTicket(TicketData ticketData) {
        super(ticketData.passengerName(), ticketData.startLoc(), ticketData.destination(), ticketData.price());
        this.time = ticketData.time();
        this.checkStatus = ticketData.checkStatus();
        this.seat = ticketData.seat();
    }

    /**
     * Menampilkan status perjalanan kereta.
     * Mengindikasikan bahwa kereta sedang menuju tujuan.
     */
    @Override
    public void checkStatus() {
        System.out.println("✓ Status: Kereta menuju " + destination);
    }

    /**
     * Menampilkan waktu keberangkatan kereta.
     */
    @Override
    public void displayDepartureTime() {
        System.out.println("✓ Waktu Keberangkatan: " + time);
    }

    /**
     * Menampilkan rute perjalanan dari stasiun asal ke tujuan.
     * Format: StasiunAsal → StasiunTujuan
     */
    @Override
    public void displyRoute() {
        System.out.println("✓ Rute: " + startLocation + " → " + destination);
    }

    /**
     * Mengubah nomor kursi penumpang dengan validasi.
     *
     * @param newSeat Nomor kursi baru yang diinginkan
     */
    public void changeSeat(int newSeat) {
        if (isValidSeat(newSeat)) {
            seat = newSeat;
            System.out.println("✓ Kursi berhasil diubah ke: " + seat);
        } else {
            System.out.println("✗ Nomor kursi tidak valid!");
        }
    }

    /**
     * Memvalidasi apakah nomor kursi berada dalam range yang diperbolehkan.
     *
     * @param newSeat Nomor kursi yang akan divalidasi
     * @return true jika nomor kursi valid, false jika tidak
     */
    private static boolean isValidSeat(int newSeat) {
        return newSeat >= MIN_SEATS && newSeat <= MAX_SEATS;
    }

    /**
     * Mengupgrade kelas tiket dan menyesuaikan harga.
     *
     * @param newClass Kelas baru yang diinginkan (Executive/Business)
     * */
    public void upgradeClass(String newClass) {
        checkStatus = newClass;
        double upgradeFee = 0;

        if (newClass.equals("Executive")) {
            upgradeFee = EXECTIVE_UPGRADE_FEE;
        } else if (newClass.equals("Business")) {
            upgradeFee = BUSINESS_UPGRADE_FEE;
        }

        price += upgradeFee;
        System.out.println("✓ Kelas ditingkatkan ke: " + checkStatus + ", Biaya tambahan: Rp " + upgradeFee);
    }

    /**
     * Menampilkan informasi dasar tiket dalam format box.
     * Termasuk perhitungan harga final dengan pajak.
     * */
    @Override
    public void displayBasicInfo() {
        System.out.println("┌── INFORMASI DASAR ──");
        System.out.println("│ Nama Penumpang : " + passengerName);
        System.out.println("│ Stasiun Asal   : " + startLocation);
        System.out.println("│ Tujuan         : " + destination);
        System.out.println("│ Harga Dasar    : Rp " + price);
        System.out.println("│ Harga Final    : Rp " + (price + (price * calculateFinalPrice())));
        System.out.println("└────────────────────");
    }

    /**
     * Menghitung rate pajak untuk harga final.
     *
     * @return Rate pajak yang berlaku
     * */
    private static double calculateFinalPrice() {
        return TAX_RATE;
    }

    /**
     * Menampilkan informasi lengkap tiket dalam format terstruktur.
     * Menggunakan format box untuk tampilan yang rapi.
     * */
    @Override
    public void detailedInfo() {
        System.out.println("┌── DETAIL TIKET ──");
        System.out.println("│ Nama Penumpang : " + passengerName);
        System.out.println("│ Stasiun Asal   : " + startLocation);
        System.out.println("│ Tujuan         : " + destination);
        System.out.println("│ Harga Dasar    : Rp " + price);
        System.out.println("│ Harga Final    : Rp " + (price + (price * calculateFinalPrice())));
        System.out.println("│ Waktu Berangkat: " + time);
        System.out.println("│ Kelas          : " + checkStatus);
        System.out.println("│ Nomor Kursi    : " + seat);
        System.out.println("└─────────────────");
    }
}