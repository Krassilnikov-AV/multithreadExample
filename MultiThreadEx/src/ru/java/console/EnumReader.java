/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.java.console;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Модель потокового объекта, позволяющего читать из
 * преданного потока экземпляры перечисления, описанного
 * типом Е.
 * 
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 * @param <E> перечисление, объекты которого будут вычитаны
 *            из потока.
 */
public class EnumReader<E extends Enum<E>> implements Closeable {
    /**
     * Читатель потока
     */
    private BufferedReader in;

    /**
     * Описатель типа перечисления, описанного параметром
     * шаблона
     */
    private Class<E> cls;

    /**
     * Основной констуктор класса.
     * 
     * @param stream поток, в котором ожидаются экземпляры
     *               перечисления.
     * @param cls описатель типа перечисления, описанного
     *            параметром шаблона Е
     */
    public EnumReader(InputStream stream, Class<E> cls) {
        this.cls = cls;
        in  = new BufferedReader(new InputStreamReader(stream));
    }
    /**
     * Возвращает следующий экземпляр пересиления из потока.
     * 
     * @return экземпляр типа E
     * 
     * @throws IOException в случае ошиюки ввода/вывода
     */
    public final E next() throws IOException {
        try {
            return E.valueOf(cls, in.readLine());
        } catch (IllegalArgumentException e) {
            throw new IOException(e.getMessage(), e);
        }
    }
    /**
     * ОСвобождает ресурсы, связанные с экземпляром класса.
     * 
     * @throws IOException в случае ошибки ввода/вывода
     */
    @Override
    public void close() throws IOException {
        in.close();
        in = null;
        cls = null;
    }
}
