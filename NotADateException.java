package hw03;

import java.time.DateTimeException;

public class NotADateException extends DateTimeException {
    public NotADateException() {
        super("Введите дату корректно, как: дд.мм.гггг");
    }
}
