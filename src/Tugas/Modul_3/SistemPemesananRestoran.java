package Tugas.Modul_3;

import java.util.*;

public class SistemPemesananRestoran {
    private List<ItemMenu> menu;
    private List<Pesanan> daftarPesanan;
    private double persenPajak;
    private double persenServiceCharge;
    private Scanner scanner;

    public SistemPemesananRestoran(double persenPajak, double persenServiceCharge) {
        this.menu = new ArrayList<>();
        this.daftarPesanan = new ArrayList<>();
        this.persenPajak = persenPajak;
        this.persenServiceCharge = persenServiceCharge;
        this.scanner = new Scanner(System.in);
        inisialisasiMenu();
    }

    private void inisialisasiMenu() {
        menu.add(new ItemMenu("Nasi Goreng Spesial", 25000, "Menu Utama"));
        menu.add(new ItemMenu("Mie Ayam Bakso", 20000, "Menu Utama"));
        menu.add(new ItemMenu("Ayam Geprek", 18000, "Menu Utama"));
        menu.add(new ItemMenu("Gado-gado", 15000, "Menu Utama"));
        menu.add(new ItemMenu("Es Teh Manis", 5000, "Minuman"));
        menu.add(new ItemMenu("Jus Jeruk", 8000, "Minuman"));
        menu.add(new ItemMenu("Kopi Hitam", 7000, "Minuman"));
        menu.add(new ItemMenu("Air Mineral", 3000, "Minuman"));
        menu.add(new ItemMenu("Pisang Goreng", 8000, "Makanan Penutup"));
        menu.add(new ItemMenu("Es Krim Vanilla", 12000, "Makanan Penutup"));
    }

