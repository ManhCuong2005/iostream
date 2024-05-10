/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iostreamex;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập đường dẫn của thư mục hoặc file từ người dùng
        System.out.print("Nhập đường dẫn của thư mục hoặc file để xóa: ");
        String path = scanner.nextLine();

        // Tạo một đối tượng File từ đường dẫn đã nhập
        File fileOrDirectory = new File(path);

        // Kiểm tra xem thư mục hoặc file có tồn tại không
        if (fileOrDirectory.exists()) {
            // Gọi phương thức xóa tương ứng với loại thư mục hoặc file
            if (fileOrDirectory.isDirectory()) {
                // Nếu là thư mục, gọi phương thức xóa thư mục
                deleteDirectory(fileOrDirectory);
            } else {
                // Nếu là file, gọi phương thức xóa file
                deleteFile(fileOrDirectory);
            }
            System.out.println("Xóa thành công.");
        } else {
            // Hiển thị thông báo nếu thư mục hoặc file không tồn tại
            System.out.println("Thư mục hoặc file không tồn tại.");
        }

        scanner.close();
    }

    // Phương thức xóa thư mục
    private static void deleteDirectory(File directory) {
        // Kiểm tra nếu đối tượng đang xem xét là thư mục và tồn tại
        if (directory.isDirectory()) {
            // Lấy danh sách tất cả các file và thư mục trong thư mục
            File[] files = directory.listFiles();

            // Xóa từng file hoặc thư mục trong thư mục
            if (files != null) {
                for (File file : files) {
                    // Đệ quy gọi lại phương thức xóa cho từng đối tượng trong thư mục
                    deleteDirectory(file);
                }
            }
        }

        // Sau khi xóa tất cả các file và thư mục con, xóa thư mục cha
        directory.delete();
    }

    // Phương thức xóa file
    private static void deleteFile(File file) {
        // Kiểm tra nếu đối tượng đang xem xét là file và tồn tại
        if (file.isFile() && file.exists()) {
            // Xóa file
            file.delete();
        }
    }
}