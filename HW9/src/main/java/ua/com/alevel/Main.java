package ua.com.alevel;

import ua.com.alevel.controller.FileController;

public class Main {
    public static void main(String[] args) {
        String path = "D:\\Java_7_Hws\\Java7HWs\\root"; // Вот что это??? а если у меня не винда и вообще другие пути?
        // цель была сделать файловую систему для всего твоего компьютера

        FileController fileController = new FileController();
        fileController.menu();
        fileController.crud(path);
    }
}