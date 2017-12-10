import java.util.Scanner;

public class SyntaxManager {
    private static String[] commands = {"is","print","if",":","end","function","endCon","do","close","println","loop","quit","store","load","del"};


    public static boolean containsCommand(String line){
        for (String a : commands){
            if (line.toLowerCase().contains(a))
                return true;
        }
        return false;
    }

    public static String identifyCommand(String line){
        for (String a : commands){
            if (line.toLowerCase().contains(a))
                return a;
        }

        return null;
    }

    public static void commandPrint(String line){
        String [] code = line.split(" ");
        String restOfLine = "";
        for (int i = 1;i<code.length;i++ )
            restOfLine+= code[i]+" ";
        if (Objects.isObject(code[1]))
            System.out.print(Objects.findByKey(code[1])+" ");
        else if (Parser.hasOperationSign(restOfLine))
            System.out.print(String.valueOf(SyntaxManager.processInt(line.substring(line.indexOf(code[1]),line.length())))+" ");
        else
            System.out.print((restOfLine)+" ");

    }
    public static void commandPrintln(String line){
        String [] code = line.split(" ");
        String restOfLine = "";
        for (int i = 1;i<code.length;i++ )
            restOfLine+= code[i]+" ";
        if (Objects.isObject(code[1])){
            System.out.println();
            System.out.println(Objects.findByKey(code[1])+" ");}
        else if (Parser.hasOperationSign(restOfLine)){
            System.out.println();
            System.out.println(String.valueOf(SyntaxManager.processInt(line.substring(line.indexOf(code[1]),line.length())))+" ");}
        else{
            System.out.println();
            System.out.println((restOfLine)+" ");}

    }
    public static void addVar(String line){
        String [] code = line.split(" ");
        String restOfLine = "";
        double opResult;

        if(Parser.hasOperationSign(line.substring(line.indexOf(code[2]),line.length()))){
            opResult = SyntaxManager.processInt(line.substring(line.indexOf(code[2]),line.length()));

            Objects.add(code[0],String.valueOf(opResult));}
            else if (Parser.isNumeric(line.substring(line.indexOf(code[2]),line.length())))
                Objects.add(code[0],(line.substring(line.indexOf(code[2]),line.length())));
        else if (code[2].equals("INPUT")){
            System.out.println();
            Scanner sc = new Scanner(System.in);
            String content = sc.nextLine();
            if (Parser.hasOperationSign(content))
               content = String.valueOf(SyntaxManager.processInt(content));
            Objects.add(code[0],content);
        }
        else{
        for (int i = 2;i<code.length;i++ ){
            restOfLine+= code[i]+" ";}
        Objects.add(code[0], restOfLine);}

    }
    private static double processInt(String line){

        char []elements = line.toCharArray();
        double result = 0;
        for (int i =0; i<elements.length;i++){
            switch (elements[i]){
                case '+':
                    result = Calculator.add(line);
                    break;
                case '-':
                    result = Calculator.subtraction(line);
                    break;
                case '*':

                   result= Calculator.multiply(line);
                    break;
                case '/':
                    result = Calculator.divide(line);
                    break;

            }
        }
        return result;
    }



}


