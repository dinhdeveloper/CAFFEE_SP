package Models;

/**
 *
 * @author Dinh
 */
public class Ban {
    private String  tenBan, trangThai;
    private int maBan;

    public Ban() {
    }

    public Ban(int maBan,String tenBan, String trangThai) {
        this.tenBan = tenBan;
        this.trangThai = trangThai;
        this.maBan = maBan;
    }

    public String getTenBan() {
        return tenBan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public int getMaBan() {
        return maBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }
    
}   
