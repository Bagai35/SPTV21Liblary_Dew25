package manager;

import entity.Book;

import java.io.*;

public class DataManager {




    public void saveBooks(Book[] books) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("MyBooks" );
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(books);
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла MyBooks");
        } catch (IOException e) {
            System.out.println("Ошибка Ввода Вывода");
        }
    }
    public Book[] loadBooks() {
        Book[] books = new Book[0];
        try {
            FileInputStream fileInputStream = new FileInputStream("MyBooks");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            books = (Book[]) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла MyBooks");
        } catch (IOException e) {
            System.out.println("Ошибка Ввода Вывода");
        } catch (ClassNotFoundException e) {
            System.out.println("Не найден класс");
        }
        return books;
    }
}
