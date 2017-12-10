public class Calculator {


    public static double multiply(String line){
        double factor1=0;
        double result;
        double factor2 = 0;
        String [] factors = line.split("\\*");
        if (Parser.isNumeric(factors[0]))
            factor1 = Integer.parseInt(factors[0]);
        else if(Objects.isObject(factors[0]))
            factor1 = Double.parseDouble(Objects.retrieveValueString(factors[0]));

        if (Parser.isNumeric(factors[1]))
            factor2 = Integer.parseInt(factors[1]);
        else if(Objects.isObject(factors[1]))
            factor2 = Double.parseDouble(Objects.retrieveValueString(factors[1]));

        result =factor1*factor2;

        return  result;
    }
    public static double divide(String line){
        double factor1=0;
        double result;
        double factor2 = 0;
        String [] factors = line.split("/");
        if (Parser.isNumeric(factors[0]))
            factor1 = Integer.parseInt(factors[0]);
        else if(Objects.isObject(factors[0]))
            factor1 = Integer.parseInt(Objects.retrieveValueString(factors[0]));

        if (Parser.isNumeric(factors[1]))
            factor2 = Integer.parseInt(factors[1]);
        else if(Objects.isObject(factors[1]))
            factor2 = Integer.parseInt(Objects.retrieveValueString(factors[1]));


        result =factor1/factor2;

        return  result;
    }
    public static double add (String line){
        double factor1=0;
        double result;
        double factor2 = 0;
        String [] factors = line.split("\\+");
        if (Parser.isNumeric(factors[0]))
            factor1 = Integer.parseInt(factors[0]);
        else if(Objects.isObject(factors[0]))
            try {
                factor1 = Double.parseDouble(Objects.retrieveValueString(factors[0]));
            }catch (NumberFormatException e){
                System.out.println("MONEY FORMAT NOT VALID");
                System.exit(0);
            }
        if (Parser.isNumeric(factors[1]))
            factor2 = Integer.parseInt(factors[1]);
        else if(Objects.isObject(factors[1]))
            factor2 = Double.parseDouble(Objects.retrieveValueString(factors[1]));


        result =factor1+factor2;

        return  result;

    }
    public static double subtraction (String line){
        double factor1=0;
        double result;
        double factor2 = 0;
        String [] factors = line.split("-");
        if (Parser.isNumeric(factors[0]))
            factor1 =  Double.parseDouble(factors[0]);
        else if(Objects.isObject(factors[0]))
            factor1 = Double.parseDouble(Objects.retrieveValueString(factors[0]));

        if (Parser.isNumeric(factors[1]))
            factor2 = Integer.parseInt(factors[1]);
        else if(Objects.isObject(factors[1]))
            try {
                factor2 =  Double.parseDouble(Objects.retrieveValueString(factors[1]));
            }catch (NumberFormatException e){

                System.out.println("CHANGE IN MONEY FORMAT NOT VALID");
                System.exit(0);
            }

        result =factor1-factor2;

        return  result;

    }

    public static String processDataString(String term){
        if (Objects.isObject(term)){
            return Objects.retrieveValueString(term);
           }
        else
            return (term);

    }

}

