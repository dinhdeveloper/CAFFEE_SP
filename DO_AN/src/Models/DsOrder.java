package Models;

/**
 *
 * @author Dinh
 */
public class DsOrder {
    private String tenMon, maMon, DVT; 
    private int gia, soLuong, maHoaDon;

    public DsOrder() {
    }

    public DsOrder(String tenMon, String maMon, String DVT, int gia, int soLuong, int maHoaDon) {
        this.tenMon = tenMon;
        this.maMon = maMon;
        this.DVT = DVT;
        this.gia = gia;
        this.soLuong = soLuong;
        this.maHoaDon = maHoaDon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public String getMaMon() {
        return maMon;
    }

    public String getDVT() {
        return DVT;
    }

    public int getGia() {
        return gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
    
}
