public class Penyewaan implements LayananSewa {
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

    @Override
    public double hitungTotalBiaya() {
        return alatBerat.hitungBiayaAlat(lamaSewa) + (operator.getBiayaPerHari() * lamaSewa);
    }

    public double hitungTotalBiaya(double pajakPersentase) {
        double subTotal = hitungTotalBiaya();
        return subTotal + (subTotal * (pajakPersentase / 100.0));
    }

    @Override
    public void cetakStruk() {
        cetakStruk(0);
    }

    public void cetakStruk(double pajakPersentase) {
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