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

    void xemDonHang() {
        if (donHangArray != null) {
            for (int i = 0; i < soLuongDonHang; i++) {
                if (donHangArray[i] != null) {
                    System.out.println("Ma Don Hang: " + donHangArray[i].getMaDonHang());
                    System.out.println("Khach Hang: " + donHangArray[i].getKhachHang().getHoTen());
                    System.out.println("Ngay Dat Hang: " + donHangArray[i].getNgayDatHang());
                    System.out.println("Trang Thai Don Hang: " + donHangArray[i].getTrangThaiDonHang());
                    System.out.println("--------------");
                }
            }
        } else {
            System.out.println("Khong co don hang nao.");
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