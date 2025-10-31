package Tugas.Modul_3;

class ItemMenu {
    private String nama;
    private double harga;
    private String kategori;

    public ItemMenu(String nama, double harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }

    // Getter methods
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public String getKategori() { return kategori; }
}
