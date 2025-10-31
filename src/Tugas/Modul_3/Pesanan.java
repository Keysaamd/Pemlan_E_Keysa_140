package Tugas.Modul_3;

class Pesanan {
    private ItemMenu item;
    private int jumlah;

    public Pesanan(ItemMenu item, int jumlah) {
        this.item = item;
        this.jumlah = jumlah;
    }

    public double getSubtotal() {
        return item.getHarga() * jumlah;
    }

    public ItemMenu getItem() { return item; }
    public int getJumlah() { return jumlah; }
}