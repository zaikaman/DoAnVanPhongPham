class BinhLuan {
    private String maBinhLuan;
    private String noiDung;
    private Date ngayDang;
    private SanPham sanPham;

    public BinhLuan(String maBinhLuan, String noiDung, SanPham sanPham) {
        this.maBinhLuan = maBinhLuan;
        this.noiDung = noiDung;
        this.ngayDang = new Date();
        this.sanPham = sanPham;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public void luuBinhLuan() {
        try {
            File file = new File("binhluan.txt");
    
            // Create the file if it doesn't exist
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists.");
                }
            }
    
            FileWriter writer = new FileWriter(file, true);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
            String strDate = formatter.format(ngayDang);  
            writer.write(maBinhLuan + ", " + noiDung + ", " + strDate + ", " + sanPham.getTen() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Co loi xay ra khi luu binh luan.");
            e.printStackTrace();
        }
    }    

    public void xemBinhLuan(SanPham sanPham) {
        try {
            File file = new File("binhluan.txt");
            Scanner reader = new Scanner(file);
    
            System.out.println("Binh luan ve san pham " + sanPham.getTen() + ":");
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] commentInfo = data.split(", ");
                // Check if the product name matches
                if (commentInfo[3].equals(sanPham.getTen())) {
                    // Display the comment information
                    System.out.println("Ma binh luan : " + commentInfo[0]);
                    System.out.println("Noi dung: " + commentInfo[1]);
                    System.out.println("Ngay dang: " + commentInfo[2]);
                    System.out.println("--------------");
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay tep binhluan.txt");
            e.printStackTrace();
        }
    }    
}