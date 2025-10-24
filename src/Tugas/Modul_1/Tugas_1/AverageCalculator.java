package Tugas.Modul_1.Tugas_1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class AverageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Masukkan jumlah angka: ");
            int n = scanner.nextInt();

            // Validasi input jumlah angka
            if (n <= 0) {
                System.out.println("Error: Jumlah angka harus lebih besar dari 0");
                return;
            }

            int[] angka = new int[n];
            System.out.println("Masukkan angka-angka: ");
            for (int i = 0; i < n; i++) {
                angka[i] = scanner.nextInt();
            }

            int total = 0;
            for (int i = 0; i < n; i++) {
                total += angka[i];
            }

            double rataRata = (double) total / n;
            System.out.println("Rata-rata adalah: " + rataRata);

        } catch (InputMismatchException e) {
            System.out.println("Error: Input harus berupa angka!");
        } catch (NegativeArraySizeException e) {
            System.out.println("Error: Jumlah angka tidak boleh negatif!");
        } catch (Exception e) {
            System.out.println("Error: Terjadi kesalahan - " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Program selesai!.");
        }
    }
}