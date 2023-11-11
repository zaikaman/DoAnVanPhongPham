public class Main {
    public static void main(String[] args) {
        GioHang gioHang = new GioHang();
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        SanPham[] sanPhamList = taoDanhSachSanPham();
        KhachHang khachHang = null;
        TaiKhoan taiKhoan = new TaiKhoan(); // You need to instantiate TaiKhoan

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
                System.out.println("9. Dang xuat");
                System.out.println("Hay nhap thong tin nguoi dung truoc khi mua hang nhe!");
                System.out.print("Nhap lua chon (1, 2, 3, 4, 5, 6, 7, 8 hoac 9): ");
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
                    gioHang.xemDonHang();
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
                        System.out.println("Ten dang nhap hoac mat khau khong dung hoac tai khoan khong ton tai.");
                        System.out.println("Vui lòng dang ky tai khoan neu tai khoan khong ton tai.");
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