public abstract class AlatBerat {
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

    public abstract double hitungBiayaAlat(int lamaSewa);
}