
package ru.java.console;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;
import ru.java.main.Commands;
import ru.java.main.IllegalCommand;

/**
 *  Класс описывает текстовый человеко-машинный интерфейс.
 * @author java
 */
public class ConsoleUI implements Runnable, Closeable {
    /**
     * Флаг, указывающий на то, должен ли интерфейс
     * продолжать обрабатывать команды.
     * <p>
     * Переменная должна содержать значение false, чтобы
     * интрефейс продолжал получать команды из потомка.
     */
    private boolean exit;

    /**
     * Основной конструктор класса.
     * 
     * @param cls описатель перечисления, которое отражает
     *            набор команд, обрабатываемых интерфейсом
     */
//    public ConsoleUI() {
//        super(System.in, cls);
//    }

    /**
     * Выполняет обработку следующей команды из потока.
     * <p>
     * Следующая команда, содержащаяся в потоке, связанном
     * с текущим объектом, передаётся на обрабтку в метод
     * onCommand.
     */
    protected void processCommand() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("> ");
            String commandStr = sc.nextLine();
            onCommand(new Commands(commandStr));
        } catch (IllegalCommand ex) {
            System.out.print("Я такого не умею ");
        }
    }
    @Override
    public void run() {
        while (!exit) processCommand();
    }

    /**
     * Метод жизненного цикла класса.
     * <p>
     * Вызывается, когда от пользозвателя была получена
     * следующая команда.
     * 
     * @param command экземпляр перечисления E. Описывает
     *                пользовательскую команду.
     * 
     * @throws IOException в случае ощибки ввода вывода
     */
    protected void onCommand(Commands command) {}

    /**
     * {@inheritDoc}
     * @throws IOException 
     */
    @Override
    public void close() {
        exit = true;
    }
}
