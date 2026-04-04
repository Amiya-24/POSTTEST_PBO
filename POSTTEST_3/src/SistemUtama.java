import java.util.ArrayList;
import java.util.Scanner;

class AlatBerat {
    protected String idAlat;
    protected String namaAlat;
    protected double hargaSewaPerHari;

    public AlatBerat(String idAlat, String namaAlat, double hargaSewaPerHari) {
        this.idAlat = idAlat;
        this.namaAlat = namaAlat;
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public String getIdAlat() { return idAlat; }
    public void setIdAlat(String idAlat) { this.idAlat = idAlat; }

    public String getNamaAlat() { return namaAlat; }
    public void setNamaAlat(String namaAlat) { this.namaAlat = namaAlat; }

    public double getHargaSewaPerHari() { return hargaSewaPerHari; }
    public void setHargaSewaPerHari(double hargaSewaPerHari) { this.hargaSewaPerHari = hargaSewaPerHari; }

    protected void cetakInfoAlat() {
        System.out.println("Alat Berat   : " + this.namaAlat + " (Rp" + this.hargaSewaPerHari + "/hari)");
    }
}

class Excavator extends AlatBerat {
    private double kapasitasBucket;

    public Excavator(String idAlat, String namaAlat, double hargaSewaPerHari, double kapasitasBucket) {
        super(idAlat, namaAlat, hargaSewaPerHari);
        this.kapasitasBucket = kapasitasBucket;
    }

    public double getKapasitasBucket() { return kapasitasBucket; }
    public void setKapasitasBucket(double kapasitasBucket) { this.kapasitasBucket = kapasitasBucket; }

    @Override
    protected void cetakInfoAlat() {
        super.cetakInfoAlat();
        System.out.println("Spesifikasi  : Kapasitas Bucket " + this.kapasitasBucket + " m3");
    }
}

class Bulldozer extends AlatBerat {
    private String tipeBlade; 

    public Bulldozer(String idAlat, String namaAlat, double hargaSewaPerHari, String tipeBlade) {
        super(idAlat, namaAlat, hargaSewaPerHari);
        this.tipeBlade = tipeBlade;
    }

    public String getTipeBlade() { return tipeBlade; }
    public void setTipeBlade(String tipeBlade) { this.tipeBlade = tipeBlade; }

    @Override
    protected void cetakInfoAlat() {
        super.cetakInfoAlat();
        System.out.println("Spesifikasi  : Tipe Blade " + this.tipeBlade);
    }
}

class Crane extends AlatBerat {
    private double kapasitasAngkat;

    public Crane(String idAlat, String namaAlat, double hargaSewaPerHari, double kapasitasAngkat) {
        super(idAlat, namaAlat, hargaSewaPerHari);
        this.kapasitasAngkat = kapasitasAngkat;
    }

    public double getKapasitasAngkat() { return kapasitasAngkat; }
    public void setKapasitasAngkat(double kapasitasAngkat) { this.kapasitasAngkat = kapasitasAngkat; }

    @Override
    protected void cetakInfoAlat() {
        super.cetakInfoAlat();
        System.out.println("Spesifikasi  : Kapasitas Angkat " + this.kapasitasAngkat + " Ton");
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
    public void setIdOperator(String idOperator) { this.idOperator = idOperator; }

    public String getNamaOperator() { return namaOperator; }
    public void setNamaOperator(String namaOperator) { this.namaOperator = namaOperator; }

    public double getBiayaPerHari() { return biayaPerHari; }
    public void setBiayaPerHari(double biayaPerHari) { this.biayaPerHari = biayaPerHari; }

    protected void cetakInfoOperator() {
        System.out.println("Operator     : " + this.namaOperator + " (Rp" + this.biayaPerHari + "/hari)");
    }
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
    public void setIdPenyewaan(String idPenyewaan) { this.idPenyewaan = idPenyewaan; }

    public AlatBerat getAlatBerat() { return alatBerat; }
    public void setAlatBerat(AlatBerat alatBerat) { this.alatBerat = alatBerat; }

    public Operator getOperator() { return operator; }
    public void setOperator(Operator operator) { this.operator = operator; }

    public int getLamaSewa() { return lamaSewa; }
    public void setLamaSewa(int lamaSewa) { this.lamaSewa = lamaSewa; }

    public double hitungTotalBiaya() {
        return (alatBerat.getHargaSewaPerHari() + operator.getBiayaPerHari()) * lamaSewa;
    }

    protected void cetakStruk() {
        System.out.println("ID Transaksi : " + this.idPenyewaan);
        this.alatBerat.cetakInfoAlat();
        this.operator.cetakInfoOperator();
        System.out.println("Lama Sewa    : " + this.lamaSewa + " Hari");
        System.out.println("Total Biaya  : Rp" + hitungTotalBiaya());
        System.out.println("---------------------------------");
    }
}

public class SistemUtama {
    private static ArrayList<AlatBerat> listAlat = new ArrayList<>();
    private static ArrayList<Operator> listOperator = new ArrayList<>();
    private static ArrayList<Penyewaan> listPenyewaan = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        listAlat.add(new Excavator("A01", "Excavator CAT 320", 1500000, 1.2));
        listAlat.add(new Bulldozer("A02", "Bulldozer Komatsu D85", 2000000, "Semi-U Blade"));
        listAlat.add(new Crane("A03", "Mobile Crane Kato", 3500000, 25.0)); // Tambahan Crane
        
        listOperator.add(new Operator("O01", "Budi (Senior)", 500000));
        listOperator.add(new Operator("O02", "Andi (Junior)", 300000));

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n==================================================================");
            System.out.println("  SISTEM MANAJEMEN PENYEWAAN ALAT BERAT & KALKULASI BIAYA OPERATOR  ");
            System.out.println("==================================================================");
            System.out.println("1. Tampilkan Data Transaksi Penyewaan");
            System.out.println("2. Buat Transaksi Penyewaan Baru");
            System.out.println("3. Ubah Lama Sewa Transaksi");
            System.out.println("4. Hapus Transaksi Penyewaan");
            System.out.println("5. Keluar");
            System.out.println("==================================================================");
            System.out.print("Pilih menu (1-5): ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1: readPenyewaan(); break;
                case 2: createPenyewaan(); break;
                case 3: updatePenyewaan(); break;
                case 4: deletePenyewaan(); break;
                case 5:
                    isRunning = false;
                    System.out.println("Terima kasih telah menggunakan sistem ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void readPenyewaan() {
        System.out.println("\n--- DATA TRANSAKSI PENYEWAAN ---");
        if (listPenyewaan.isEmpty()) {
            System.out.println("Belum ada data transaksi.");
        } else {
            for (Penyewaan p : listPenyewaan) {
                p.cetakStruk();
            }
        }
    }

    private static void createPenyewaan() {
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

    private static void updatePenyewaan() {
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

    private static void deletePenyewaan() {
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