    public void tampilkanMenuUtama() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("       🍽️  SISTEM PEMESANAN RESTORAN");
        System.out.println("=".repeat(50));
        System.out.println("1. Lihat Menu");
        System.out.println("2. Tambah Pesanan");
        System.out.println("3. Lihat Pesanan Sementara");
        System.out.println("4. Hapus Pesanan");
        System.out.println("5. Cetak Nota");
        System.out.println("6. Keluar");
        System.out.println("=".repeat(50));
    }

    public void tampilkanMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                  📋 MENU RESTORAN");
        System.out.println("=".repeat(60));
        System.out.printf("%-3s %-20s %-15s %-15s%n", "No", "Nama Menu", "Harga", "Kategori");
        System.out.println("-".repeat(60));

        for (int i = 0; i < menu.size(); i++) {
            ItemMenu item = menu.get(i);
            System.out.printf("%-3d %-20s Rp%,-13d %-15s%n",
                    (i + 1),
                    item.getNama(),
                    (int) item.getHarga(),
                    item.getKategori());
        }
        System.out.println("=".repeat(60));
    }

    public void tambahPesananInput() {
        if (menu.isEmpty()) {
            System.out.println("❌ Menu belum tersedia!");
            return;
        }

        Scanner sessionScanner = new Scanner(System.in);
        boolean tambahLagi = true;

        System.out.println("\n" + "=".repeat(60));
        System.out.println("           🛒 TAMBAH PESANAN");
        System.out.println("=".repeat(60));
        System.out.println("💡 Format: [nomor_menu] [jumlah]");
        System.out.println("   Contoh: 1 2 3 1 5 2");
        System.out.println("   Artinya: Menu 1 sebanyak 2, Menu 3 sebanyak 1, Menu 5 sebanyak 2");
        System.out.println("   Ketik 'selesai' untuk mengakhiri\n");

        while (tambahLagi) {
            tampilkanMenu();

            try {
                System.out.print("\n📝 Masukkan pesanan: ");
                String inputLine = sessionScanner.nextLine().trim();

                if (inputLine.equalsIgnoreCase("selesai") || inputLine.equals("0")) {
                    System.out.println("🎉 Input pesanan selesai!");
                    tambahLagi = false;
                    break;
                }

                if (inputLine.isEmpty()) {
                    System.out.println("❌ Input tidak boleh kosong!");
                    continue;
                }

                String[] parts = inputLine.split("\\s+");

                if (parts.length % 2 != 0) {
                    System.out.println("❌ Format input salah! Harus berpasangan [nomor] [jumlah]");
                    System.out.println("💡 Contoh: 1 2 (artinya menu 1 sebanyak 2)");
                    continue;
                }

                int berhasilDitambahkan = 0;
                boolean adaError = false;

                for (int i = 0; i < parts.length; i += 2) {
                    try {
                        int menuIndex = Integer.parseInt(parts[i]) - 1;
                        int quantity = Integer.parseInt(parts[i + 1]);

                        if (menuIndex < 0 || menuIndex >= menu.size()) {
                            System.out.println("❌ Menu nomor " + (menuIndex + 1) + " tidak ada!");
                            adaError = true;
                            continue;
                        }

                        if (quantity <= 0) {
                            System.out.println("❌ Quantity untuk menu " + (menuIndex + 1) + " harus > 0!");
                            adaError = true;
                            continue;
                        }

                        ItemMenu item = menu.get(menuIndex);
                        daftarPesanan.add(new Pesanan(item, quantity));
                        berhasilDitambahkan++;
                        System.out.println("✅ " + quantity + "x " + item.getNama());

                    } catch (NumberFormatException e) {
                        System.out.println("❌ Input harus angka! '" + parts[i] + "' atau '" + parts[i + 1] + "' bukan angka");
                        adaError = true;
                    }
                }

                if (berhasilDitambahkan > 0) {
                    System.out.println("\n🎉 " + berhasilDitambahkan + " item berhasil ditambahkan!");
                    tampilkanPesananSementara();
                } else if (!adaError) {
                    System.out.println("📭 Tidak ada pesanan yang ditambahkan.");
                }

                System.out.print("\n➕ Tambah pesanan lagi? (y/n): ");
                String jawaban = sessionScanner.nextLine().toLowerCase();

                if (!jawaban.equals("y") && !jawaban.equals("ya") && !jawaban.equals("yes")) {
                    tambahLagi = false;
                    System.out.println("🎉 Proses pemesanan selesai!");
                }

            } catch (Exception e) {
                System.out.println("❌ Terjadi error: " + e.getMessage());
            }
        }
    }

    public void tampilkanPesananSementara() {
        if (daftarPesanan.isEmpty()) {
            System.out.println("📭 Belum ada pesanan!");
            return;
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("           🛒 PESANAN SEMENTARA");
        System.out.println("=".repeat(50));

        //live custom hitungSubtotal
        double subtotal = hitungSubtotal();

        for (int i = 0; i < daftarPesanan.size(); i++) {
            Pesanan pesanan = daftarPesanan.get(i);
            double itemTotal = pesanan.getSubtotal();
            System.out.printf("%-2d. %-15s %2d x Rp %-8d = Rp %-8d%n",
                    i + 1,
                    pesanan.getItem().getNama(),
                    pesanan.getJumlah(),
                    (int) pesanan.getItem().getHarga(),
                    (int) itemTotal);
        }

        System.out.println("-".repeat(50));

        //live custom formatRupiah
        System.out.print("Subtotal: ");
        tampilkanDalamRupiah(subtotal, "");
        System.out.println("=".repeat(50));
    }

    public void hapusPesanan() {
        if (daftarPesanan.isEmpty()) {
            System.out.println("📭 Tidak ada pesanan untuk dihapus!");
            return;
        }

        tampilkanPesananSementara();

        try {
            System.out.print("\n🗑️  Masukkan nomor pesanan yang ingin dihapus: ");
            int nomorPesanan = scanner.nextInt() - 1;

            if (nomorPesanan >= 0 && nomorPesanan < daftarPesanan.size()) {
                Pesanan pesananDihapus = daftarPesanan.remove(nomorPesanan);
                System.out.println("✅ " + pesananDihapus.getJumlah() + "x " +
                        pesananDihapus.getItem().getNama() + " berhasil dihapus!");
            } else {
                System.out.println("❌ Nomor pesanan tidak valid!");
            }
        } catch (InputMismatchException e) {
            System.out.println("❌ Input harus berupa angka!");
            scanner.nextLine();
        }
    }

    public double hitungSubtotal() {
        //live custom hitungSubtotal
        double subtotal = 0;
        for (Pesanan pesanan : daftarPesanan) {
            subtotal += pesanan.getItem().getHarga() * pesanan.getJumlah();
        }
        return subtotal;
    }

    public double hitungDenganDiskon(double persenDiskon) {
        double subtotal = hitungSubtotal();

        //live custom hitungDiskon
        // Menghitung harga setelah diskon
        double jumlahDiskon = subtotal * (persenDiskon / 100);
        double hargaSetelahDiskon = subtotal - jumlahDiskon;

        //live custom hitungTotal
        // Menghitung total dengan pajak dan service charge
        double jumlahPajak = hargaSetelahDiskon * (persenPajak / 100);
        double jumlahService = hargaSetelahDiskon * (persenServiceCharge / 100);
        double totalAkhir = hargaSetelahDiskon + jumlahPajak + jumlahService;

        return totalAkhir;
    }

    public void tampilkanDalamRupiah(double nilai, String label) {
        if (!label.isEmpty()) {
            System.out.print(label + ": ");
        }
        System.out.printf("Rp %,-10d", (int) nilai);
    }

    public void cetakNota() {
        if (daftarPesanan.isEmpty()) {
            System.out.println("❌ Tidak ada pesanan untuk dicetak!");
            return;
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("           🧾 NOTA PEMESANAN");
        System.out.println("=".repeat(50));
        System.out.println("Tanggal: " + new Date());

        double subtotal = hitungSubtotal();

        //live custom hitungTotal
        // Menghitung total dengan pajak dan service charge
        double jumlahPajak = subtotal * (persenPajak / 100);
        double jumlahService = subtotal * (persenServiceCharge / 100);
        double totalAkhir = subtotal + jumlahPajak + jumlahService;

        for (int i = 0; i < daftarPesanan.size(); i++) {
            Pesanan pesanan = daftarPesanan.get(i);
            double totalItem = pesanan.getSubtotal();
            System.out.printf("%-2d. %-15s %2d x Rp %-8d = Rp %-8d%n",
                    i + 1,
                    pesanan.getItem().getNama(),
                    pesanan.getJumlah(),
                    (int) pesanan.getItem().getHarga(),
                    (int) totalItem);
        }

        System.out.println("-".repeat(50));

        tampilkanDalamRupiah(subtotal, "Subtotal");
        System.out.println();
        tampilkanDalamRupiah(jumlahPajak, "Pajak (" + (int) persenPajak + "%)");
        System.out.println();
        tampilkanDalamRupiah(jumlahService, "Service (" + (int) persenServiceCharge + "%)");
        System.out.println();

        System.out.println("-".repeat(50));
        tampilkanDalamRupiah(totalAkhir, "TOTAL");
        System.out.println();
        System.out.println("=".repeat(50));
        System.out.println("     Terima kasih atas kunjungan Anda! 🎉");
    }

    public static void main(String[] args) {
        SistemPemesananRestoran sistem = new SistemPemesananRestoran(10, 5);
        Scanner mainScanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("🍽️  SELAMAT DATANG DI SISTEM PEMESANAN RESTORAN!");

        while (isRunning) {
            sistem.tampilkanMenuUtama();
            System.out.print("Pilih menu (1-6): ");

            try {
                int pilihan = mainScanner.nextInt();

                switch (pilihan) {
                    case 1:
                        sistem.tampilkanMenu();
                        break;
                    case 2:
                        sistem.tambahPesananInput();
                        break;
                    case 3:
                        sistem.tampilkanPesananSementara();
                        break;
                    case 4:
                        sistem.hapusPesanan();
                        break;
                    case 5:
                        sistem.cetakNota();

                        System.out.println("\n🎁 PERHITUNGAN DENGAN DISKON 20%:");
                        double totalDenganDiskon = sistem.hitungDenganDiskon(20);
                        sistem.tampilkanDalamRupiah(totalDenganDiskon, "Total dengan diskon");
                        System.out.println();
                        break;
                    case 6:
                        System.out.println("👋 Terima kasih telah menggunakan sistem kami!");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("❌ Pilihan tidak valid! Silakan pilih 1-6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Input harus berupa angka!");
                mainScanner.nextLine();
            }
        }

        mainScanner.close();
    }
}



