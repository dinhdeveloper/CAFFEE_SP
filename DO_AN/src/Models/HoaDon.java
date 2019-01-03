package Models;

import java.util.Date;

/**
 *
 * @author Dinh
 */
public class HoaDon {
    private int maHoaDon, giamGia, tongTien, trangThai ,maBan;
    private Date gioDen;

    public HoaDon() {
    }

    public HoaDon(int maHoaDon, int giamGia, int tongTien, int trangThai, int maBan, Date gioDen) {
        this.maHoaDon = maHoaDon;
        this.giamGia = giamGia;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.maBan = maBan;
        this.gioDen = gioDen;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public int getTongTien() {
        return tongTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public int getMaBan() {
        return maBan;
    }

    public Date getGioDen() {
        return gioDen;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public void setGioDen(Date gioDen) {
        this.gioDen = gioDen;
    }
    
}
