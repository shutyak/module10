import java.io.*;
import java.util.Scanner;

public class PhoneReader {
    public static void main(String[] args) {
        printValidPhone("file.txt");
    }

    public static void printValidPhone(String fileName) {
        try (final var scanner = new Scanner(new FileInputStream(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.matches("\\d{3}-\\d{3}-\\d{4}|\\(\\d{3}\\)\\s\\d{3}-\\d{4}")) // xxx-xxx-xxxx or (xxx) xxx-xxxx
                {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
