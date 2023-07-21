package java7onlineHWs.hw9;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

    private String currentFolder; //Показывает в какой папке мы находимся.
    private String root; //Главная папка.

    public FileManager(String currentFolder) {
        this.currentFolder = currentFolder;
        this.root = currentFolder;
    }

    public void listOfFiles(boolean withSize) {
        File currentFolderAsFile = new File(currentFolder);

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
    }

    public void copyFile(String sourceFileName, String destFileName) {
        //Метод копирует содержимое файлов в другие файлы.

        File source = new File(currentFolder + "\\" + sourceFileName);
        File dest = new File(currentFolder + "\\" + destFileName);
        try {
            FileUtils.copyFile(source, dest);
        } catch (IOException e) {
            System.err.println("Произошла ошибка в методе copyFile");
        }

    }

    public void createFile(String fileName) {

        File file = new File(currentFolder + "\\" + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.err.println("Ошибка в методе createFile");
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
        } catch (IOException e) {
            System.out.println("Ошибка в методе fileContent");
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

    public void removeFile(String fileName){

        File file = new File(currentFolder + "\\" + fileName);

        if(file.delete()){
            System.out.println(file.getName() + " Файл удален");
        }else {
            System.out.println("Не удалось удалить файл");
        }

    }

    public void searchFile(String fileName) {

        File dir = new File(currentFolder + "\\");
        File[] files = dir.listFiles();
        if(files != null)
        {
            for(File file : files)
            {
                if(file.isFile() && file.getName().equals(fileName)) {
                    System.out.println("Файл " + fileName + " найден.");
                    break;
                }
            }
        }

    }

    public void createFolder(String folderName) {

        File file = new File(currentFolder + "\\" + folderName);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Папка зоздана :)");
            } else {
                System.out.println("Не удалось создать папку :(");
            }
        }
    }

}

