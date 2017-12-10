import java.io.*;
import java.util.Scanner;

public class DbManager {
   private static File db = new File("Db.jtdb");
    public static void store(String line) throws IOException {
        String [] expression = line.split(" ");
        FileWriter writer = new FileWriter(db.getAbsoluteFile(),true);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write(expression[1]+" "+Objects.retrieveValueString(expression[1])+"\n");
        bw.flush();
        bw.close();
        writer.close();
        Scanner sc = new Scanner(db);

    }
    public static void load (String line) throws FileNotFoundException {
        Scanner sc = new Scanner(db);
        String [] expression = line.split(" ");

        while (sc.hasNextLine()){
            String data =sc.nextLine();
            if (data.contains(expression[1])){
                String [] sentence = data.split(" ");
                data = "";
                for(int i = 1;i<sentence.length;i++){
                data +=sentence[i]+" ";}
                Objects.add(expression[2],data);
                break;
            }
        }
    }
    public static void delete(String line) throws IOException {
        String [] expression = line.split(" ");
        Scanner sc = new Scanner(db);

            String document = "";
        while(sc.hasNextLine()){
            String ln = sc.nextLine();
            if (!ln.contains(expression[1])){
                document+=ln+"\n";


        }}
        PrintWriter writer = new PrintWriter(db);

        writer.close();

    }
}
