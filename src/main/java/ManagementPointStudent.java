import java.io.*;
import java.util.Scanner;

public class ManagementPointStudent {
    private static SinhVien[] sinhViens = new SinhVien[100];
    private static MonHoc[] monHocs = new MonHoc[100];
    private static BangDiem[] bangDiems = new BangDiem[100];
    private static int sinhVienCount = 0;
    private static int monHocCount = 0;
    private static int bangDiemCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadData();
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Nhập danh sách sinh viên mới.");
            System.out.println("2. Nhập danh sách môn học mới.");
            System.out.println("3. Nhập điểm cho mỗi sinh viên.");
            System.out.println("4. Sắp xếp danh sách Bảng điểm.");
            System.out.println("5. Tính điểm tổng kết chung cho mỗi sinh viên.");
            System.out.println("0. Thoát.");
            int choice = Integer.parseInt(scanner.nextLine());
            try {
                switch (choice) {
                    case 1:
                        nhapSinhVienMoi();
                        inDanhSachSinhVien();
                        break;
                    case 2:
                        nhapMonHocMoi();
                        inDanhSachMonHoc();
                        break;
                    case 3:
                        nhapDiem();
                        inBangDiem();
                        break;
                    case 4:
                        sapXepBangDiem();
                        inBangDiem();
                        break;
                    case 5:
                        tinhDiemTongKet();
                        break;
                    case 0:
                        saveData();
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        }
    }

    private static void nhapSinhVienMoi() {
        System.out.println("Nhập số lượng sinh viên mới:");
        int soLuongSinhVienMoi = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < soLuongSinhVienMoi; i++) {
            System.out.println("Nhập thông tin sinh viên " + (i + 1));
            System.out.print("Họ tên: ");
            String hoTen = scanner.nextLine();
            System.out.print("Địa chỉ: ");
            String diaChi = scanner.nextLine();
            System.out.print("SĐT: ");
            String sdt = scanner.nextLine();
            System.out.print("Lớp: ");
            String lop = scanner.nextLine();
            sinhViens[sinhVienCount++] = new SinhVien(hoTen, diaChi, sdt, lop);
        }
    }

    private static void inDanhSachSinhVien() {
        System.out.println("Danh sách sinh viên:");
        for (int i = 0; i < sinhVienCount; i++) {
            System.out.println(sinhViens[i]);
        }
    }

    private static void nhapMonHocMoi() {
        System.out.println("Nhập số lượng môn học mới:");
        int soLuongMonHocMoi = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < soLuongMonHocMoi; i++) {
            System.out.println("Nhập thông tin môn học " + (i + 1));
            System.out.print("Tên môn: ");
            String tenMon = scanner.nextLine();
            System.out.print("Số đơn vị học trình: ");
            int soDonViHocTrinh = Integer.parseInt(scanner.nextLine());
            System.out.print("Loại môn (Đại cương, Cơ sở ngành, Chuyên ngành): ");
            String loaiMon = scanner.nextLine();
            monHocs[monHocCount++] = new MonHoc(tenMon, soDonViHocTrinh, loaiMon);
        }
    }

    private static void inDanhSachMonHoc() {
        System.out.println("Danh sách môn học:");
        for (int i = 0; i < monHocCount; i++) {
            System.out.println(monHocs[i]);
        }
    }

    private static void nhapDiem() {
        System.out.println("Nhập mã sinh viên:");
        int maSV = Integer.parseInt(scanner.nextLine());
        SinhVien sinhVien = null;
        for (int i = 0; i < sinhVienCount; i++) {
            if (sinhViens[i].getMaSV() == maSV) {
                sinhVien = sinhViens[i];
                break;
            }
        }
        if (sinhVien == null) {
            System.out.println("Không tìm thấy sinh viên!");
            return;
        }
        while (true) {
            System.out.println("Nhập mã môn học muốn nhập điểm (0 để kết thúc):");
            int maMon = Integer.parseInt(scanner.nextLine());
            if (maMon == 0) break;
            MonHoc monHoc = null;
            for (int i = 0; i < monHocCount; i++) {
                if (monHocs[i].getMaMon() == maMon) {
                    monHoc = monHocs[i];
                    break;
                }
            }
            if (monHoc == null) {
                System.out.println("Không tìm thấy môn học!");
                continue;
            }
            System.out.print("Nhập điểm: ");
            float diem = Float.parseFloat(scanner.nextLine());
            if (diem < 0 || diem > 10) {
                System.out.println("Điểm không hợp lệ!");
                continue;
            }
            bangDiems[bangDiemCount++] = new BangDiem(sinhVien, monHoc, diem);
        }
    }

    private static void inBangDiem() {
        System.out.println("Bảng điểm:");
        for (int i = 0; i < bangDiemCount; i++) {
            System.out.println(bangDiems[i]);
        }
    }

    private static void sapXepBangDiem() {
        System.out.println("Sắp xếp bảng điểm theo:");
        System.out.println("1. Họ tên sinh viên");
        System.out.println("2. Tên môn học");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            for (int i = 0; i < bangDiemCount - 1; i++) {
                for (int j = i + 1; j < bangDiemCount; j++) {
                    if (bangDiems[i].getSinhVien().getHoTen().compareTo(bangDiems[j].getSinhVien().getHoTen()) > 0) {
                        BangDiem temp = bangDiems[i];
                        bangDiems[i] = bangDiems[j];
                        bangDiems[j] = temp;
                    }
                }
            }
        } else if (choice == 2) {
            for (int i = 0; i < bangDiemCount - 1; i++) {
                for (int j = i + 1; j < bangDiemCount; j++) {
                    if (bangDiems[i].getMonHoc().getTenMon().compareTo(bangDiems[j].getMonHoc().getTenMon()) > 0) {
                        BangDiem temp = bangDiems[i];
                        bangDiems[i] = bangDiems[j];
                        bangDiems[j] = temp;
                    }
                }
            }
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    private static void tinhDiemTongKet() {
        for (int i = 0; i < sinhVienCount; i++) {
            SinhVien sv = sinhViens[i];
            float tongDiem = 0;
            int tongDonViHocTrinh = 0;
            for (int j = 0; j < bangDiemCount; j++) {
                if (bangDiems[j].getSinhVien().getMaSV() == sv.getMaSV()) {
                    tongDiem += bangDiems[j].getDiem() * bangDiems[j].getMonHoc().getSoDonViHocTrinh();
                    tongDonViHocTrinh += bangDiems[j].getMonHoc().getSoDonViHocTrinh();
                }
            }
            float diemTongKet = tongDiem / tongDonViHocTrinh;
            System.out.println("Sinh viên: " + sv.getHoTen() + " - Điểm tổng kết: " + diemTongKet);
        }
    }

    private static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.dat"))) {
            oos.writeObject(sinhViens);
            oos.writeObject(monHocs);
            oos.writeObject(bangDiems);
            oos.writeInt(sinhVienCount);
            oos.writeInt(monHocCount);
            oos.writeInt(bangDiemCount);
            System.out.println("Dữ liệu đã được lưu thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu dữ liệu: " + e.getMessage());
        }
    }

    private static void loadData() {
        File file = new File("data.dat");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.dat"))) {
                sinhViens = (SinhVien[]) ois.readObject();
                monHocs = (MonHoc[]) ois.readObject();
                bangDiems = (BangDiem[]) ois.readObject();
                sinhVienCount = ois.readInt();
                monHocCount = ois.readInt();
                bangDiemCount = ois.readInt();
                System.out.println("Dữ liệu đã được tải thành công!");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Lỗi khi tải dữ liệu: " + e.getMessage());
            }
        }
    }
}
