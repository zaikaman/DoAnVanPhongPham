// Lớp QuanLy là một loại NguoiDung
class QuanLy extends NguoiDung {
    QuanLy(String tenDangNhap, String matKhau) {
        super(tenDangNhap, matKhau, "QuanLy");
    }

    @Override
    void nhapThongTin(Scanner scanner) {
        System.out.print("Nhap thong tin quan ly: ");
        // Add code to input information for QuanLy
    }
}