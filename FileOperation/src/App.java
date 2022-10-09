import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\SimpliLearn\\FileOperation\\README.md");
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the option: " + "\n" +
                "1. Read" + "\n" +
                "2. Write" + "\n" +
                "3. Append");
        int option = scanner.nextInt();
        switch (option){
            case 1:
                read(file);
                break;
            case 2:
                write(file);
                break;
            case 3:
                append(file);
                break;
            default:
                break;
        }



    }

    private static void append(File file) {
        String text = "Added text";
        try{
            Files.write(Paths.get(String.valueOf(file)),text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void write(File file) {
        try {
            String text = "This is Mounish";
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }
}
