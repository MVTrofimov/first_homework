package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class Runner {


    private final FileManager fileManager;

    private final Repository repository;


    @Autowired
    public Runner(FileManager fileManager, Repository repository) {
        this.fileManager = fileManager;
        this.repository = repository;
    }

    public void start() throws IOException {

        if (fileManager instanceof InitFileManager){
            ((InitFileManager) fileManager).initializationFromFile();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int choice = -1;

        while (true){
            System.out.println("---------МЕНЮ---------");
            System.out.println("1 - Добавление контакта");
            System.out.println("2 - Удаление контакта");
            System.out.println("3 - Вывести все контакты");
            System.out.println("4 - Сохранение контактов в файл");
            System.out.println("5 - Завершение работы");

            choice = Integer.parseInt(reader.readLine());

            if (choice == 1){
                System.out.print("Введите контакт: ");
                String str = reader.readLine();
                String[] line = str.split(";");
                if (!line[0].matches("^[а-яА-Я]+\\s[а-яА-Я]+\\s[а-яА-Я]+$")){
                    System.out.println("Некорректный формат ФИО");
                } else if (!line[1].matches("^(\\+[0-9]{9})$")) {
                    System.out.println("Некорректный формат номера телефона");
                } else if (!line[2].matches("^.+@.+\\..+$")) {
                    System.out.println("Некорректный формат email");
                } else {
                    repository.add(str);
                    System.out.println("Контакт сохранен");
                }
            } else if (choice == 2){
                System.out.print("Введите email: ");
                String str = reader.readLine();
                if (!str.matches("^.+@.+\\..+$")){
                    System.out.println("Некорректный формат email");
                } else if (repository.containsKey(str)){
                    repository.delete(str);
                    System.out.println("Контакт удален");
                } else {
                    System.out.println("Контакт не найден");
                }
            } else if (choice == 3) {
                repository.showAll();
            } else if (choice == 4){
                fileManager.loadToFile();
            } else if (choice == 5) {
                break;
            }
        }


    }

}
