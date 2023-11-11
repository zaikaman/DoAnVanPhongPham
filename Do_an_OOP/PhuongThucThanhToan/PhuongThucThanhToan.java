class PhuongThucThanhToan {
    private String maPhuongThuc;
    private String ten;
    private String mota;

    public PhuongThucThanhToan(String maPhuongThuc, String ten, String mota) {
        this.maPhuongThuc = maPhuongThuc;
        this.ten = ten;
        this.mota = mota;
    }

    public String getMaPhuongThuc() {
        return maPhuongThuc;
    }

    public void setMaPhuongThuc(String maPhuongThuc) {
        this.maPhuongThuc = maPhuongThuc;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}