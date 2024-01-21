package com.zbhg.mcp.pointofsale;

import com.zbhg.mcp.pointofsale.exceptions.MainControllerNotFound;
import com.zbhg.mcp.pointofsale.service.MainController;

public class ServiceMain {
    public static void main(String[] args) {
        System.out.println("21 January 2024 11:30 AM");
        MainController mainController = new MainController();
        try {
            mainController.start();
        } catch (Exception exception) {
            exception.getMessage();
        }
    }
}
