import java.io.File;

import java.io.IOException;
import java.util.Scanner;

public class IDE {
    private static boolean finished = false;
    public static void run() throws IOException {
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if (choice.equals("a")){
        File file = new File("program2.jvto");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            Parser.readLine(scanner.nextLine());

        }
        }
        else if (choice.equals("b")){
            File file = new File("calc.jvto");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                Parser.readLine(scanner.nextLine());

            }
        }
        else{
            while (!finished){
                Parser.readLine(sc.nextLine());
            }

        }

    }
}
