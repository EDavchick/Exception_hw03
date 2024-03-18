package hw03;

public class NotANumberException extends NumberFormatException {
    public NotANumberException() {
        super("Введите номер телефона, состоящий из 7 цифр");
    }
}
