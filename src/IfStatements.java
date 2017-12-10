
public class IfStatements {

    public static boolean ifStatement = false;
    public static String[] booleanOperators = {"greater than","less than","equals","and","or"};
    public static boolean testValidity(String condition){

        int term1,term2;
        String sTerm1,sTerm2;
        String [] proposition = Parser.parseBoolean(condition);
       // System.out.println(proposition[1].trim());

        switch (proposition[1].trim()){
            case "greater than":
                term1 = Integer.parseInt(Calculator.processDataString(proposition[0]));
                term2 =  Integer.parseInt(Calculator.processDataString(proposition[2]));
                if (term1>term2)
                    return true;
                break;
            case "less than":
                term1 = Integer.parseInt(Calculator.processDataString(proposition[0]));
                term2 =  Integer.parseInt(Calculator.processDataString(proposition[2]));
                if (term1<term2)
                    return true;
                break;
            case "equals":

                sTerm1 = Calculator.processDataString(proposition[0]);
                sTerm2 =  Calculator.processDataString(proposition[2]);
                if (sTerm1.equals(sTerm2)){
                   // System.out.println("TRUE");
                    return true;
                }
                break;

        }
        return false;
    }

}
