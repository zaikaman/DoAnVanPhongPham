class Feedback {
    private String maFeedback;
    private KhachHang khachHang;
    private String noiDung;
    private Date ngayDang;

    public Feedback(String maFeedback, KhachHang khachHang, String noiDung) {
        this.maFeedback = maFeedback;
        this.khachHang = khachHang;
        this.noiDung = noiDung;
        this.ngayDang = new Date();
    }

    public void luuFeedback() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt", true))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = dateFormat.format(ngayDang);

            writer.write(maFeedback + "," + khachHang.maNguoiDung + "," + noiDung + "," + formattedDate + "\n");
            System.out.println("Feedback da duoc luu thanh cong.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Co loi xay ra khi luu feedback.");
        }
    }
}