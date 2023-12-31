import java.io.*;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;

class KhuyenMai {
    private String maKhuyenMai;
    private String ten;
    private String moTa;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private SanPham[] danhSachSanPhamApDung;

    // Add methods to get and set these properties
    // Add a method to apply the discount to a product
}

class GiaoDich {
    private String maGiaoDich;
    private DonHang donHang;
    private PhuongThucThanhToan phuongThucThanhToan;
    private double soTien;

    // Add methods to get and set these properties
    // Add a method to execute the transaction
}

class GiaoHang {
    private String maGiaoHang;
    private DonHang donHang;
    private Date ngayGiao;
    private String diaChiGiaoHang;
    private String trangThaiGiaoHang;

    // Add methods to get and set these properties
    // Add a method to update the delivery status
}

class NhaSanXuat {
    private String maNhaSanXuat;
    private String ten;
    private String diaChi;

    // Add methods to get and set these properties
}

class DanhMuc {
    private String maDanhMuc;
    private String ten;
    private SanPham[] danhSachSanPham;

    // Add methods to get and set these properties
    // Add a method to add a product to the category
}

class HoaDon {
    private String maHoaDon;
    private DonHang donHang;
    private Date ngayTao;
    private double tongSoTien;

    // Add methods to get and set these properties
    // Add a method to calculate the total amount
}

class ChiTietHoaDon extends HoaDon {
    private SanPham sanPham;
    private int soLuong;
    private double donGia;

    // Add methods to get and set these properties
    // Add a method to calculate the total amount for this product
}


class DonHang {
    private String maDonHang;
    private KhachHang khachHang;
    private GioHang gioHang;
    private Date ngayDatHang;
    private String trangThaiDonHang;
    private PhuongThucThanhToan phuongThucThanhToan;

    public DonHang(String maDonHang, KhachHang khachHang, GioHang gioHang, PhuongThucThanhToan phuongThucThanhToan) {
        this.maDonHang = maDonHang;
        this.khachHang = khachHang;
        this.gioHang = gioHang;
        this.ngayDatHang = new Date();
        this.trangThaiDonHang = "Chua xu ly"; // Mặc định là chưa xử lý
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public void luuDonHang() {
        try {
            FileWriter writer = new FileWriter("donhang.txt", true);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
            String strDate = formatter.format(ngayDatHang);  
            writer.write(khachHang.getMaNguoiDung() + ", " + maDonHang + ", " + khachHang.getHoTen() + ", " + strDate + ", " + trangThaiDonHang);
    
            // Calculate the total amount
            int tongSoTien = 0;
            SanPham[] sanPhamTrongGio = gioHang.getGioHang();
            for (int i = 0; i < gioHang.getSoLuongSanPhamTrongGio(); i++) {
                tongSoTien += sanPhamTrongGio[i].getGia();
            }
    
            // Write the total amount and the payment method to the file
            writer.write(", " + tongSoTien + ", " + phuongThucThanhToan.getTen());
    
            // Write the product information to the file
            for (int i = 0; i < gioHang.getSoLuongSanPhamTrongGio(); i++) {
                writer.write(", " + sanPhamTrongGio[i].getTen());
            }
    
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi lưu đơn hàng.");
            e.printStackTrace();
        }
    }        

    public String getMaDonHang() {
        return maDonHang;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public GioHang getGioHang() {
        return gioHang;
    }

    public Date getNgayDatHang() {
        return ngayDatHang;
    }

    public String getTrangThaiDonHang() {
        return trangThaiDonHang;
    }

    public void setTrangThaiDonHang(String trangThaiDonHang) {
        this.trangThaiDonHang = trangThaiDonHang;
    }
}

class PhuongThucThanhToan {
    private String maPhuongThuc;
    private String ten;
    private String mota;

    public PhuongThucThanhToan(String maPhuongThuc, String ten, String mota) {
        this.maPhuongThuc = maPhuongThuc;
        this.ten = ten;
        this.mota = mota;
    }

    public String getMaPhuongThuc() {
        return maPhuongThuc;
    }

    public void setMaPhuongThuc(String maPhuongThuc) {
        this.maPhuongThuc = maPhuongThuc;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}

class Feedback {
    private String maFeedback;
    private KhachHang khachHang;
    private String noiDung;
    private Date ngayDang;

    public Feedback(String maFeedback, KhachHang khachHang, String noiDung) {
        this.maFeedback = maFeedback;
        this.khachHang = khachHang;
        this.noiDung = noiDung;
        this.ngayDang = new Date();
    }

    public void luuFeedback() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt", true))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = dateFormat.format(ngayDang);

            writer.write(maFeedback + "," + khachHang.maNguoiDung + "," + noiDung + "," + formattedDate + "\n");
            System.out.println("Feedback da duoc luu thanh cong.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Co loi xay ra khi luu feedback.");
        }
    }
}

class BinhLuan {
    private String maBinhLuan;
    private String noiDung;
    private Date ngayDang;
    private SanPham sanPham;

