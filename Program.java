package hw03;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        // Приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом
        // <Фамилия> <Имя> <Отчество> <дата_рождения> <номер_телефона> <пол>
        Scanner scanner = new Scanner(System.in);
        System.out.println("Put data: ");
        String next = scanner.nextLine();
        String[] split = next.split(" ");

        // Приложение должно проверить введенные данные по количеству
        if(split.length != 6) throw new MyArraySizeException();

        // Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы
        try {
            LocalDate date = LocalDate.parse(split[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeException e){
            throw new NotADateException();
        }
        try {
            Integer phone = Integer.parseInt(split[4]);
        } catch (NumberFormatException e){
            throw new NotANumberException();
        }

        Character last = split[5].charAt(0);
        if(last == 'm' || last == 'f')
            System.out.println("ok");
        else throw new NotAGenderException();

        // Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку
        String surname = split[0];
        String fileName = split[0] + ".txt";

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName, true);
            if(fileName != surname){
                fileWriter.write(Arrays.toString(split) + "\n");
                fileWriter.flush();
            } else {
                // Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                writer.write(Arrays.toString(split) + "\n");
                //Не забудьте закрыть соединение с файлом.
                writer.close();
            }
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
}
