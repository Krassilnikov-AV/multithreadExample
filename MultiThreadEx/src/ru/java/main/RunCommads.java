
package ru.java.main;
import ru.java.actions.FileCopyAction;
import ru.java.actions.FileCreateAction;
import ru.java.actions.FileDeleteAction;
import ru.java.actions.FileMoveAction;
import ru.java.console.ConsoleUI;
/**
 *
 * @author java
 */
public class RunCommads extends ConsoleUI{
     public static void main(String[] args) {
        // new FileMoveAction("README2.md","README3.md").start();
//        Commands c = null;
//        try {
//            c = new Commands("cepy f1.txt f2.txt");
//        } catch (IllegalCommand ex) {
//            System.out.println("Искл:" + ex.getMessage());
//        }
//        System.out.println("c = " + c.toString());
        new RunCommads().run();
    }
     
     @Override
    protected void onCommand(Commands command) {
        switch (command.comm) {
            case copy:
                new FileCopyAction(command.param[0],
                        command.param[1]).start();
                System.out.println("Запущена команда copy");
                break;
            case move:
                new FileMoveAction(command.param[0],
                        command.param[1]).start();
                System.out.println("Запущена команда move");
                break;
            case exit:
                close();
                break;
            case create:
                new FileCreateAction(command.param[0]).start();
                System.out.println("Запущена команда create");
                break;
            case delete:
                new FileDeleteAction(command.param[0]).start();
                System.out.println("Запущена команда delete");
                break;
                /*
                 * TODO №9 Обработайте необработанные команды
                 */
        }
    }
}