    public BinhLuan(String maBinhLuan, String noiDung, SanPham sanPham) {
        this.maBinhLuan = maBinhLuan;
        this.noiDung = noiDung;
        this.ngayDang = new Date();
        this.sanPham = sanPham;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public void luuBinhLuan() {
        try {
            File file = new File("binhluan.txt");
    
            // Create the file if it doesn't exist
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists.");
                }
            }
    
            FileWriter writer = new FileWriter(file, true);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
            String strDate = formatter.format(ngayDang);  
            writer.write(maBinhLuan + ", " + noiDung + ", " + strDate + ", " + sanPham.getTen() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Co loi xay ra khi luu binh luan.");
            e.printStackTrace();
        }
    }    

    public void xemBinhLuan(SanPham sanPham) {
        try {
            File file = new File("binhluan.txt");
            Scanner reader = new Scanner(file);
    
            System.out.println("Binh luan ve san pham " + sanPham.getTen() + ":");
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] commentInfo = data.split(", ");
                // Check if the product name matches
                if (commentInfo[3].equals(sanPham.getTen())) {
                    // Display the comment information
                    System.out.println("Ma binh luan : " + commentInfo[0]);
                    System.out.println("Noi dung: " + commentInfo[1]);
                    System.out.println("Ngay dang: " + commentInfo[2]);
                    System.out.println("--------------");
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay tep binhluan.txt");
            e.printStackTrace();
        }
    }    
}

// Lớp SanPham giữ thông tin về sản phẩm
class SanPham {
    private String ten;
    private int gia;

    public SanPham(String ten, int gia) {
        this.ten = ten;
        this.gia = gia;
    }

    public String getTen() {
        return ten;
    }

    public int getGia() {
        return gia;
    }

    static void hienThiSanPham(SanPham[] sanPhamList, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println((i - startIndex + 1) + ". " + sanPhamList[i].getTen() + " - " + sanPhamList[i].getGia() + "VND");
        }

        System.out.println((endIndex - startIndex + 2) + ". Quay lai");
    }
}

// Lớp Sach kế thừa từ lớp SanPham và thêm các thuộc tính và phương thức liên quan đến sách
class Sach extends SanPham {
    private String tacGia;

    public Sach(String ten, int gia, String tacGia) {
        super(ten, gia);
        this.tacGia = tacGia;
    }

    public String getTacGia() {
        return tacGia;
    }
}

// Lớp Vo kế thừa từ lớp SanPham và thêm các thuộc tính và phương thức liên quan đến vở
class Vo extends SanPham {
    private String kichThuoc;

    public Vo(String ten, int gia, String kichThuoc) {
        super(ten, gia);
        this.kichThuoc = kichThuoc;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }
}

// Lớp But kế thừa từ lớp SanPham và thêm các thuộc tính và phương thức liên quan đến bút
class But extends SanPham {
    private String loaiBut;

    public But(String ten, int gia, String loaiBut) {
        super(ten, gia);
        this.loaiBut = loaiBut;
    }

    public String getLoaiBut() {
        return loaiBut;
    }
}

class GioHang {
    private SanPham[] gioHang = new SanPham[100]; // Assuming a maximum of 100 products in the cart
    private int soLuongDonHang;
    private int soLuongSanPhamTrongGio = 0;
    // Define phuongThucThanhToans
    private PhuongThucThanhToan[] phuongThucThanhToans;
    String maDonHang = generateMaDonHang();

