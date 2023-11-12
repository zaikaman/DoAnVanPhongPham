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
