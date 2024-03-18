package hw03;

public class NotAGenderException extends RuntimeException {
    public NotAGenderException() {
        super("Вы ввели некорректные данные, впишите либо m, либо f");
    }
}
