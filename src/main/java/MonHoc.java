import java.io.Serializable;

public class MonHoc implements Serializable {
    private static int currentId = 100;
    private int maMon;
    private String tenMon;
    private int soDonViHocTrinh;
    private String loaiMon;

    public MonHoc(String tenMon, int soDonViHocTrinh, String loaiMon) {
        this.maMon = currentId++;
        this.tenMon = tenMon;
        this.soDonViHocTrinh = soDonViHocTrinh;
        this.loaiMon = loaiMon;
    }

    public int getMaMon() {
        return maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public int getSoDonViHocTrinh() {
        return soDonViHocTrinh;
    }

    @Override
    public String toString() {
        return maMon + " - " + tenMon + " - " + soDonViHocTrinh + " - " + loaiMon;
    }
}
