package Models;

/**
 *
 * @author Dinh
 */
public class ThucDon {
    private String maMon, tenMon, maLoai, DVT;
    private int donGia;

    public ThucDon() {
    }

    public ThucDon(String maMon, String tenMon, String maLoai, int donGia, String DVT) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.maLoai = maLoai;
        this.DVT = DVT;
        this.donGia = donGia;
    }

    public String getMaMon() {
        return maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getDVT() {
        return DVT;
    }

    public int getDonGia() {
        return donGia;
    }

    
    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
    
}
