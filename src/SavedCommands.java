import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class SavedCommands {

    public static boolean working = false;

    public static HashMap<String,PrintWriter> files = new HashMap<>();
    public static String currentFunction = "";

    public static void run(String fileName) throws IOException {
        if (!fileName.contains(".jvto"))
            fileName = fileName.trim()+".jvto";
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            Parser.readLine(line);
        }
    }
    public static void newCommand(String line) throws IOException {

        String name = line.substring(0,line.length()-1)+".jvto";

        files.put(name,new PrintWriter(name));
        currentFunction = name;
        working = true;


    }
    public static void newCommand(String line,PrintWriter writer) throws IOException {

        String name = line.substring(0,line.length())+".jvto";
        files.put(name,writer);
        currentFunction = name;
        working = true;


    }
    public static void saveCommand(String line) throws FileNotFoundException {
        files.get(currentFunction).println(line);

    }
    public static void close(String fileName){
        files.get(fileName).close();
      //  System.out.println("Closing");
        working = false;

    }
}
