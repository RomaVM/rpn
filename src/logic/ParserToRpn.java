package logic;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserToRpn {

    private boolean isLetter(String token) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(token);
        return matcher.matches();
    }

    private Map<String, Integer> priority() {
        Map<String, Integer> priority = new HashMap<>();
        priority.put("^", 3);
        priority.put("/", 2);
        priority.put("*", 2);
        priority.put("+", 1);
        priority.put("-", 1);
        priority.put("(", 0);
        return priority;
    }

    private String queueToString(Queue<String> queue) {
        StringBuilder result = new StringBuilder();
        for (String element : queue) {
            result.append(element);
        }
        return result.toString();
    }

    public String convertInfixToRPN(String[] infixNotation) {
        Queue<String> Q = new LinkedList<>();
        Stack<String> S = new Stack<>();

        for (String token : infixNotation) {
            if ("(".equals(token)) {
                S.push(token);
                continue;
            }

            if (")".equals(token)) {
                while (!"(".equals(S.peek())) {
                    Q.add(S.pop());
                }
                S.pop();
                continue;
            }

            if (priority().containsKey(token)) {
                while (!S.empty() && priority().get(token) <= priority().get(S.peek())) {
                    Q.add(S.pop());
                }
                S.push(token);
                continue;
            }

            if (isLetter(token)) {
                Q.add(token);
                continue;
            }

            throw new IllegalArgumentException("Invalid input");
        }

        while (!S.isEmpty()) {
            Q.add(S.pop());
        }
        return queueToString(Q);
    }
}
