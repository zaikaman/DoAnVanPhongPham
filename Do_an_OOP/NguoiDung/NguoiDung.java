// Lớp cơ sở NguoiDung chứa thông tin chung
abstract class NguoiDung {
    String tenDangNhap;
    String matKhau;
    String vaiTro;
    String hoTen;
    String soDienThoai;
    String diaChi;
    String maNguoiDung;

    NguoiDung(String tenDangNhap, String matKhau, String vaiTro) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.maNguoiDung = generateUserID();
    }

    // Phương thức để lấy mã người dùng
    public String getMaNguoiDung() {
        return maNguoiDung;
    }

    // Phương thức để lấy họ tên
    public String getHoTen() {
        return hoTen;
    }

    abstract void nhapThongTin(Scanner scanner);

    private String generateUserID() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder userID = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            userID.append(characters.charAt(random.nextInt(characters.length())));
        }

        return userID.toString();
    }
}