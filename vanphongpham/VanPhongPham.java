package com.vanphongpham;

//import java.io.File;
//import java.io.IOException;
import java.util.Scanner;
import com.user.User;
//hoac import com.vanphongpham.user.User;


public class VanPhongPham {
    public static void clearScreen() {
        for (int i = 0; i < 31; ++i) System.out.println();
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Menu
        int lc;
        while(true){
            clearScreen();
            System.out.println("Chao mung ban den voi: Ung dung Ban van phong pham");
            System.out.println("Welcome to Program");
            System.out.println("==================================================");
            System.out.println("|Moi ban chon thao tac ung voi nhu cau cua minh  |");
            System.out.println("|1. Quan ly (Adminstrator) (1 File)  --> Phat                    |");
            System.out.println("|2. Nguoi dung (User)      (1 File)  --> DPT                    |");
            //nhan vien (1 File) Phat
            System.out.println("|3. CSKH (Customer care)                         |");
            System.out.println("|4. Thong tin ve chuong trinh (Details)          |");
            System.out.println("|5. Gop y ve chuong trinh (Feedback) (2 File) --> Sang, Viet            |");
            System.out.println("|6. Thoat ung dung (Exit application)            |");
            System.out.println("==================================================");
            System.out.print("Moi ban nhap lua chon (Please enter your choice): ");
            lc = sc.nextInt();
            switch(lc){
                case 1: {
                    //Login log = new Login();
                    //log.LOGIN();
                    break;
                }
                case 2: {
                    //User usr = new User();
                    User.main(args);
                    break;
                }
                case 3: {
                    int ok = 1;
                    while(ok == 1){
                        clearScreen();
                        System.out.println("Ban co the lien he voi cac thanh vien sau de duoc giai quyet voi toc do phan hoi tot nhat");
                        System.out.println("Ten\t\t\tFacebook\t\tGmail\t\t\t\tSdt");
                        System.out.println("Nguyen Dai Quoc\t\tfb.com/wolfdzai\t\tluutrithon1996@gmail.com\t0931454176");
                        System.out.println("Dinh Phuc Thinh\t\tfb.com/dinfucthin\tzaikaman123@gmail.com\t\t0931816175");
                        System.out.println("Tran Trung Viet\t\tcutt.ly/qwTNnwZY\t\t");
                        System.out.println("Tran Dang Phat \t\tcutt.ly/TwTNb3Ur\t\t");
                        System.out.println("Nguyen Hoang Sang\tcutt.ly/4wTNbGKf\tlesang01227982715@gmail.com\t0776592967");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("1.Quay lai man hinh menu");
                        System.out.println("0.Thoat chuong trinh");
                        System.out.println("Moi ban nhap lua chon");
                        int sl;
                        sl = sc.nextInt();
                        switch (sl) {
                            case 1: {
                                ok = 0;
                                break;
                            }
                            case 0: {
                                System.out.println("Cam on ban da su dung ung dung");
                                return;
                            }
                        }
                    }
                    break;
                }
                case 4: {
                    int ok = 1;
                    while(ok == 1){
                        clearScreen();
                        System.out.println("Chuong trinh Ban van phong pham");
                        System.out.println("Version: 1.0.0");
                        System.out.println("Release Date: November 2023");
                        System.out.println("Dev team:");
                        System.out.println("1. Nguyen Dai Quoc");
                        System.out.println("   - Facebook: fb.com/wolfdzai");
                        System.out.println("   - Email: luutrithon1996@gmail.com");
                        System.out.println("   - Phone: 0931454176");
                        System.out.println("2. Dinh Phuc Thinh");
                        System.out.println("   - Facebook: fb.com/dinfucthin");
                        System.out.println("   - Email: zaikaman123@gmail.com");
                        System.out.println("   - Phone: 0931816175");
                        System.out.println("3. Tran Trung Viet");
                        System.out.println("   - Facebook: cutt.ly/qwTNnwZY");
                        System.out.println("4. Tran Dang Phat");
                        System.out.println("   - Facebook: cutt.ly/TwTNb3Ur");
                        System.out.println("5. Nguyen Hoang Sang");
                        System.out.println("   - Facebook: cutt.ly/4wTNbGKf");
                        System.out.println("   - Email: lesang01227982715@gmail.com");
                        System.out.println("   - Phone: 0776592967");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("1.Quay lai man hinh menu");
                        System.out.println("0.Thoat chuong trinh");
                        System.out.println("Moi ban nhap lua chon");
                        int sl;
                        sl = sc.nextInt();
                        switch (sl) {
                            case 1: {
                                ok = 0;
                                break;
                            }
                            case 0: {
                                System.out.println("Cam on ban da su dung ung dung");
                                return;
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    break;
                }
                case 6: {
                    clearScreen();
                    System.out.println("Cam on ban da su dung ung dung!");
                    return ;
                }
            }
        }
    }
}
