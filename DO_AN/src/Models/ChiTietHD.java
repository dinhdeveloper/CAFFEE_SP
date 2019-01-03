package Models;

/**
 *
 * @author Dinh
 */
public class ChiTietHD {
    private int maChiTietHD, maHoaDon, soLuong, gia;
    private String maMon;

    public ChiTietHD() {
    }

    public ChiTietHD(int maChiTietHD, int maHoaDon,String maMon, int soLuong, int gia ) {
        this.maChiTietHD = maChiTietHD;
        this.maHoaDon = maHoaDon;
        this.soLuong = soLuong;
        this.gia = gia;
        this.maMon = maMon;
    }

    public int getMaChiTietHD() {
        return maChiTietHD;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getGia() {
        return gia;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaChiTietHD(int maChiTietHD) {
        this.maChiTietHD = maChiTietHD;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }
    
}
