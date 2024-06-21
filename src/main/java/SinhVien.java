import java.io.Serializable;

public class SinhVien implements Serializable {
    private static int currentId = 10000;
    private int maSV;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private String lop;

    public SinhVien(String hoTen, String diaChi, String sdt, String lop) {
        this.maSV = currentId++;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.lop = lop;
    }

    public int getMaSV() {
        return maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    @Override
    public String toString() {
        return maSV + " - " + hoTen + " - " + diaChi + " - " + sdt + " - " + lop;
    }
}
