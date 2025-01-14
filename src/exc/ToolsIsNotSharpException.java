package exc;

public class ToolsIsNotSharpException extends RuntimeException {
    public ToolsIsNotSharpException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return super.getMessage() + "Ошибка: Топор не наточен ";
    }


}
