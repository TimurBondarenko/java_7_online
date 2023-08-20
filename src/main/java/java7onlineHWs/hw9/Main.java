package java7onlineHWs.hw9;

import java7onlineHWs.hw9.controller.FileController;

public class Main {

    public static void main(String[] args) {

        String path = "D:\\Java_7_Hws\\Java7HWs\\root";

        FileController fileController = new FileController();
        fileController.menu();
        fileController.crud(path);

    }

}



