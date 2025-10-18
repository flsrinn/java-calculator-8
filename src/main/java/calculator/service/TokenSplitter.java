package calculator.service;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class TokenSplitter {
    public ArrayList<String> split(String input) {
        ArrayList<String> tokens = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input, ",:");

        while(st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }

        return tokens;
    }
}
