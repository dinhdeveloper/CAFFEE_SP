package Models;

/**
 *
 * @author Dinh
 */
public class Loai {
    private String maLoai, tenLoai, mauSac;

    public Loai() {
    }

    public Loai(String maLoai, String tenLoai, String mauSac) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.mauSac = mauSac;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }
    
}
