package Tugas.Modul_1.Tugas_3;

import java.util.Scanner;

public class Kelulusan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║      SISTEM PENENTUAN KELULUSAN      ║");
        System.out.println("║             MAHASISWA                ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println();

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║             INPUT DATA               ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.print("║ Masukkan nama mahasiswa : ");
        String nama = scanner.nextLine();

        int nilaiUjian = 0;

        try {
            System.out.print("║ Masukkan nilai ujian akhir : ");
            nilaiUjian = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("╚══════════════════════════════════════╝");
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║             ⚠️  ERROR                ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║ Input harus berupa angka!            ║");
            System.out.println("╚══════════════════════════════════════╝");
            scanner.close();
            return;
        }
        System.out.println("╚══════════════════════════════════════╝");

        if (nilaiUjian < 0 || nilaiUjian > 100) {
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║             ⚠️  PERINGATAN           ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║ Nilai harus antara 0 - 100!          ║");
            System.out.printf ("║ Nilai yang dimasukkan: %-13d \n", nilaiUjian);
            System.out.println("╚══════════════════════════════════════╝");
            scanner.close();
            return;
        }

        String status = (nilaiUjian >= 60) ? "LULUS 🎓" : "TIDAK LULUS ❌";

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║           HASIL KELULUSAN            ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf("║ Nama    : %-26s \n", nama);
        System.out.printf("║ Nilai   : %-26d \n", nilaiUjian);
        System.out.printf("║ Status  : %-26s \n", status);
        System.out.println("╚══════════════════════════════════════╝");

        scanner.close();
    }
}