    public GioHang() {
        // Initialize phuongThucThanhToans in the constructor
        phuongThucThanhToans = new PhuongThucThanhToan[3];
        phuongThucThanhToans[0] = new PhuongThucThanhToan("1", "The tin dung", "Thanh toán bằng thẻ tín dụng");
        phuongThucThanhToans[1] = new PhuongThucThanhToan("2", "Momo", "Thanh toán bằng ví điện tử Momo");
        phuongThucThanhToans[2] = new PhuongThucThanhToan("3", "COD", "Thanh toán khi nhận hàng (COD)");
    }
    void muaSanPham(SanPham[] sanPhamList, Scanner scanner) {
        boolean displayMenu = true;

        while (true) {
            if (displayMenu) {
                System.out.println("Chon loai san pham de mua:");
                System.out.println("1. Sach");
                System.out.println("2. Vo");
                System.out.println("3. But");
                System.out.println("11. Quay lai");
                System.out.print("Nhap lua chon (1, 2, 3 hoac 11): ");
            }

            int productChoice = scanner.nextInt();
            scanner.nextLine();

            if (productChoice >= 1 && productChoice <= 3) {
                int startIndex = (productChoice - 1) * 10;
                int endIndex = productChoice * 10 - 1;
                SanPham.hienThiSanPham(sanPhamList, startIndex, endIndex);

                // User choice for buying the product
                int buyChoice;
                do {
                    System.out.print("Nhap lua chon san pham (1 den 10) hoac 11 de quay lai: ");
                    buyChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (buyChoice >= 1 && buyChoice <= 10) {
                        if (soLuongSanPhamTrongGio < 100) { // Check if the cart is not full
                            gioHang[soLuongSanPhamTrongGio] = sanPhamList[startIndex + buyChoice - 1];
                            soLuongSanPhamTrongGio++;
                            System.out.println("Da them san pham vao gio hang.");
                        } else {
                            System.out.println("Gio hang da day, khong the them san pham.");
                            break;  // Break out of the do-while loop
                        }
                    } else if (buyChoice == 11) {
                        displayMenu = true; // Go back to the main menu
                        return;
                    } else {
                        System.out.println("Lua chon khong hop le.");
                    }
                } while (true);  // Continue until the user chooses to go back
            } else if (productChoice == 11) {
                break; // Quay lai trang truoc
            } else {
                System.out.println("Lua chon khong hop le.");
            }

            displayMenu = false;
        }
    }
    SanPham[] getGioHang() {
        return gioHang;
    }

    private String generateMaDonHang() {
        int lastOrderId = 0;
        File file = new File("lastorderid.txt");
    
        // Create the file if it doesn't exist
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    
        // Read the last order ID from the file
        try {
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextInt()) {
                lastOrderId = scanner.nextInt();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find lastorderid.txt.");
            e.printStackTrace();
        }
    
        lastOrderId++;  // Increment the last order ID
    
        // Write the new last order ID to the file
        try {
            FileWriter writer = new FileWriter("lastorderid.txt");
            writer.write(String.valueOf(lastOrderId));
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to lastorderid.txt.");
            e.printStackTrace();
        }
    
        return "DH" + lastOrderId;  // Return the new order ID
    }
        
