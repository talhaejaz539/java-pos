package com.zbhg.mcp.pointofsale;

import com.zbhg.mcp.pointofsale.exceptions.MainControllerNotFound;
import com.zbhg.mcp.pointofsale.service.MainController;

public class ServiceMain {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        try {
            mainController.start();
        } catch (Exception exception) {
            exception.getMessage();
        }
    }
}
