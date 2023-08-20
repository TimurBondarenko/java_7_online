package ua.com.alevel.controller;

import ua.com.alevel.service.FileManager;

import java.io.File;
import java.util.Scanner;

public class FileController {

    public void crud(String path) {
        FileManager fileManager = new FileManager(path);
        File folder = new File(path);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        //Если input не будет = EXIT, програма продолжит работу.
        while (!input.equals("exit")) {
            try {

                String[] tokens = input.split(" ");
                String command = tokens[0]; //Где находимся.

                switch (command) {
                    case "0" -> System.out.println(">>> " + path);
                    case "1" -> fileManager.listOfFiles(false);
                    case "2" -> fileManager.listOfFiles(true);
                    case "3" -> {  //Копировать файл.
                        String sourceFileName = tokens[1]; //Что хотим скопировать.
                        String destFileName = tokens[2]; //Куда.
                        fileManager.copyFile(sourceFileName, destFileName);
                    }
                    case "4" -> {
                        String fileName = tokens[1];
                        fileManager.createFile(fileName);
                    }
                    case "5" -> {
                        String folderName = tokens[1];
                        fileManager.createFolder(folderName);
                    }
                    case "6" -> {
                        String folderName = tokens[1];
                        fileManager.changeDirectory(folderName);
                    }
                    case "7" -> {
                        String fileName = tokens[1];
                        fileManager.removeFile(fileName);
                    }
                    case "8" -> {
                        String fileName = tokens[1];
                        fileManager.searchFile(fileName);
                    }
                    case "9" -> {
                        String fileName = tokens[1];
                        fileManager.fileContent(fileName);
                    }
                    case "10" -> {
                        String textName = tokens[1];
                        fileManager.searchText(folder, textName);
                    }

                }
                input = scanner.nextLine();

            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Ошибка: Вы не ввели данные");
                return;
            }
        }

    }

    public void menu() {

        System.out.println("Меню:");
        System.out.println("Показать текущий путь - 0");
        System.out.println("Список всех файлов - 1");
        System.out.println("Список всех файлов с размером - 2");
        System.out.println("Копировать файл - 3, укажите какой в какой файл");
        System.out.println("Создание нового файла - 4");
        System.out.println("Создание новой папки - 5");
        System.out.println("Изменить директорий - 6, укажите файл");
        System.out.println("Удаление файла - 7, укажите файл");
        System.out.println("Найти файл 8, Укажите файл");
        System.out.println("Показать содержимое файла - 9, укажите файл");
        System.out.println("Поиск текста во всех файлах и папках по указанной директории 10, укажите текст");
        System.out.println("Выход - exit");
        System.out.println(">>> Дополнительные команды:\n 6 .. - Вернуться обратно\n 6 / - Вернуться в корень");

    }
}
