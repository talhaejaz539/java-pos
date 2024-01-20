package com.zbhg.mcp.pointofsale.service;

import java.util.Scanner;

public class MainController {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        do {
            mainMenu();

            System.out.print("\n Press 1 to 5 to select an option: ");
            String inp = scanner.nextLine();
            input = Integer.parseInt(inp);

            if (input == 1)
            {
                ItemsView.ItemsMenu();
            }
            else if (input == 2)
            {
                //CustomersView.CustomersMenu();
            }
            else if (input == 3)
            {
                //SalesView sales = new SalesView();
                //sales.Sales();
            }
            else if (input == 4)
            {
                //PaymentsView.Payment();
            }
        } while (input != 5);
        scanner.close();
    }

    public static void mainMenu() {
        System.out.print("\033[H\033[2J"); // Clear the console
        System.out.println("\n\n\t\t\t\t POS Terminal \n\n");
        System.out.println("\tMain Menu\n");
        System.out.println("\t 1 - Manage Items");
        System.out.println("\t 2 - Manage Customers");
        System.out.println("\t 3 - Make New Sale");
        System.out.println("\t 4 - Make Payment");
        System.out.println("\t 5 - Exit");
    }
}
