package Modul_1.Codelab_1;

import java.util.ArrayList;

public class CodeLab1 {
    public static void main(String[] args) {
        String[] nama = {"Adi", "Budi", "Cahyo", "Diana", "Keysaaaaaaaaa"};
        ArrayList<String> namaTerpanjang = cariNamaTerpanjang(nama);
        System.out.println("Nama terpanjang adalah: " + namaTerpanjang);
    }

    public static ArrayList<String> cariNamaTerpanjang(String[] array) {
        ArrayList<String> result = new ArrayList<>();
        int maxLength = 0;

        for (String nama : array) {
            if (nama.length() > maxLength) {
                maxLength = nama.length();
                result.clear();
                result.add(nama);
            } else if (nama.length() == maxLength) {
                result.add(nama);
            }
        }
        return result;
    }
}