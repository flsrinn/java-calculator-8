package calculator.service.ops;

public class OperationFactory {
    public static Operation of(OperationType type) {
        return switch (type) {
            case ADD -> new AddOperation();
            case SUBTRACT -> null;
            case MULTIPLY -> null;
            case DIVIDE -> null;
        };
    }
}