    public void docDonHang(KhachHang khachHang) {
        try {
            File file = new File("donhang.txt");
            Scanner reader = new Scanner(file);
    
            System.out.println("Cac don hang da dat:");
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] orderInfo = data.split(", ");
                // Check if the user ID matches
                if (orderInfo[0].equals(khachHang.getMaNguoiDung())) {
                    // Display the order information
                    System.out.println("Ma Don Hang: " + orderInfo[1]);
                    System.out.println("Khach Hang: " + orderInfo[2]);
                    System.out.println("Ngay Dat Hang: " + orderInfo[3]);
                    System.out.println("Trang Thai Don Hang: " + orderInfo[4]);
                    System.out.println("Tong So Tien: " + orderInfo[5] + " VND");
                    System.out.println("Phuong Thuc Thanh Toan: " + orderInfo[6]);
    
                    // Display the product information
                    for (int i = 7; i < orderInfo.length; i++) {
                        System.out.println("San Pham: " + orderInfo[i]);
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay tep don hang.");
            e.printStackTrace();
        }
    }        
    
    DonHang[] donHangArray = new DonHang[100000];

    void datDonHang(Scanner scanner, KhachHang khachHang) {
        System.out.println("Chon phuong thuc thanh toan:");
        for (PhuongThucThanhToan pttt : phuongThucThanhToans) {
            System.out.println(pttt.getMaPhuongThuc() + ". " + pttt.getTen());
        }
        System.out.print("Nhap lua chon (1, 2 hoac 3): ");
        int luaChon = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
    
        PhuongThucThanhToan phuongThucThanhToan = phuongThucThanhToans[luaChon - 1];  // Get the chosen payment method
        DonHang donHang = new DonHang(maDonHang, khachHang, this, phuongThucThanhToan);
        switch (luaChon) {
            case 1:
                System.out.print("Nhap so the ");
                String soThe = scanner.nextLine();
                System.out.print("Nhap ma CVV ");
                String maCVV = scanner.nextLine();
                System.out.print("Nhap ngay het han (mm/yy): ");
                String ngayHetHan = scanner.nextLine();
                // Here you would usually send this information securely to your payment processor
                // But for this example, we'll just print a success message
                System.out.println("Da thanh toan thanh cong bang the tin dung!");
                donHang.luuDonHang();  // Save the order to the file
                break;
            case 2:
                System.out.println("Hay chuyen tien cho tai khoan nay: 0931816175, Ten: Dinh Phuc Thinh");
                donHang.luuDonHang();  // Save the order to the file
                break;
            case 3:
                System.out.println("Dat hang thanh cong! San pham se duoc thanh toan khi nhan hang");
                donHang.luuDonHang();  // Save the order to the file
                break;
            default:
                System.out.println("Lua chon khong hop le.");
                break;
        }
    }
    
    void xemGioHang() {
        System.out.println("Danh sach san pham trong gio hang:");
        for (int i = 0; i < soLuongSanPhamTrongGio; i++) {
            System.out.println((i + 1) + ". " + gioHang[i].getTen() + " - " + gioHang[i].getGia() + "VND");
        }
    }

    int getSoLuongSanPhamTrongGio() {
        return soLuongSanPhamTrongGio;
    }
}

class ThongTinLienLac {
    String ten;
    String email;
    String soDienThoai;
    String linkMangXaHoi;

    public ThongTinLienLac(String ten, String email, String soDienThoai, String linkMangXaHoi) {
        this.ten = ten;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.linkMangXaHoi = linkMangXaHoi;
    }

    public static void displayContacts(ThongTinLienLac[] danhSach) {
        System.out.println("Ban co the lien he voi cac thanh vien sau de duoc giai quyet voi toc do phan hoi tot nhat");
        System.out.println("Ten\t\t\tFacebook\t\tGmail\t\t\t\tSdt");

        for (ThongTinLienLac lienLac : danhSach) {
            System.out.println(lienLac.ten + "\t\t" + lienLac.linkMangXaHoi + "\t\t" + lienLac.email + "\t\t" + lienLac.soDienThoai);
        }
    }
}

class ThongTinChuongTrinh {
    String maChuongTrinh;
    String ten;
    String moTa;
    String teamDev;
    Date ngayBatDau;
    Date ngayKetThuc;

    public ThongTinChuongTrinh(String maChuongTrinh, String ten, String moTa, String teamDev, Date ngayBatDau, Date ngayKetThuc) {
        this.maChuongTrinh = maChuongTrinh;
        this.ten = ten;
        this.moTa = moTa;
        this.teamDev = teamDev;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public static void displayProgramInfo() {
    Calendar calStart = Calendar.getInstance();
    calStart.set(2023, Calendar.NOVEMBER, 8);
    Date startDate = calStart.getTime();

    Calendar calEnd = Calendar.getInstance();
    calEnd.set(2023, Calendar.JANUARY, 1);
    Date endDate = calEnd.getTime();

    ThongTinChuongTrinh chuongTrinh = new ThongTinChuongTrinh(
        "1.0.0",
        "Chuong trinh Ban van phong pham",
        "",
        "1. Nguyen Dai Quoc\n" +
        "   - Facebook: fb.com/wolfdzai\n" +
        "   - Email: luutrithon1996@gmail.com\n" +
        "   - Phone: 0931454176\n" +
        "2. Dinh Phuc Thinh\n" +
        "   - Facebook: fb.com/dinfucthin\n" +
        "   - Email: zaikaman123@gmail.com\n" +
        "   - Phone: 0931816175\n" +
        "3. Tran Trung Viet\n" +
        "   - Facebook: cutt.ly/qwTNnwZY\n" +
        "4. Tran Dang Phat\n" +
        "   - Facebook: cutt.ly/TwTNb3Ur\n" +
        "5. Nguyen Hoang Sang\n" +
        "   - Facebook: cutt.ly/4wTNbGKf\n" +
        "   - Email: lesang01227982715@gmail.com\n" +
        "   - Phone: 0776592967\n",
        startDate,
        endDate
    );

    System.out.println("Chuong trinh: " + chuongTrinh.ten);
    System.out.println("Version: " + chuongTrinh.maChuongTrinh);
    System.out.println("Release Date: " + chuongTrinh.ngayBatDau);
    System.out.println("Dev team:");
    System.out.println(chuongTrinh.teamDev);
}
}


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

