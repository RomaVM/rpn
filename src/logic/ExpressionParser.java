package logic;

import data_acces.DataWriter;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser {

    public void calc(List<String> data) {
        for (int i = 1; i <= Integer.parseInt(data.get(0)); i++) {
            char[] line = data.get(i).toCharArray();
            LinkedList<String> letters = new LinkedList<>();
            LinkedList<String> symbols = new LinkedList<>();
            for (Character token : line) {

                if (checkForLetters(token.toString())) {
                    letters.add(token.toString());
                } else {
                    symbols.add(token.toString());
                }
            }

            System.out.println(letters);
            System.out.println(symbols);
            DataWriter.getInstance().writeData(letters);
            DataWriter.getInstance().writeData(symbols);
        }
    }

    private int priority(String operator) {
        switch (operator) {
            case "+" :
            case "-" :
                return 1;
            case "*" :
            case "/" :
                return 2;
            case "^" :
                return 3;
            default:
                return -1;
        }
    }

    private void procOperator(LinkedList<String> letters) {
        String right = letters.removeLast();
        String left = letters.removeLast();
        letters.add(right + left);
        }


    private boolean checkForLetters(String token) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(token);
        return matcher.matches();
    }
}
