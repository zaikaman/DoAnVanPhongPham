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