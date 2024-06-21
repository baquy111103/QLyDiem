import java.io.Serializable;

public class BangDiem implements Serializable {
    private SinhVien sinhVien;
    private MonHoc monHoc;
    private float diem;

    public BangDiem(SinhVien sinhVien, MonHoc monHoc, float diem) {
        this.sinhVien = sinhVien;
        this.monHoc = monHoc;
        this.diem = diem;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public float getDiem() {
        return diem;
    }

    @Override
    public String toString() {
        return sinhVien.getHoTen() + " - " + monHoc.getTenMon() + " - " + diem;
    }
}
