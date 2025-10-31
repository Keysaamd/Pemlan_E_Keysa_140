package Tugas.Modul_2.Tugas_3;

/**
 * Abstract class yang merepresentasikan tiket transportasi umum.
 * Sebagai base class untuk berbagai jenis tiket transportasi.
 *
 * @author Keysa
 * */

public abstract class TransportationTicket {
    // Nama penumpang
    public String passengerName;

    // Stasiun atau lokasi keberangkatam
    public String startLocation;

    // Stasiun atau lokasi tujuan
    public String destination;

    // harga tiket
    public double price;

    /**
     * Constructor untuk membuat objek TransportationTicket.
     *
     * @param passengerName Nama penumpang
     * @param startLoc Lokasi keberangkatan
     * @param destination Lokasi tujuan
     * @param price Harga tiket
     * */
    public TransportationTicket(String passengerName, String startLoc, String destination, double price) {
        this.passengerName = passengerName;
        this.startLocation = startLoc;
        this.destination = destination;
        this.price = price;
    }

    /**
     * Abstract method untuk menampilkan informasi dasar tiket.
     * Harus diimplementasikan oleh subclass.
     * */
    public abstract void displayBasicInfo();
}