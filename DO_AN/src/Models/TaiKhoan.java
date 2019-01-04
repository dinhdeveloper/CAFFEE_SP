package Models;

/**
 *
 * @author Dinh
 */
public class TaiKhoan {
    private int id, lv;
    private String userName,passWord,fullName;

    public TaiKhoan() {
    }

    public TaiKhoan(int id, String userName, String passWord,int lv,String fullName) {
        this.id = id;
        this.lv = lv;
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
    }
    

    public int getId() {
        return id;
    }

    public int getLv() {
        return lv;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getFullName() {
        return fullName;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void getFullTaiKhoan(String userName, String passWord,int lv,String fullName){
        this.lv = lv;
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
    }
}
