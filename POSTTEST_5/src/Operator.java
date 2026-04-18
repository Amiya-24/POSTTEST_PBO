public class Operator {
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