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