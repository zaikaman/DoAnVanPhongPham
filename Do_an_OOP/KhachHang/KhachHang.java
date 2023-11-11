// Lớp KhachHang là một loại NguoiDung
class KhachHang extends NguoiDung {
    KhachHang(String tenDangNhap, String matKhau) {
        super(tenDangNhap, matKhau, "KhachHang");
    }

    @Override
    void nhapThongTin(Scanner scanner) {
        System.out.print("Nhap ho ten: ");
        this.hoTen = scanner.nextLine();
        System.out.print("Nhap so dien thoai: ");
        this.soDienThoai = scanner.nextLine();
        System.out.print("Nhap dia chi: ");
        this.diaChi = scanner.nextLine();
    }
}