    // Check if the username and password are at least 6 characters long
    if (nguoiDung.tenDangNhap.length() < 6 || nguoiDung.matKhau.length() < 6) {
        System.out.println("Ten dang nhap va mat khau phai co it nhat 6 ky tu.");
        return;
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
    boolean userExists = false;

    while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length == 3 && parts[0].equals(tenDangNhap)) {
            userExists = true;
            if (parts[1].equals(matKhau)) {
                System.out.println("Dang nhap thanh cong voi vai tro " + parts[2] + "!");
                found = true;
            }
            break;
        }
    }

    reader.close();

    if (userExists && !found) {
        System.out.println("Mat khau khong dung.");
        System.out.println("Vui long thu lai.");
    } else if (!userExists) {
        System.out.println("Tai khoan khong ton tai.");
        System.out.println("Vui long dang ky tai khoan.");
    }

    return found;
}

    void saveUserInfoToFile(NguoiDung nguoiDung) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("thongtin.txt", true));
        writer.write(nguoiDung.maNguoiDung + "," + nguoiDung.tenDangNhap + "," + nguoiDung.hoTen + "," +
                nguoiDung.soDienThoai + "," + nguoiDung.diaChi + "\n");
        writer.close();
    }    
}
     
public class Main {
    public static void main(String[] args) {
        GioHang gioHang = new GioHang();
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        SanPham[] sanPhamList = taoDanhSachSanPham();
        KhachHang khachHang = null;
        TaiKhoan taiKhoan = new TaiKhoan(); // You need to instantiate TaiKhoan
        // Declare ThongTinLienLac related stuff
        ThongTinLienLac[] danhSachLienLac = new ThongTinLienLac[]{
        new ThongTinLienLac("Nguyen Dai Quoc", "luutrithon1996@gmail.com", "0931454176", "fb.com/wolfdzai"),
        new ThongTinLienLac("Dinh Phuc Thinh", "zaikaman123@gmail.com", "0931816175", "fb.com/dinfucthin"),
        new ThongTinLienLac("Tran Trung Viet", "", "", "cutt.ly/qwTNnwZY"),
        new ThongTinLienLac("Tran Dang Phat", "", "", "cutt.ly/TwTNb3Ur"),
        new ThongTinLienLac("Nguyen Hoang Sang", "lesang01227982715@gmail.com", "0776592967", "cutt.ly/4wTNbGKf")
    };

Calendar calStart = Calendar.getInstance();
calStart.set(2023, Calendar.NOVEMBER, 8);
Date startDate = calStart.getTime();

Calendar calEnd = Calendar.getInstance();
calEnd.set(2023, Calendar.JANUARY, 1);
Date endDate = calEnd.getTime();

ThongTinChuongTrinh chuongTrinh = new ThongTinChuongTrinh(
    "1.0.0",
    "Chuong trinh Ban van phong pham",
    "",
    "1. Nguyen Dai Quoc\n" +
    "   - Facebook: fb.com/wolfdzai\n" +
    "   - Email: luutrithon1996@gmail.com\n" +
    "   - Phone: 0931454176\n" +
    "2. Dinh Phuc Thinh\n" +
    "   - Facebook: fb.com/dinfucthin\n" +
    "   - Email: zaikaman123@gmail.com\n" +
    "   - Phone: 0931816175\n" +
    "3. Tran Trung Viet\n" +
    "   - Facebook: cutt.ly/qwTNnwZY\n" +
    "4. Tran Dang Phat\n" +
    "   - Facebook: cutt.ly/TwTNb3Ur\n" +
    "5. Nguyen Hoang Sang\n" +
    "   - Facebook: cutt.ly/4wTNbGKf\n" +
    "   - Email: lesang01227982715@gmail.com\n" +
    "   - Phone: 0776592967\n",
    startDate,
    endDate
);


        while (!loggedIn) {
            System.out.println("Chao mung ban den voi ung dung van phong pham!");
            System.out.println("Chon tuy chon:");
            System.out.println("1. Dang ky");
            System.out.println("2. Dang nhap");
            System.out.print("Nhap lua chon (1 hoac 2): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice == 1) {
                System.out.println("\nDang ky:");
                System.out.print("Nhap ten dang nhap: ");
                String username = scanner.nextLine();
                System.out.print("Nhap mat khau: ");
                String password = scanner.nextLine();
                khachHang = new KhachHang(username, password); // Initialize khachHang here
                try {
                    taiKhoan.dangKy(khachHang);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (choice == 2) {
                System.out.println("\nDang nhap:");
                System.out.print("Nhap ten dang nhap: ");
                String loginUsername = scanner.nextLine();
                System.out.print("Nhap mat khau: ");
                String loginPassword = scanner.nextLine();

                try {
                    loggedIn = taiKhoan.dangNhap(loginUsername, loginPassword);

                    if (loggedIn) {
                        khachHang = new KhachHang(loginUsername, loginPassword); // Initialize khachHang here
                        taiKhoan.docThongTinNguoiDung(khachHang);
                    } else {
                        System.out.println("Ten dang nhap hoac mat khau khong dung hoac tai khoan khong ton tai.");
                        System.out.println("Vui lòng dang ky tai khoan neu tai khoan khong ton tai.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Lua chon khong hop le.");
            }
        }

        // Người dùng đã đăng nhập, hiển thị tùy chọn mua sản phẩm
        boolean running = true;
        while (running) {
            while (loggedIn) {
                System.out.println("Chon tuy chon:");
                System.out.println("1. Mua san pham");
                System.out.println("2. Xem gio hang");
                System.out.println("3. Nhap thong tin nguoi dung");
                System.out.println("4. Xem thong tin nguoi dung");
                System.out.println("5. Gui feedback");
                System.out.println("6. Dat don hang");
                System.out.println("7. Xem don hang");
                System.out.println("8. Xem binh luan");
                System.out.println("9. Xem thong tin lien lac");
                System.out.println("10. Xem thong tin chuong trinh");
                System.out.println("11. Dang xuat");
                System.out.println("Hay nhap thong tin nguoi dung truoc khi mua hang nhe!");
                System.out.print("Nhap lua chon (1, 2, 3, 4, 5, 6, 7, 8, 9, 10 hoac 11): ");
                int userChoice = scanner.nextInt();
                scanner.nextLine();

                if (userChoice == 1) {
                    // Người dùng chọn mua sản phẩm
                    gioHang.muaSanPham(sanPhamList, scanner);
                } else if (userChoice == 2) {
                    // Người dùng chọn xem gio hang
                    gioHang.xemGioHang();
                } else if (userChoice == 3) {
                    // Người dùng chọn nhập thông tin
                    try {
                        dangNhapNhapThongTin((KhachHang) khachHang, scanner, taiKhoan);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (userChoice == 4) {
                    // Người dùng chọn xem thông tin
                    xemThongTinNguoiDung((KhachHang) khachHang);
                } else if (userChoice == 5) {
                    // Người dùng chọn gửi feedback
                    System.out.print("Nhap noi dung feedback: ");
                    String feedbackContent = scanner.nextLine();

                    Feedback feedback = new Feedback("F" + (taiKhoan.soLuongNguoiDung + 1), khachHang, feedbackContent);
                    feedback.luuFeedback();
                } else if (userChoice == 6) {
                    // Người dùng chọn đặt đơn hàng
                    gioHang.datDonHang(scanner, khachHang);
                } else if (userChoice == 7) {
                    gioHang.docDonHang(khachHang);
                } else if (userChoice == 8) {
                    // User chooses to view comments
                    System.out.println("Xem binh luan cua:");
                    System.out.println("1. Sach");
                    System.out.println("2. Vo");
                    System.out.println("3. But");
                    System.out.print("Nhap lua chon (1, 2 hoac 3): ");
                    int productType = scanner.nextInt();
                    scanner.nextLine();

                    if (productType >= 1 && productType <= 3) {
                        int startIndex = (productType - 1) * 10;
                        hienThiSanPham(Arrays.copyOfRange(sanPhamList, startIndex, startIndex + 10));
                        System.out.print("Nhap lua chon san pham (1 den 10): ");
                        int productChoice = scanner.nextInt();
                        scanner.nextLine();

                        boolean continueLoop = true;
                        while (loggedIn && continueLoop) {
                            if (productChoice >= 1 && productChoice <= 10) {
                                SanPham chosenProduct = sanPhamList[startIndex + productChoice - 1];
                                BinhLuan binhLuan = new BinhLuan("BL" + (taiKhoan.soLuongNguoiDung + 1), "", chosenProduct);
                                binhLuan.xemBinhLuan(chosenProduct);
                                while (true) {
                                    System.out.print("Ban co muon binh luan san pham nay khong? (y/n): ");
                                    String commentChoice = scanner.nextLine();

                                    if (commentChoice.equalsIgnoreCase("y")) {
                                        System.out.print("Nhap noi dung binh luan: ");
                                        String commentContent = scanner.nextLine();
                                        binhLuan.setNoiDung(commentContent);  // Update the comment content
                                        binhLuan.luuBinhLuan();
                                    } else if (commentChoice.equalsIgnoreCase("n")) {
                                        continueLoop = false;
                                        break;  // Return to the main menu
                                    } else {
                                        System.out.println("Lua chon khong hop le.");
                                    }
                                }
                            } else {
                                System.out.println("Lua chon khong hop le.");
                            }
                        }
                    } else {
                        System.out.println("Lua chon khong hop le.");
                    }
                } else if (userChoice == 9) {
                    // User chooses to view contact information
                    ThongTinLienLac.displayContacts(danhSachLienLac);
                } else if (userChoice == 10) {
                    // User chooses to view program information
                    ThongTinChuongTrinh.displayProgramInfo();
                } else if (userChoice == 11) {
                    // Người dùng đăng xuất
                    loggedIn = false;
                    System.out.println("Da dang xuat.");
                }
            }

            // Khi người dùng đã đăng xuất, kiểm tra liệu họ muốn đăng nhập hoặc đăng ký lại
            System.out.println("Chon tuy chon:");
            System.out.println("1. Dang ky");
            System.out.println("2. Dang nhap");
            System.out.println("3. Thoat");
            System.out.print("Nhap lua chon (1, 2 hoac 3): ");
            int loginChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (loginChoice == 1) {
                // Xử lý logic đăng ký
                System.out.println("\nDang ky:");
                System.out.print("Nhap ten dang nhap: ");
                String username = scanner.nextLine();
                System.out.print("Nhap mat khau: ");
                String password = scanner.nextLine();
                KhachHang newKhachHang = new KhachHang(username, password);
                try {
                    taiKhoan.dangKy(newKhachHang);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (loginChoice == 2) {
                // Xử lý logic đăng nhập
                System.out.println("\nDang nhap:");
                System.out.print("Nhap ten dang nhap: ");
                String loginUsername = scanner.nextLine();
                System.out.print("Nhap mat khau: ");
                String loginPassword = scanner.nextLine();

                try {
                    loggedIn = taiKhoan.dangNhap(loginUsername, loginPassword);

                    if (loggedIn) {
                        khachHang = new KhachHang(loginUsername, loginPassword);
                        taiKhoan.docThongTinNguoiDung(khachHang);
                    } else {
        
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (loginChoice == 3) {
                // Thoát chương trình
                running = false;
            } else {
                System.out.println("Lua chon khong hop le.");
            }
        }
    }

    public static SanPham[] taoDanhSachSanPham() {
        SanPham[] sanPhamList = new SanPham[30]; // Adjusted the array size to match the number of products

        // Thêm sản phẩm loại Sách
        sanPhamList[0] = new SanPham("Nha Gia Kim - Paulo Coelho", 63000);
        sanPhamList[1] = new SanPham("Dac Nhan Tam - Dale Carnegie", 60000);
        sanPhamList[2] = new SanPham("Cach nghi de thanh cong - Napoleon Hill", 45000);
        sanPhamList[3] = new SanPham("Hat giong tam hon - Jack Canfield", 50000);
        sanPhamList[4] = new SanPham("Quang ganh lo di va vui song - Dale Carnegie", 60000);
        sanPhamList[5] = new SanPham("Doc Vi Bat Ky Ai - David J.Lieberman", 55000);
        sanPhamList[6] = new SanPham("Tieu thuyet Bo Gia - Mario Puzo", 50000);
        sanPhamList[7] = new SanPham("Cuoc song khong gioi han - Nick Vujicic", 80000);
        sanPhamList[8] = new SanPham("Doi Thay Doi Khi Chung Ta Thay Doi - Andrew Matthews", 70000);
        sanPhamList[9] = new SanPham("Nguoi giau co nhat thanh Babylon - George Samuel Clason", 65000);

        // Thêm sản phẩm loại Vở
        sanPhamList[10] = new SanPham("Vo Deli", 10000);
        sanPhamList[11] = new SanPham("Vo Hai Tien", 9000);
        sanPhamList[12] = new SanPham("Vo Hong Ha", 11000);
        sanPhamList[13] = new SanPham("Vo Campus", 12000);
        sanPhamList[14] = new SanPham("Vo Thien Long", 13000);
        sanPhamList[15] = new SanPham("Vo Crabit", 14000);
        sanPhamList[16] = new SanPham("Vo KLONG", 15000);
        sanPhamList[17] = new SanPham("Vo Vinh Tien", 16000);
        sanPhamList[18] = new SanPham("Vo Tien Phat", 17000);
        sanPhamList[19] = new SanPham("Vo Tan Thuan Tien", 18000);

        // Thêm sản phẩm loại Bút
        sanPhamList[20] = new SanPham("But bi Thien Long TL-027", 5000);
        sanPhamList[21] = new SanPham("But bi Pentel BK250", 6000);
        sanPhamList[22] = new SanPham("But long bi Parker IM 2017", 7000);
        sanPhamList[23] = new SanPham("But bi 4 mau Deli S313", 8000);
        sanPhamList[24] = new SanPham("But bi gel Zebra Sarasa clip", 9000);
        sanPhamList[25] = new SanPham("But muc gel Xiaomi Mijia 0.5", 10000);
        sanPhamList[26] = new SanPham("But muc gel Stabilo Palette GP286XF", 11000);
        sanPhamList[27] = new SanPham("But bi Ben Nghe L28", 12000);
        sanPhamList[28] = new SanPham("But bi Flexoffice FO-069", 13000);
        sanPhamList[29] = new SanPham("But bi xoa Pilot Frixion Ball 0.5", 14000);

        return sanPhamList;
    }       
   
        public static void hienThiSanPham(SanPham[] sanPhamList) {
            for (int i = 0; i < sanPhamList.length; i++) {
                if (sanPhamList[i] != null) {
                    System.out.println((i + 1) + ". " + sanPhamList[i].getTen() + " - " + sanPhamList[i].getGia() + "VND");
                } else {
                    System.out.println((i + 1) + ". NULL");
                }
            }
        }
        private static void dangNhapNhapThongTin(KhachHang khachHang, Scanner scanner, TaiKhoan taiKhoan) throws IOException {
            khachHang.nhapThongTin(scanner);
            taiKhoan.saveUserInfoToFile(khachHang);
            System.out.println("Da nhap thong tin thanh cong.");
        }
       
        private static void xemThongTinNguoiDung(KhachHang khachHang) {
            System.out.println("Thong tin nguoi dung:");
            System.out.println("Ma nguoi dung: " + khachHang.maNguoiDung);
            System.out.println("Ho ten: " + khachHang.hoTen);
            System.out.println("So dien thoai: " + khachHang.soDienThoai);
            System.out.println("Dia chi: " + khachHang.diaChi);
        }            
    }
