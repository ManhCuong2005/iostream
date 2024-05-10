/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package iostreamex;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class IOStreamEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập đường dẫn của file từ người dùng
        System.out.print("Nhập đường dẫn của file: ");
        String filePath = scanner.nextLine();

        // Tạo một đối tượng File từ đường dẫn đã nhập
        File file = new File(filePath);

        // Kiểm tra xem file có tồn tại không
        if (file.exists()) {
            // Lấy độ lớn của file (dưới dạng byte) và chuyển đổi sang kilobyte hoặc megabyte nếu cần
            long fileSizeInBytes = file.length();
            double fileSizeInKB = fileSizeInBytes / 1024.0; // Chuyển byte sang kilobyte
            double fileSizeInMB = fileSizeInKB / 1024.0; // Chuyển kilobyte sang megabyte

            // Hiển thị độ lớn của file
            System.out.println("Độ lớn của file: " + fileSizeInBytes + " bytes");
            System.out.println("Hoặc: " + fileSizeInKB + " KB");
            System.out.println("Hoặc: " + fileSizeInMB + " MB");
        } else {
            // Hiển thị thông báo nếu file không tồn tại
            System.out.println("File không tồn tại.");
        }
        scanner.close();
    }
}
