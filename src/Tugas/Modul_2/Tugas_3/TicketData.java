package Tugas.Modul_2.Tugas_3;

/*
 * Record untuk menyimpan data tiket kereta api.
 * Menggunakan Java Record untuk menyimpan data secara immutable.
 *
 * @param startLoc Stasiun keberangkatan
 * @param passengerName Nama penumpang
 * @param destination Stasiun tujuan
 * @param price Harga dasar tiket
 * @param time Waktu keberangkatan
 * @param checkStatus Kelas tiket (Economy, Business, Executive)
 * @param seat Nomor kursi
 *
 * @author Keysa
 */

public record TicketData(String startLoc, String passengerName, String destination,
                         double price, String time, String checkStatus, int seat) {
}