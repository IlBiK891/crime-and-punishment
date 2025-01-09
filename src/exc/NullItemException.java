package exc;

public class NullItemException extends Exception {
    public NullItemException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "Ошибка при попытке использовать scissors ";
    }

}
