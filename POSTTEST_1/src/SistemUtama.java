import java.util.ArrayList;
import java.util.Scanner;

// Data Class
class AlatBerat {
    private String idAlat;
    private String namaAlat;
    private double hargaSewaPerHari;

    public AlatBerat(String idAlat, String namaAlat, double hargaSewaPerHari) {
        this.idAlat = idAlat;
        this.namaAlat = namaAlat;
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public String getIdAlat() { return idAlat; }
    public String getNamaAlat() { return namaAlat; }
    public double getHargaSewaPerHari() { return hargaSewaPerHari; }

    public void setHargaSewaPerHari(double hargaSewaPerHari) {
        this.hargaSewaPerHari = hargaSewaPerHari;
    }
}

class Operator {
    private String idOperator;
    private String namaOperator;
    private double biayaPerHari;

    public Operator(String idOperator, String namaOperator, double biayaPerHari) {
        this.idOperator = idOperator;
        this.namaOperator = namaOperator;
        this.biayaPerHari = biayaPerHari;
    }

    public String getIdOperator() { return idOperator; }
    public String getNamaOperator() { return namaOperator; }
    public double getBiayaPerHari() { return biayaPerHari; }
}

class Penyewaan {
    private String idPenyewaan;
    private AlatBerat alatBerat;
    private Operator operator;
    private int lamaSewa;

    public Penyewaan(String idPenyewaan, AlatBerat alatBerat, Operator operator, int lamaSewa) {
        this.idPenyewaan = idPenyewaan;
        this.alatBerat = alatBerat;
        this.operator = operator;
        this.lamaSewa = lamaSewa;
    }

    public String getIdPenyewaan() { return idPenyewaan; }
    public AlatBerat getAlatBerat() { return alatBerat; }
    public Operator getOperator() { return operator; }
    public int getLamaSewa() { return lamaSewa; }

    public void setLamaSewa(int lamaSewa) {
        this.lamaSewa = lamaSewa;
    }

    public double hitungTotalBiaya() {
        return (alatBerat.getHargaSewaPerHari() + operator.getBiayaPerHari()) * lamaSewa;
    }
}

public class SistemUtama {
    static ArrayList<AlatBerat> listAlat = new ArrayList<>();
    static ArrayList<Operator> listOperator = new ArrayList<>();
    static ArrayList<Penyewaan> listPenyewaan = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        listAlat.add(new AlatBerat("A01", "Excavator", 1500000));
        listAlat.add(new AlatBerat("A02", "Bulldozer", 2000000));
        
        listOperator.add(new Operator("O01", "Budi (Senior)", 500000));
        listOperator.add(new Operator("O02", "Andi (Junior)", 300000));

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=======================================================");
            System.out.println("  SISTEM PENYEWAAN ALAT BERAT & KALKULASI OPERATOR  ");
            System.out.println("=======================================================");
            System.out.println("1. Tampilkan Data Transaksi Penyewaan");
            System.out.println("2. Buat Transaksi Penyewaan Baru");
            System.out.println("3. Ubah Lama Sewa Transaksi");
            System.out.println("4. Hapus Transaksi Penyewaan");
            System.out.println("5. Keluar");
            System.out.println("=======================================================");
            System.out.print("Pilih menu (1-5): ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    readPenyewaan();
                    break;
                case 2:
                    createPenyewaan();
                    break;
                case 3:
                    updatePenyewaan();
                    break;
                case 4:
                    deletePenyewaan();
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Terima kasih telah menggunakan sistem ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    // READ
    static void readPenyewaan() {
        System.out.println("\n--- DATA TRANSAKSI PENYEWAAN ---");
        if (listPenyewaan.isEmpty()) {
            System.out.println("Belum ada data transaksi.");
        } else {
            for (Penyewaan p : listPenyewaan) {
                System.out.println("ID Transaksi : " + p.getIdPenyewaan());
                System.out.println("Alat Berat   : " + p.getAlatBerat().getNamaAlat() + " (Rp" + p.getAlatBerat().getHargaSewaPerHari() + "/hari)");
                System.out.println("Operator     : " + p.getOperator().getNamaOperator() + " (Rp" + p.getOperator().getBiayaPerHari() + "/hari)");
                System.out.println("Lama Sewa    : " + p.getLamaSewa() + " Hari");
                System.out.println("Total Biaya  : Rp" + p.hitungTotalBiaya());
                System.out.println("---------------------------------");
            }
        }
    }

    // CREATE
    static void createPenyewaan() {
        System.out.println("\n--- BUAT TRANSAKSI BARU ---");
        System.out.print("Masukkan ID Transaksi Baru (contoh: T01): ");
        String id = scanner.nextLine();

        System.out.println("\nPilih Alat Berat:");
        for (int i = 0; i < listAlat.size(); i++) {
            System.out.println((i + 1) + ". " + listAlat.get(i).getNamaAlat());
        }
        System.out.print("Masukkan nomor pilihan alat: ");
        int indexAlat = scanner.nextInt() - 1;

        System.out.println("\nPilih Operator:");
        for (int i = 0; i < listOperator.size(); i++) {
            System.out.println((i + 1) + ". " + listOperator.get(i).getNamaOperator());
        }
        System.out.print("Masukkan nomor pilihan operator: ");
        int indexOperator = scanner.nextInt() - 1;

        System.out.print("\nMasukkan Lama Sewa (hari): ");
        int lama = scanner.nextInt();
        scanner.nextLine();

        if (indexAlat >= 0 && indexAlat < listAlat.size() && indexOperator >= 0 && indexOperator < listOperator.size()) {
            Penyewaan sewaBaru = new Penyewaan(id, listAlat.get(indexAlat), listOperator.get(indexOperator), lama);
            listPenyewaan.add(sewaBaru);
            System.out.println("Transaksi berhasil ditambahkan!");
        } else {
            System.out.println("Gagal menambahkan. Pilihan alat/operator tidak valid.");
        }
    }

    // UPDATE
    static void updatePenyewaan() {
        System.out.println("\n--- UPDATE DATA TRANSAKSI ---");
        readPenyewaan();
        if (listPenyewaan.isEmpty()) return;

        System.out.print("Masukkan ID Transaksi yang ingin diubah lama sewanya: ");
        String id = scanner.nextLine();

        boolean ditemukan = false;
        for (Penyewaan p : listPenyewaan) {
            if (p.getIdPenyewaan().equalsIgnoreCase(id)) {
                System.out.print("Masukkan lama sewa baru (hari): ");
                int lamaBaru = scanner.nextInt();
                scanner.nextLine();
                p.setLamaSewa(lamaBaru);
                ditemukan = true;
                System.out.println("Data berhasil diperbarui! Total biaya akan dikalkulasi ulang.");
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Transaksi dengan ID " + id + " tidak ditemukan.");
        }
    }

    // DELETE
    static void deletePenyewaan() {
        System.out.println("\n--- HAPUS DATA TRANSAKSI ---");
        readPenyewaan();
        if (listPenyewaan.isEmpty()) return;

        System.out.print("Masukkan ID Transaksi yang ingin dihapus: ");
        String id = scanner.nextLine();

        boolean dihapus = listPenyewaan.removeIf(p -> p.getIdPenyewaan().equalsIgnoreCase(id));

        if (dihapus) {
            System.out.println("Transaksi berhasil dihapus.");
        } else {
            System.out.println("Transaksi dengan ID " + id + " tidak ditemukan.");
        }
    }
}