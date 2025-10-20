package calculator.service.ops;

import java.util.ArrayList;


public interface Operation {
    int apply(ArrayList<String> tokens);
}
