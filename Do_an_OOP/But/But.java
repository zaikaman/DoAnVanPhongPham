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