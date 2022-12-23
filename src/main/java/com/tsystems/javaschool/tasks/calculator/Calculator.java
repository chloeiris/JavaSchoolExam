package com.tsystems.javaschool.tasks.calculator;


public class Calculator {

    /**
     * Evaluate statement represented as string.
     *
     * @param statement mathematical statement containing digits, '.' (dot) as decimal mark,
     *                  parentheses, operations signs '+', '-', '*', '/'<br>
     *                  Example: <code>(1 + 38) * 4.5 - 1 / 2.</code>
     * @return string value containing result of evaluation or null if statement is invalid
     */

    public String evaluate(String statement) {

        String[] digits = statement.split("[*+-/]");
        String[] symbols = statement.split("\\d");

        /* * The symbols array has an empty space at the beginning which I cannot remove,
        that is why the end result is 8 instead of 9.
         * I have tried to remove it with the following methods without success:
         1. String[] new_ = new String[symbols.length-1];
            for (int i = 0; i< symbols.length; i++) {
                if(symbols[i] != (""))
                    new_[i] = symbols[i];
                }
         2. symbols = ArrayUtils.remove(symbols, 0);
        */

        int operation = Integer.parseInt(digits[0]);
        for(int i = 0; i < symbols.length-1; i++) {
            if(symbols[i].equals("+"))
                operation += Integer.parseInt(digits[i+1]);
            else if(symbols[i].equals("-"))
                operation -= Integer.parseInt(digits[i+1]);
            else if(symbols[i].equals("*"))
                operation *= Integer.parseInt(digits[i+1]);
            else if(symbols[i].equals("/"))
                operation /= Integer.parseInt(digits[i+1]);
            else
                System.out.println("Null");
        }

        return Integer.toString(operation);


    }
}

class CalculatorImpl {
    public static void main(String[] args) {

        Calculator c = new Calculator();
        System.out.println(c.evaluate("1+2+3+4"));


    }


}


