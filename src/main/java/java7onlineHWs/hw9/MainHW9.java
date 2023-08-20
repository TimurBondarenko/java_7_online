package java7onlineHWs.hw9;

import java.io.File;
import java.util.Scanner;

public class MainHW9 {

    public static void main(String[] args) {

        MenuBoard.menu(); // Табло меню

        //Не забудь это вывести на экран при запросе!
        String path = "D:\\Java_7_Hws\\Java7HWs\\root";
        File folder = new File(path);
        FileManager fileManager = new FileManager(path);

        File file = new File(path);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        //Если input не будет = EXIT, програма продолжит работу.
        while (!input.equals(Commands.EXIT)){
            String[] tokens = input.split(" ");
            String command = tokens[0]; //Где находимся.

            switch (command) {
                case Commands.DIRECTORY -> System.out.println(">>> " + path);
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
                case Commands.REMOVE_FILE -> {
                    String fileName = tokens[1];
                    fileManager.removeFile(fileName);
                }
                case Commands.SEARCH_FILE -> {
                    String fileName = tokens[1];
                    fileManager.searchFile(fileName);
                }
                case Commands.CREATE_FOLDER -> {
                    String folderName = tokens[1];
                    fileManager.createFolder(folderName);
                }
                case Commands.SEARCH_TEXT -> {
                    String textName = tokens[1];
                    fileManager.searchText(folder, textName);
                }

            }
            input = scanner.nextLine();

        }

    }

}
