// Lớp TaiKhoan quản lý đăng ký và đăng nhập người dùng
class TaiKhoan {
    NguoiDung[] nguoiDung = new NguoiDung[100]; // Sử dụng mảng cố định với một kích thước tối đa
    int soLuongNguoiDung = 0; // Biến để theo dõi số lượng người dùng
    String tenFile = "nguoidung.txt";
    DonHang[] donHang = new DonHang[100]; // Mảng để lưu trữ đơn hàng
    int soLuongDonHang = 0; // Biến đếm số lượng đơn hàng

    void dangKy(NguoiDung nguoiDung) throws IOException {
        docDanhSachNguoiDung(); // Đọc danh sách tài khoản từ tệp trước khi thêm tài khoản mới

        for (int i = 0; i < soLuongNguoiDung; i++) {
            if (this.nguoiDung[i].tenDangNhap.equals(nguoiDung.tenDangNhap)) {
                System.out.println("Ten dang nhap da ton tai. Vui long chon mot ten dang nhap khac");
                return; // Không thực hiện đăng ký nếu tên đăng nhập đã tồn tại
            }
        }

        this.nguoiDung[soLuongNguoiDung] = nguoiDung;
        soLuongNguoiDung++;

        ghiDanhSachNguoiDung(); // Ghi danh sách tài khoản mới vào tệp

        System.out.println("Dang ky thanh cong!");
    }

    void docThongTinNguoiDung(KhachHang khachHang) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("thongtin.txt"));
        String line;
   
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 5 && parts[1].equals(khachHang.tenDangNhap)) {
                khachHang.maNguoiDung = parts[0];
                khachHang.hoTen = parts[2];
                khachHang.soDienThoai = parts[3];
                khachHang.diaChi = parts[4];
                break;
            }
        }
   
        reader.close();
    }    

    void docDanhSachNguoiDung() throws IOException {
        File file = new File(tenFile);

        if (!file.exists()) {
           file.createNewFile();
        }
        BufferedReader reader = new BufferedReader(new FileReader(tenFile));
        String line;
        soLuongNguoiDung = 0; // Đặt lại biến đếm

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                if ("KhachHang".equals(parts[2])) {
                    this.nguoiDung[soLuongNguoiDung] = new KhachHang(parts[0], parts[1]);
                } else if ("NhanVien".equals(parts[2])) {
                    this.nguoiDung[soLuongNguoiDung] = new NhanVien(parts[0], parts[1]);
                } else if ("QuanLy".equals(parts[2])) {
                    this.nguoiDung[soLuongNguoiDung] = new QuanLy(parts[0], parts[1]);
                }
                soLuongNguoiDung++;
            }
        }
        reader.close();
    }

    void ghiDanhSachNguoiDung() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(tenFile));
        for (int i = 0; i < soLuongNguoiDung; i++) {
            writer.write(nguoiDung[i].tenDangNhap + "," + nguoiDung[i].matKhau + "," + nguoiDung[i].vaiTro + "\n");
        }
        writer.close();
    }

    boolean dangNhap(String tenDangNhap, String matKhau) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(tenFile));
        String line;
        boolean found = false;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3 && parts[0].equals(tenDangNhap) && parts[1].equals(matKhau)) {
                System.out.println("Dang nhap thanh cong voi vai tro " + parts[2] + "!");
                found = true;
                break;
            }
        }

        reader.close();

        return found;
    }
    void saveUserInfoToFile(NguoiDung nguoiDung) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("thongtin.txt", true));
        writer.write(nguoiDung.maNguoiDung + "," + nguoiDung.tenDangNhap + "," + nguoiDung.hoTen + "," +
                nguoiDung.soDienThoai + "," + nguoiDung.diaChi + "\n");
        writer.close();
    }    
}