
package ru.java.main;

import java.util.Arrays;

/**
 * Обрабатываемые приложением команды.
 */
public class Commands {

    public enum Command {
        move,
        copy,
        exit,
        delete,
        create,
    }
    public Command comm;
    public String[] param;

    public Commands(String input) throws IllegalCommand {
        String[] parts = input.trim().split(" +");
        switch (parts[0]) {
            case "copy":
                comm = Command.copy;
                break;
            case "move":
                comm = Command.move;
                break;
            case "exit":
                comm = Command.exit;
                break;
            case "delete":
                comm = Command.delete;
                break;
            case "create":
                comm = Command.create;
                break;
            default:
                throw new IllegalCommand("Не удалось распознать команду: " + input);
        }
        param = Arrays.copyOfRange(parts, 1, parts.length);
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder(comm.toString()
        + " Параметры: ");
        for(String s:param) {
            sb.append(" ").append(s);
        }
        return sb.toString();
    }
}
