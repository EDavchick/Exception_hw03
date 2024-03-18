package hw03;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    public MyArraySizeException() {
        super("Вы ввели неверное колличество данных, введите через пробел:\n Фамилия Имя Отчество дата_рождения номер_телефона пол");
    }
}
