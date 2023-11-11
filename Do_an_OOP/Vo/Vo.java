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