package java7onlineHWs.hw9.dao;

import org.apache.commons.io.FileUtils;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;

public class FileManager {

    private String currentFolder; //Показывает в какой папке мы находимся.
    private String root; //Главная папка.

    public FileManager(String currentFolder) {
        this.currentFolder = currentFolder;
        this.root = currentFolder;
    }

    public void listOfFiles(boolean withSize) {

        File currentFolderAsFile = new File(currentFolder);
        try {
            File files[] = currentFolderAsFile.listFiles(); // Получить все файлы в папке.
            for (File file : files) {
                if (file.isDirectory()) {

                    if (withSize) { // Папки.
                        System.out.print(file.getName() + "\\ " + FileUtils.sizeOf(file) + " - bite");
                    } else {
                        System.out.print(file.getName() + "\\ ");
                    }
                } else {
                    if (withSize) { // Файлы.
                        // С размером.
                        System.out.print(file.getName() + " " + file.length() + " - bite");
                    } else {
                        // Без.
                        System.out.print(file.getName());
                    }
                }
                System.out.println();
            }
        } catch (NullPointerException e) {
            System.out.print("Ошибка: Не верно указан путь... ");
            throw new RuntimeException(e);
        }

    }

    public void copyFile(String sourceFileName, String destFileName) {
        //Метод копирует содержимое файлов в другие файлы.

        File source = new File(currentFolder + "\\" + sourceFileName);
        File dest = new File(currentFolder + "\\" + destFileName);
        try {
            FileUtils.copyFile(source, dest);
        } catch (NullPointerException | IOException e) {
            System.out.println("Ошибка: Не верно указан путь... ");
            System.out.println("Или ошибка в чем-то другом");
            throw new RuntimeException("Произошла ошибка в методе copyFile" + e);
        }

    }

    public void createFile(String fileName) {

        File file = new File(currentFolder + "\\" + fileName);
        try {

            if (file.createNewFile())
                System.out.println("Файл создан");

        } catch (IOException | NullPointerException e) {
            System.out.println("Ошибка: Не верно указан путь... ");
            System.out.println("Или ошибка в чем-то другом");
            throw new RuntimeException(e);
        }

    }

    public void fileContent(String fileName) {

        File file = new File(currentFolder + "\\" + fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file)); //Позволит прочитать содиржимое файла.
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("Ошибка: Не верно указан путь... ");
            System.out.println("Или ошибка в чем-то другом");
            throw new RuntimeException(e);
        }

    }

    public void changeDirectory(String folderName) {

        //cd / -> root
        //cd .. -> на уровень выше

        if (folderName.equals("/")) { //Вернуться в корень
            this.currentFolder = this.root;
        } else if (folderName.equals("..")) { // Вернуться обратно
            int startLastFolderPosition = this.currentFolder.lastIndexOf("\\"); // .lastIndexOf вернет \\ крайние с лева.
            this.currentFolder = this.currentFolder.substring(0, startLastFolderPosition); // .substring вырежит все что шло после последних \\
        } else {
            this.currentFolder = this.currentFolder + "\\" + folderName;
        }

    }

    public void removeFile(String fileName) {

        File file = new File(currentFolder + "\\" + fileName);
        try {
            if (file.delete())
                System.out.println(file.getName() + " Файл удален");
        } catch (NullPointerException e) {
            System.out.print("Ошибка: Не верно указан путь... ");
            throw new RuntimeException(e);
        }

    }

    public void searchFile(String fileName) { // -> Problems

        File dir = new File(currentFolder + "\\");
        File[] files = dir.listFiles();
        boolean fileFound = false;

        try {
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().equals(fileName)) {
                        System.out.println("Файл " + fileName + " найден.");
                        fileFound = true;
                        break;
                    }
                }

            }

            if (!fileFound) {
                System.out.println("Файл " + fileName + " не найден.");
            }

        }catch (NullPointerException e){
            System.out.print("Ошибка: Не верно указан путь... ");
            throw new RuntimeException(e);
        }
    }

    public void createFolder(String folderName) {

        File file = new File(currentFolder + "\\" + folderName);
        try{
            if (!file.exists()) {
                if (file.mkdir())
                    System.out.println("Папка создана :)");
            }
        }catch (NullPointerException e){
            System.out.print("Ошибка: Не верно указан путь... ");
            throw new RuntimeException(e);
        }

    }

    public void searchText(File folder, String keyword) {
        // Получите список файлов в папке
        File[] files = folder.listFiles();

        // Обойдите все файлы в папке
        for (File file : files) {
            if (file.isDirectory()) {
                // Если это папка, выполните поиск рекурсивно
                searchText(file, keyword);
            } else {
                // Если это файл, проверьте его содержимое
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains(keyword)) {
                            System.out.println(file.getAbsolutePath());

                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Файл не был найден. Ошибка в методе searchText");
                }
            }
        }
    }
}

