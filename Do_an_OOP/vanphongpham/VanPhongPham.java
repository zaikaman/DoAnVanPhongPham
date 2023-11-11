package com.vanphongpham;

//import java.io.File;
//import java.io.IOException;
import java.util.Scanner;
import com.user.User;
//hoac import com.vanphongpham.user.User;
import com.details.details;
import com.cskh.cskh;

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
                        cskh.main(args);
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
                        details.main(args);
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
