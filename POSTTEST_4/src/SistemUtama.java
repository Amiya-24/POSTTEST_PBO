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

    public double hitungBiayaAlat(int lamaSewa) {
        return this.hargaSewaPerHari * lamaSewa;
    }
}

class Excavator extends AlatBerat {
    private double kapasitasBucket; 

    public Excavator(String idAlat, String namaAlat, double hargaSewaPerHari, double kapasitasBucket) {
        super(idAlat, namaAlat, hargaSewaPerHari);
        this.kapasitasBucket = kapasitasBucket;
    }

    @Override
    protected void cetakInfoAlat() {
        super.cetakInfoAlat();
        System.out.println("Spesifikasi  : Kapasitas Bucket " + this.kapasitasBucket + " m3");
    }

    @Override
    public double hitungBiayaAlat(int lamaSewa) {
        double totalDasar = super.hitungBiayaAlat(lamaSewa);
        if (lamaSewa >= 7) {
            System.out.println("   [!] Diskon Excavator 10% diterapkan (Sewa >= 7 Hari)");
            return totalDasar * 0.90; 
        }
        return totalDasar;
    }
}

class Bulldozer extends AlatBerat {
    private String tipeBlade; 

    public Bulldozer(String idAlat, String namaAlat, double hargaSewaPerHari, String tipeBlade) {
        super(idAlat, namaAlat, hargaSewaPerHari);
        this.tipeBlade = tipeBlade;
    }

    @Override
    protected void cetakInfoAlat() {
        super.cetakInfoAlat();
        System.out.println("Spesifikasi  : Tipe Blade " + this.tipeBlade);
    }

    @Override
    public double hitungBiayaAlat(int lamaSewa) {
        double totalDasar = super.hitungBiayaAlat(lamaSewa);
        if (lamaSewa >= 5) {
            System.out.println("   [!] Diskon Bulldozer 5% diterapkan (Sewa >= 5 Hari)");
            return totalDasar * 0.95;
        }
        return totalDasar;
    }
}

class Crane extends AlatBerat {
    private double kapasitasAngkat; 

    public Crane(String idAlat, String namaAlat, double hargaSewaPerHari, double kapasitasAngkat) {
        super(idAlat, namaAlat, hargaSewaPerHari);
        this.kapasitasAngkat = kapasitasAngkat;
    }

    @Override
    protected void cetakInfoAlat() {
        super.cetakInfoAlat();
        System.out.println("Spesifikasi  : Kapasitas Angkat " + this.kapasitasAngkat + " Ton");
    }

