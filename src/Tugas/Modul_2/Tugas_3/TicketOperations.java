package Tugas.Modul_2.Tugas_3;

/**
 * Interface yang mendefinisikan operasi-operasi yang dapat dilakukan pada tiket.
 * Menggunakan konsep interface untuk abstraction dan polymorphism.
 *
 * @author Keysa
 * */

public interface TicketOperations {
    /**
     * Memeriksa status perjalanan kereta api.
     * Menampilkan informasi tentang tujuan perjalanan.
     * */
    void checkStatus();

    /**
     * Menampilkan waktu keberangkatan kereta.
     * */
    void displayDepartureTime();

    /**
     * Menampilkan rute perjalanan dari stasiun asal ke tujuan.
     * */
    void displyRoute();

    /**
     * Menampilkan informasi dasar penumpang dan perjalanan.
     * Termasuk nama, stasiun, tujuan, dan harga.
     * */
    void displayBasicInfo();

    /**
     * Menampilkan informasi lengkap tiket termasuk semua detail.
     * */
    void detailedInfo();
}