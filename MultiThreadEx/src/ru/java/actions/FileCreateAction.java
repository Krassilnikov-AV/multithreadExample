
package ru.java.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author java
 */
public class FileCreateAction implements Action {

    Path source;

    public FileCreateAction(String source) {
        this.source = Paths.get(source);
    }

    public void start() {
        new Thread(this).start();
        System.out.println("Запускаем поток создания");
    }

    public void run() {
        try {
            Files.createFile(source);
            System.out.println("\nСоздание " + 
          source + " завершено.\n> ");
        } catch (IOException ex) {
            System.out.println("Ошибка создания файла"
                    + ex.getMessage());
        }
    }

    @Override
    public void close() throws Exception {
        source = null;
    }
}