    @Override
    public double hitungBiayaAlat(int lamaSewa) {
        double totalDasar = super.hitungBiayaAlat(lamaSewa);
        if (lamaSewa >= 3) {
            System.out.println("   [!] Diskon Spesial Crane 15% diterapkan (Sewa >= 3 Hari)");
            return totalDasar * 0.85;
        }
        return totalDasar;
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

    protected void cetakInfoOperator() {
        System.out.println("Operator     : [" + this.idOperator + "] " + this.namaOperator + " (Rp" + this.biayaPerHari + "/hari)");
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
    public void setAlatBerat(AlatBerat alatBerat) { this.alatBerat = alatBerat; }
    public void setOperator(Operator operator) { this.operator = operator; }
    public void setLamaSewa(int lamaSewa) { this.lamaSewa = lamaSewa; }

    public double hitungTotalBiaya() {
        return alatBerat.hitungBiayaAlat(lamaSewa) + (operator.getBiayaPerHari() * lamaSewa);
    }

    public double hitungTotalBiaya(double pajakPersentase) {
        double subTotal = hitungTotalBiaya();
        return subTotal + (subTotal * (pajakPersentase / 100.0));
    }

    protected void cetakStruk() {
        cetakStruk(0);
    }

    protected void cetakStruk(double pajakPersentase) {
        System.out.println("ID Transaksi : " + this.idPenyewaan);
        this.alatBerat.cetakInfoAlat();
        this.operator.cetakInfoOperator();
        System.out.println("Lama Sewa    : " + this.lamaSewa + " Hari");
        
        double subTotal = hitungTotalBiaya();
        if (pajakPersentase > 0) {
            double nominalPajak = subTotal * (pajakPersentase / 100.0);
            System.out.println("Sub-Total    : Rp" + subTotal);
            System.out.println("Pajak ("+pajakPersentase+"%) : Rp" + nominalPajak);
            System.out.println("Total Bayar  : Rp" + hitungTotalBiaya(pajakPersentase));
        } else {
            System.out.println("Total Bayar  : Rp" + subTotal);
        }
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
        listAlat.add(new Crane("A03", "Mobile Crane Kato", 3500000, 25.0)); 
        
        listOperator.add(new Operator("O01", "Budi (Senior)", 500000));
        listOperator.add(new Operator("O02", "Andi (Junior)", 300000));

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n==================================================================");
            System.out.println("  SISTEM MANAJEMEN PENYEWAAN ALAT BERAT & KALKULASI BIAYA OPERATOR  ");
            System.out.println("==================================================================");
            System.out.println("1. Tampilkan Data Transaksi Penyewaan");
            System.out.println("2. Buat Transaksi Penyewaan Baru");
            System.out.println("3. Ubah Lama Sewa/Data Transaksi");
            System.out.println("4. Hapus Transaksi Penyewaan");
            System.out.println("5. Keluar");
            System.out.println("==================================================================");
            System.out.print("Pilih menu (1-5): ");
            
            int pilihan = 0;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Harap masukkan angka (1-5).");
                continue;
            }

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
            return;
        } 
        
        System.out.println("Opsi Tampilan:");
        System.out.println("1. Struk Biasa");
        System.out.println("2. Struk dengan PPN 11%");
        System.out.print("Pilih (1/2): ");
        String opsi = scanner.nextLine();

        System.out.println("\n---------------------------------");
        for (Penyewaan p : listPenyewaan) {
            if (opsi.equals("2")) {
                p.cetakStruk(11.0);
            } else {
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
        
        int indexAlat = -1;
        while (true) {
            System.out.print("Masukkan nomor pilihan alat: ");
            try {
                indexAlat = Integer.parseInt(scanner.nextLine()) - 1;
                break; 
            } catch (NumberFormatException e) {
                System.out.println("Harap masukkan angka!");
            }
        }

        System.out.println("\nPilih Operator:");
        for (int i = 0; i < listOperator.size(); i++) {
            System.out.println((i + 1) + ". [" + listOperator.get(i).getIdOperator() + "] " + listOperator.get(i).getNamaOperator());
        }

        
        int indexOperator = -1;
        while (true) {
            System.out.print("Masukkan nomor pilihan operator: ");
            try {
                indexOperator = Integer.parseInt(scanner.nextLine()) - 1;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Harap masukkan angka!");
            }
        }

        int lama = 0;
        while (true) {
            System.out.print("\nMasukkan Lama Sewa (hari): ");
            try {
                lama = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Harap masukkan angka untuk lama sewa!");
            }
        }

        if (indexAlat >= 0 && indexAlat < listAlat.size() && indexOperator >= 0 && indexOperator < listOperator.size() && lama > 0) {
            Penyewaan sewaBaru = new Penyewaan(id, listAlat.get(indexAlat), listOperator.get(indexOperator), lama);
            listPenyewaan.add(sewaBaru);
            System.out.println("Transaksi berhasil ditambahkan!");
        } else {
            System.out.println("Gagal menambahkan. Pilihan alat/operator di luar daftar atau hari tidak valid.");
        }
    }

    private static void updatePenyewaan() {
        System.out.println("\n--- UPDATE DATA TRANSAKSI ---");
        if (listPenyewaan.isEmpty()) {
            System.out.println("Belum ada data transaksi.");
            return;
        }

        System.out.print("Masukkan ID Transaksi yang ingin diubah: ");
        String id = scanner.nextLine();

        boolean ditemukan = false;
        for (Penyewaan p : listPenyewaan) {
            if (p.getIdPenyewaan().equalsIgnoreCase(id)) {
                ditemukan = true;
                boolean isUpdating = true;
                
                while(isUpdating) {
                    System.out.println("\n--- Data Transaksi Saat Ini ---");
                    p.cetakStruk();
                    
                    System.out.println("Pilih data yang ingin diubah:");
                    System.out.println("1. Alat Berat");
                    System.out.println("2. Operator");
                    System.out.println("3. Lama Sewa");
                    System.out.println("4. Selesai / Simpan Perubahan");
                    System.out.print("Pilih opsi (1-4): ");
                    
                    int opsi = 0;
                    try {
                        opsi = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Harap masukkan angka!");
                        continue;
                    }

                    switch(opsi) {
                        case 1:
                            System.out.println("\nPilih Alat Berat Baru:");
                            for (int i = 0; i < listAlat.size(); i++) {
                                System.out.println((i + 1) + ". " + listAlat.get(i).getNamaAlat());
                            }
                            System.out.print("Masukkan nomor pilihan alat: ");
                            int indexAlat = Integer.parseInt(scanner.nextLine()) - 1;
                            
                            if (indexAlat >= 0 && indexAlat < listAlat.size()) {
                                p.setAlatBerat(listAlat.get(indexAlat));
                                System.out.println("Alat Berat diperbarui!");
                            } else { System.out.println("Pilihan alat tidak valid."); }
                            break;

                        case 2:
                            System.out.println("\nPilih Operator Baru:");
                            for (int i = 0; i < listOperator.size(); i++) {
                                System.out.println((i + 1) + ". [" + listOperator.get(i).getIdOperator() + "] " + listOperator.get(i).getNamaOperator());
                            }
                            
                            System.out.print("Masukkan nomor pilihan operator: ");
                            int indexOperator = Integer.parseInt(scanner.nextLine()) - 1;
                            
                            if (indexOperator >= 0 && indexOperator < listOperator.size()) {
                                p.setOperator(listOperator.get(indexOperator));
                                System.out.println("Operator diperbarui!");
                            } else { System.out.println("Pilihan operator tidak valid."); }
                            break;

                        case 3:
                            System.out.print("\nMasukkan lama sewa baru (hari): ");
                            int lamaBaru = Integer.parseInt(scanner.nextLine());
                            if (lamaBaru > 0) {
                                p.setLamaSewa(lamaBaru);
                                System.out.println("Lama Sewa diperbarui!");
                            } else { System.out.println("Lama sewa tidak valid."); }
                            break;

                        case 4:
                            isUpdating = false; 
                            System.out.println("Selesai memperbarui.");
                            break;

                        default:
                            System.out.println("Pilihan tidak valid.");
                    }
                }
                break; 
            }
        }

        if (!ditemukan) { System.out.println("Transaksi dengan ID '" + id + "' tidak ditemukan."); }
    }

    private static void deletePenyewaan() {
        System.out.println("\n--- HAPUS DATA TRANSAKSI ---");
        if (listPenyewaan.isEmpty()) {
            System.out.println("Belum ada data transaksi.");
            return;
        }

        System.out.print("Masukkan ID Transaksi yang ingin dihapus: ");
        String id = scanner.nextLine();

        boolean dihapus = listPenyewaan.removeIf(p -> p.getIdPenyewaan().equalsIgnoreCase(id));

        if (dihapus) {
            System.out.println("Transaksi berhasil dihapus.");
        } else {
            System.out.println("Transaksi dengan ID '" + id + "' tidak ditemukan.");
        }
    }
}