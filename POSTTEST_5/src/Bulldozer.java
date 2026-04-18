public class Bulldozer extends AlatBerat {
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
        double totalDasar = this.hargaSewaPerHari * lamaSewa;
        if (lamaSewa >= 5) {
            System.out.println("   [!] Diskon Bulldozer 5% diterapkan (Sewa >= 5 Hari)");
            return totalDasar * 0.95;
        }
        return totalDasar;
    }
}