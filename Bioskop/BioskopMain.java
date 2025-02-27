package Pertemuan3.Bioskop;

import java.util.Scanner;
import java.util.ArrayList;

public class BioskopMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        // List Film
        ArrayList<Film> daftarFilm = new ArrayList<>();
        daftarFilm.add(new Film("Avengers: Endgame", "Action", 181, "20:00", 50000));
        daftarFilm.add(new Film("Toy Story 4", "Animation", 100, "18:30", 40000));
        daftarFilm.add(new Film("The Batman", "Action", 176, "21:00", 55000));

        // Menampilkan daftar film
        System.out.println("===== Daftar Film =====");
        for (int i = 0; i < daftarFilm.size(); i++) {
            System.out.println((i + 1) + ". " + daftarFilm.get(i).getJudul() + " (" + daftarFilm.get(i).getJadwalTayang() + ")");
        }

        // Input pilihan film
        System.out.print("Pilih film (masukkan nomor): ");
        int pilihanFilm = scanner.nextInt();
        scanner.nextLine();
        if (pilihanFilm < 1 || pilihanFilm > daftarFilm.size()) {
            System.out.println("Pilihan tidak valid.");
        }
        Film filmDipilih = daftarFilm.get(pilihanFilm - 1);
        
        // Input data pelanggan
        System.out.print("Masukkan nama Anda: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan email Anda: ");
        String email = scanner.nextLine();
        System.out.print("Masukkan nomor HP Anda: ");
        String nomorHP = scanner.nextLine();

        // Membuat objek pelanggan
        Pelanggan pelanggan = new Pelanggan(1, nama, email, nomorHP);

        // Membuat tiket dan pemesanan
        Tiket tiket = new Tiket(101, filmDipilih);
        Pemesanan pemesanan = new Pemesanan(1001, pelanggan, tiket);

        // Menampilkan detail pemesanan
        pemesanan.displayDetailPemesanan();

        scanner.close();
    }
}
