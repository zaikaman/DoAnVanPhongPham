import java.util.Scanner;
import java.util.HashMap;

public class main {
    private static HashMap<String, String> users = new HashMap<>();
    private static boolean isLoggedIn = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (!isLoggedIn) {
                System.out.println("1. Đăng ký");
                System.out.println("2. Đăng nhập");
            }
            System.out.println(isLoggedIn ? "1. Xem sản phẩm" : "3. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline
            if (!isLoggedIn) {
                switch (option) {
                    case 1:
                        register(scanner);
                        break;
                    case 2:
                        isLoggedIn = login(scanner);
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Tùy chọn không hợp lệ. Vui lòng thử lại.");
                }
            } else {
                switch (option) {
                    case 1:
                        viewProducts(scanner);
                        break;
                    case 2:
                        System.exit(0);
                    default:
                        System.out.println("Tùy chọn không hợp lệ. Vui lòng thử lại.");
                }
            }
        }
    }

    private static void register(Scanner scanner) {
        System.out.print("Nhập tên đăng nhập: ");
        String username = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        users.put(username, password);
        System.out.println("Đăng ký thành công!");
    }

    private static boolean login(Scanner scanner) {
        System.out.print("Nhập tên đăng nhập: ");
        String username = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        if (password.equals(users.get(username))) {
            System.out.println("Đăng nhập thành công!");
            return true;
        } else {
            System.out.println("Tên đăng nhập hoặc mật khẩu không hợp lệ.");
            return false;
        }
    }

    private static void viewProducts(Scanner scanner) {
        System.out.println("1. Sách");
        System.out.println("2. Vở");
        System.out.println("3. Bút viết");
        System.out.println("4. Quay lại trang xem sản phẩm");
        System.out.print("Chọn một tùy chọn: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // consume newline
        switch (option) {
            case 1:
                viewBooks();
                break;
            case 2:
                viewNotebooks();
                break;
            case 3:
                viewPens();
                break;
            case 4:
                return;
            default:
                System.out.println("Tùy chọn không hợp lệ. Vui lòng thử lại.");
        }
    }

    private static void viewBooks() {
        System.out.println("1. Nhà Giả Kim – Paulo Coelho");
        System.out.println("2. Đắc Nhân Tâm – Dale Carnegie");
        System.out.println("3. Cách nghĩ để thành công - Napoleon Hill");
        System.out.println("4. Hạt giống tâm hồn - Nhiều tác giả");
        System.out.println("5. Quẳng gánh lo đi và vui sống - Dale Carnegie");
        System.out.println("6. Đọc Vị Bất Kỳ Ai – David J.Lieberman");
        System.out.println("7. Tiểu thuyết Bố Già – Mario Puzo");
        System.out.println("8. Cuộc sống không giới hạn - Nick Vujicic");
        System.out.println("9. Đời Thay Đổi Khi Chúng Ta Thay Đổi – Andrew Matthews");
        System.out.println("10. Người giàu có nhất thành Babylon - George Samuel Clason");
        System.out.println("11. Quay lại trang xem sản phẩm");
    }

    private static void viewNotebooks() {
        System.out.println("1. Vở Deli");
        System.out.println("2. Vở Hải Tiến");
        System.out.println("3. Vở Hồng Hà");
        System.out.println("4. Vở Campus");
        System.out.println("5. Vở Thiên Long");
        System.out.println("6. Vở Crabit");
        System.out.println("7. Vở KLONG");
        System.out.println("8. Vở Vĩnh Tiến");
        System.out.println("9. Vở Tiến Phát");
        System.out.println("10. Vở Tân Thuận Tiến");
        System.out.println("11. Quay lại trang xem sản phẩm");
    }

    private static void viewPens() {
        System.out.println("1. Bút bi Thiên Long TL-027");
        System.out.println("2. Bút bi Pentel BK250");
        System.out.println("3. Bút lông bi Parker IM 2017");
        System.out.println("4. Bút bi 4 màu Deli S313");
        System.out.println("5. Bút bi gel Zebra Sarasa clip");
        System.out.println("6. Bút mực gel Xiaomi Mijia 0.5");
        System.out.println("7. Bút mực gel Stabilo Palette GP286XF");
        System.out.println("8. Bút bi Bến Nghé L28");
        System.out.println("9. Bút bi Flexoffice FO-069");
        System.out.println("10. Bút bi xóa Pilot Frixion Ball 0.5");
        System.out.println("11. Quay lại trang xem sản phẩm");
    }
}
