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