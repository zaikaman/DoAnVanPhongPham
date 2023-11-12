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
