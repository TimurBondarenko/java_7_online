package java7onlineHWs.hw9;

import java.io.File;
import java.util.Scanner;

public class MainHW9 {

    public static void main(String[] args) {

        menu();

        //Не забудь это вывести на экран при запросе!
        String path = "D:\\Java_7_Hws\\Java7HWs\\root";

        FileManager fileManager = new FileManager(path);

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        //Если input не будет = EXIT, програма продолжит работу.
        while (!input.equals(Commands.EXIT)){
            String[] tokens = input.split(" ");
            String command = tokens[0]; //Где находимся.
            switch (command) {
                case Commands.LIST_OF_FILES -> fileManager.listOfFiles(false);
                case Commands.LIST_OF_FILES_WITH_SIZE -> fileManager.listOfFiles(true);
                case Commands.COPY_FILE -> {  //Копировать файл.
                    String sourceFileName = tokens[1]; //Что хотим скопировать.
                    String destFileName = tokens[2]; //Куда.
                    fileManager.copyFile(sourceFileName, destFileName);
                }
                case Commands.CREATE_FILE -> {
                    String fileName = tokens[1];
                    fileManager.createFile(fileName);
                }
                case Commands.FILE_CONTENT -> {
                    String fileName = tokens[1];
                    fileManager.fileContent(fileName);
                }
                case Commands.CANGE_DIRECTORY -> {
                    String folderName = tokens[1];
                    fileManager.changeDirectory(folderName);
                }
            }
            input = scanner.nextLine();
        }

    }

    public static void menu(){

        System.out.println("Меню:");
        System.out.println("Список всех файлов - 1");
        System.out.println("Список всех файлов с размером - 2");
        System.out.println("Копировать файл - 3, укажите какой в какой файл");
        System.out.println("Создание файла - 4");
        System.out.println("Показать содержимое файла - 5, укажите файл");
        System.out.println("Изменить директорий - 6, Укажите файл");
        System.out.println("Выход - exit");
        System.out.println(">>> Дополнительные команды:\n 6 .. - Вернуться обратно\n 6 / - Вернуться в корень");

    }

}
