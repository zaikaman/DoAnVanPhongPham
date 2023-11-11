// Lớp NhanVien là một loại NguoiDung
class NhanVien extends NguoiDung {
    NhanVien(String tenDangNhap, String matKhau) {
        super(tenDangNhap, matKhau, "NhanVien");
    }

    @Override
    void nhapThongTin(Scanner scanner) {
        System.out.print("Nhap thong tin nhan vien: ");
        // Add code to input information for NhanVien
    }
}