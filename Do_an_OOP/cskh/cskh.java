package com.cskh;

public class ThongTinLienLac {
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

    public static void main(String[] args) {
        ThongTinLienLac[] danhSach = new ThongTinLienLac[]{
            new ThongTinLienLac("Nguyen Dai Quoc", "luutrithon1996@gmail.com", "0931454176", "fb.com/wolfdzai"),
            new ThongTinLienLac("Dinh Phuc Thinh", "zaikaman123@gmail.com", "0931816175", "fb.com/dinfucthin"),
            new ThongTinLienLac("Tran Trung Viet", "", "", "cutt.ly/qwTNnwZY"),
            new ThongTinLienLac("Tran Dang Phat", "", "", "cutt.ly/TwTNb3Ur"),
            new ThongTinLienLac("Nguyen Hoang Sang", "lesang01227982715@gmail.com", "0776592967", "cutt.ly/4wTNbGKf")
        };

        System.out.println("Ban co the lien he voi cac thanh vien sau de duoc giai quyet voi toc do phan hoi tot nhat");
        System.out.println("Ten\t\t\tFacebook\t\tGmail\t\t\t\tSdt");

        for (ThongTinLienLac lienLac : danhSach) {
            System.out.println(lienLac.ten + "\t\t" + lienLac.linkMangXaHoi + "\t\t" + lienLac.email + "\t\t" + lienLac.soDienThoai);
        }
    }
}
