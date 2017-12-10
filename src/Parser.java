
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Parser {

    public static boolean isNumeric(String line) {

        int result = 0;
        try {
            int number = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static int dataType(String line){
        if (isNumeric(line))
            return 0;
        else if(line.contains("true")||line.contains("false"))
            return 1;
        else
            return 2;
    }

    public static void readLine(String line) throws IOException {

        if (SyntaxManager.containsCommand(line)) {
            if (SavedCommands.working){
                if (SyntaxManager.identifyCommand(line).equals("close"))
                    SavedCommands.close(SavedCommands.currentFunction);
               // System.out.println(SavedCommands.currentFunction);
                SavedCommands.saveCommand(line);

             if (SyntaxManager.identifyCommand(line).equals("end")&&SavedCommands.currentFunction.equals("ifStatement.jvto")){
                SavedCommands.close(SavedCommands.currentFunction);
                if (IfStatements.ifStatement )
                SavedCommands.run(SavedCommands.currentFunction);
            }}


            if (!SavedCommands.working){
                if (SyntaxManager.identifyCommand(line).equals("do")){
                    //System.out.println("Doing: "+line.substring(2));
                    SavedCommands.run(line.substring(2));

                }
                if (SyntaxManager.identifyCommand(line).equals("store")){
                    //System.out.println("Doing: "+line.substring(2));
                   DbManager.store(line);

                }
                if (SyntaxManager.identifyCommand(line).equals("loop")){
                    //  System.out.println("Doing: "+line.substring(4));
                    while(1!=0) {
                        SavedCommands.run(line.substring(4));
                    }
                }
                if (SyntaxManager.identifyCommand(line).equals("quit")){
                    //  System.out.println("Doing: "+line.substring(4));
                    System.exit(0);

                }
                if (SyntaxManager.identifyCommand(line).equals("load")){
                    //  System.out.println("Doing: "+line.substring(4));
                    DbManager.load(line);

                }
                if (SyntaxManager.identifyCommand(line).equals("del")){
                    //  System.out.println("Doing: "+line.substring(4));
                    DbManager.delete(line);

                }
                if (SyntaxManager.identifyCommand(line).equals(":")){
                    //System.out.println("yayaya");
                    SavedCommands.newCommand(line);
                }
                if (SyntaxManager.identifyCommand(line).equals("if") || SyntaxManager.identifyCommand(line).equals("then")) {
                        IfStatements.ifStatement =IfStatements.testValidity(line);
                   // System.out.println( IfStatements.ifStatement);

                        SavedCommands.newCommand("ifStatement",new PrintWriter("ifStatement.jvto"));
                    //    System.out.println("File opened");


                } else if (SyntaxManager.identifyCommand(line).equals("is"))
                    SyntaxManager.addVar(line);

                else if (SyntaxManager.identifyCommand(line).equals("print"))
                    SyntaxManager.commandPrint(line);
            }else if (SyntaxManager.identifyCommand(line).equals("println"))
                SyntaxManager.commandPrintln(line);
        }




        }

    public static Boolean hasOperationSign(String line){
        ArrayList<String> opSigns = new ArrayList<>();
        opSigns.add("+");
        opSigns.add("/");
        opSigns.add("*");
        opSigns.add("-");
        for (String s: opSigns)
            if (line.contains(s))
                return true;

        return false;
    }
    public static String[] parseBoolean(String condition){
        String [] sentence = condition.split(" ");

        String[] finalSentence = new String[3];
        finalSentence[0] = sentence[1].trim();
        finalSentence[2] = sentence[sentence.length-1].trim();
        finalSentence[1] = "";
        for (int i = 2;i<sentence.length-1;i++){
            finalSentence[1]+=sentence[i]+" ";

        }

        return finalSentence;
    }
}

